package io.better.core.validate.filter;

import io.better.core.properties.SecurityProperties;
import io.better.core.validate.ValidateCodeBeanHolder;
import io.better.core.validate.ValidateCodeProcessor;
import io.better.core.validate.ValidateCodeType;
import io.better.core.validate.exception.ValidateCodeException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;


/**
 * @author better
 * @date create in 2018/10/10 下午2:46
 */
@Component
@Slf4j
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {

    private final SecurityProperties securityProperties;
    private final ValidateCodeBeanHolder validateCodeBeanHolder;
    private final AuthenticationFailureHandler browserAuthenticationFailureHandler;
    private final AntPathMatcher antPathMatcher;
    private Map<String, ValidateCodeType> urlMap;

    @Autowired
    public ValidateCodeFilter(SecurityProperties securityProperties, ValidateCodeBeanHolder validateCodeBeanHolder,
                              AuthenticationFailureHandler browserAuthenticationFailureHandler) {
        this.browserAuthenticationFailureHandler = browserAuthenticationFailureHandler;
        this.antPathMatcher = new AntPathMatcher();
        this.urlMap = new HashMap<>();
        this.securityProperties = securityProperties;
        this.validateCodeBeanHolder = validateCodeBeanHolder;
    }

    /**
     * Calls the {@code initFilterBean()} method that might
     * contain custom initialization of a subclass.
     * <p>Only relevant in case of initialization as bean, where the
     * standard {@code init(FilterConfig)} method won't be called.
     *
     * @see #initFilterBean()
     * @see #init(FilterConfig)
     */
    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();

        urlMap.put("/login/form", ValidateCodeType.IMAGE);
        urlMap.put("/login/sms", ValidateCodeType.SMS);
        addPropertiesUrlToMap(securityProperties.getValidate().getImg().getUrls(), ValidateCodeType.IMAGE);
        addPropertiesUrlToMap(securityProperties.getValidate().getSms().getUrls(), ValidateCodeType.SMS);
    }

    /**
     * 将配置文件中配置的需要验证码验证的url加载到map中
     *
     * @param urls 配置的url
     * @param type 拦截类型
     */
    protected void addPropertiesUrlToMap(String urls, ValidateCodeType type) {
        if (StringUtils.isNoneBlank(urls)) {
            String[] urlsArray = StringUtils.splitByWholeSeparatorPreserveAllTokens(urls, ",");
            Stream.of(urlsArray).forEach(url -> urlMap.put(url, type));
        }
    }

    /**
     * Same contract as for {@code doFilter}, but guaranteed to be
     * just invoked once per request within a single request thread.
     * See {@link #shouldNotFilterAsyncDispatch()} for details.
     * <p>Provides HttpServletRequest and HttpServletResponse arguments instead of the
     * default ServletRequest and ServletResponse ones.
     *
     * @param request
     * @param response
     * @param filterChain
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        ValidateCodeType type = getValidateCodeType(request);

        // 不为null，执行校验
        if (Objects.nonNull(type)) {

            try {
                ValidateCodeProcessor validateCodeProcessor = validateCodeBeanHolder.getValidateCodeProcessor(type.getType());
                validateCodeProcessor.validate(new ServletWebRequest(request, response), type.getType());
            } catch (ValidateCodeException e) {
                browserAuthenticationFailureHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }
        // 为null，向后执行
        filterChain.doFilter(request, response);
    }

    /**
     * 判断当前请求需要做那种类型的校验
     *
     * @param request
     * @return
     */
    private ValidateCodeType getValidateCodeType(HttpServletRequest request) {

        ValidateCodeType type = null;
        // 不是GET请求
        if (!StringUtils.equalsIgnoreCase(request.getMethod(), HttpMethod.GET.name())) {
            for (String url : urlMap.keySet()) {
                if (antPathMatcher.match(url, request.getRequestURI())) {
                    type = urlMap.get(url);
                }
            }
        }
        return type;
    }


}
