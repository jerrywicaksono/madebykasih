package com.made.by.kasih.madebykasih;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

@Component
@Order(2)
public class LoggingInterceptor implements Filter {

	private final static Logger LOG = LoggerFactory.getLogger(LoggingInterceptor.class);

	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {
		System.out.println("Initializing filter...");
		LOG.info("Initializing filter :{}", this);
	}

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		System.out.println("this is interceptor, handle request and response");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		LOG.info("Logging Request  {} : {}", req.getMethod(), req.getRequestURI());

		ContentCachingRequestWrapper reqCacheWrapperObject = new ContentCachingRequestWrapper(
				(HttpServletRequest) request);

		ContentCachingResponseWrapper responseCacheWrapperObject = new ContentCachingResponseWrapper(
				(HttpServletResponse) response);

		chain.doFilter(reqCacheWrapperObject, responseCacheWrapperObject);

		byte[] responseArray = responseCacheWrapperObject.getContentAsByteArray();
		String responseStr = new String(responseArray, responseCacheWrapperObject.getCharacterEncoding());

		byte[] reqArray = reqCacheWrapperObject.getContentAsByteArray();
		String reqponseStr = new String(reqArray, reqCacheWrapperObject.getCharacterEncoding());

		responseCacheWrapperObject.copyBodyToResponse();
		LOG.info("Logging Request :{}", reqponseStr);
		LOG.info("Logging Response :{}", responseStr);
	}

	@Override
	public void destroy() {
		System.out.println("this is interceptor, destroy filter");
		LOG.warn("Destructing filter :{}", this);
	}
}