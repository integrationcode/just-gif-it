package com.gateway.utils;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


@Component
public class ZuulLogger extends ZuulFilter {
	
	private static Logger logger = LoggerFactory.getLogger(ZuulLogger.class);

	@Override
	public boolean shouldFilter() {
		logger.info("Inside method 'shouldFilter'");
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletRequest request = requestContext.getRequest();
		logger.info("{} request to {}", request.getMethod(), request.getRequestURL().toString());
		return null;
	}

	@Override
	public String filterType() {
		logger.info("Inside method 'filterType'");
		return "pre";
	}

	@Override
	public int filterOrder() {
		logger.info("Inside method 'filterOrder'");
		return 1;
	}
	

}
