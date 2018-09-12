package io.better;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The type Base login application.
 *
 * @author better
 * @date create in 2018/9/12 下午7:21
 */
@SpringBootApplication
public class BaseLoginApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(BaseLoginApplication.class, args);
    }
}
