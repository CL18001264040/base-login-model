package io.better.core.validate.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * The type Validate code exception.
 *
 * @author better create in 2018/10/2 10:15
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = 6742199917539597204L;

    /**
     * Constructs an {@code AuthenticationException} with the specified message and root
     * cause.
     *
     * @param msg the detail message
     * @param t   the root cause
     */
    public ValidateCodeException(String msg, Throwable t) {
        super(msg, t);
    }

    /**
     * Constructs an {@code AuthenticationException} with the specified message and no
     * root cause.
     *
     * @param msg the detail message
     */
    public ValidateCodeException(String msg) {
        super(msg);
    }
}
