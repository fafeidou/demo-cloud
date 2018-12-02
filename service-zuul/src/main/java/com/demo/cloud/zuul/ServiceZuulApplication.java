package com.demo.cloud.zuul;

import com.demo.cloud.zuul.config.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@EnableZuulProxy
@EnableOAuth2Sso
@SpringBootApplication
public class ServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulApplication.class, args);
    }

    /**
     * 资源过滤器
     * @return 资源过滤器
     */
    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }
}
