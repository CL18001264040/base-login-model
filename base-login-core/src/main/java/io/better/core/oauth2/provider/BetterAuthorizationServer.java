package io.better.core.oauth2.provider;

import io.better.core.properties.Oauth2ClientProperties;
import io.better.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * The type Better authorization server.
 *
 * @author better
 * @date create in 2018/10/15 下午12:19
 */
@Configuration
@EnableAuthorizationServer
public class BetterAuthorizationServer extends AuthorizationServerConfigurerAdapter {

    private final SecurityProperties securityProperties;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;

    /**
     * Instantiates a new Better authorization server.
     *
     * @param securityProperties    the security properties
     * @param authenticationManager
     * @param userDetailsService
     */
    @Autowired
    public BetterAuthorizationServer(SecurityProperties securityProperties, AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
        this.securityProperties = securityProperties;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    /**
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
    }

    /**
     * 配置客户端相关
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        InMemoryClientDetailsServiceBuilder builder = clients.inMemory();

        List<Oauth2ClientProperties> clientsProp = securityProperties.getOAuth2().getClients();

        if (!ObjectUtils.isEmpty(clientsProp)) {
            for (Oauth2ClientProperties config : clientsProp) {
                builder
                        .withClient(config.getClientId())
                        .secret(config.getSecret())
                        .accessTokenValiditySeconds(config.getAccessTokenValiditySeconds())
                        .scopes(config.getScope())
                        .authorizedGrantTypes(config.getAuthorizedGrantTypes());
            }
        }
    }

    /**
     * OAuth入口配置
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager).userDetailsService(userDetailsService);
    }
}
