
package com.dhfr.retry;

import org.springframework.retry.annotation.EnableRetry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/**
 *
 * @author d.husnifahririzal
 */
@SpringBootApplication
@EnableRetry
public class RetryApplication {
    public static void main(String[] args) {
        SpringApplication.run(RetryApplication.class, args);
    }
}