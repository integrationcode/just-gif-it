package com.payroll.ms.common;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
//@Profile("recording")
public class ZuulLoggingFilter extends ZuulFilter {
	
	private static Logger logger = LoggerFactory.getLogger(ZuulLoggingFilter.class);

	@Override
	public boolean shouldFilter() {
		// Implement condition to decide when to filter
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		//System.out.println(String.format("%s request to %s with query string %s", request.getMethod(),request.getRequestURL().toString(), request.getQueryString()));
		logger.info(String.format("%s request to %s", request.getMethod(),request.getRequestURL().toString()));
		return null;
	}

	@Override
	public String filterType() {
		/** Four types of filters
		 * 1. Pre: Executes before the request is routed
		 * 2. Route: Handles the actual routing
		 * 3. Post: After the request has been routed
		 * 4. Error: When error occurs the handling of it.
		 */
		
		return "pre";
	}

	@Override
	public int filterOrder() {
		// Order in which particular filter need to be exeucted in comparison to other filters
		return 2;
	}

}
