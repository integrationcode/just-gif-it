package com.other.externalize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketMessagingAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.FormContentFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;

//@SpringBootApplication(excludeName = {"org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration"})
@SpringBootApplication(exclude = {JacksonAutoConfiguration.class, JmxAutoConfiguration.class, WebSocketMessagingAutoConfiguration.class})
@EnableAutoConfiguration
public class JustGifItApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustGifItApplication.class, args);
	}

//	@Bean
//	public FilterRegistrationBean<HiddenHttpMethodFilter> deregisterHiddenHttpFilterMethods(HiddenHttpMethodFilter filter) {
//		FilterRegistrationBean<HiddenHttpMethodFilter> bean = new FilterRegistrationBean<HiddenHttpMethodFilter>();
//		bean.setFilter(filter);
//		bean.setEnabled(false);
//		return bean;
//	}
//	
//	@Bean
//	public FilterRegistrationBean<FormContentFilter> deregisterHttpPutForm(FormContentFilter filter) {
//		FilterRegistrationBean<FormContentFilter> bean = new FilterRegistrationBean<>();
//		bean.setFilter(filter);
//		bean.setEnabled(false);
//		return bean;
//	}
	
//	@Bean
//	public FilterRegistrationBean<RequestContextFilter> deregisterRequestContextFilter(RequestContextFilter filter) {
//		FilterRegistrationBean<RequestContextFilter> bean = new FilterRegistrationBean<>();
//		bean.setFilter(filter);
//		bean.setEnabled(false);
//		return bean;
//	}
}
