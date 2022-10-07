package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
//import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//@EnableEurekaServe
@SpringBootApplication
public class UserDetailsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDetailsServiceApplication.class, args);
	}

	 @Value("${server.port:8081}")
	    private int port;

	    @Configuration
	    class RestTemplateConfig {
	        @Bean
	        @LoadBalanced        // Load balance between service instances running at different ports.
	        public RestTemplate restTemplate() {
	            return new RestTemplate(clientHttpRequestFactory());
	        }

	    }

	    private ClientHttpRequestFactory clientHttpRequestFactory() {
	        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(
	                HttpClientBuilder.create().useSystemProperties().build());
	        factory.setReadTimeout(60000);
	        factory.setConnectTimeout(60000);
	        factory.setConnectionRequestTimeout(60000);
	        return factory;
	    }
	
	
}
