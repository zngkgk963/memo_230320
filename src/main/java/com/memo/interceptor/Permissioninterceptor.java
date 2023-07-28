package com.memo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class Permissioninterceptor implements HandlerInterCeptor{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass);
	
	@Override
	public boolean preHandle(HttpServletRequet request,
			HttpServletResponse response, Object handler) {
		
		// 요청 url path를 가져온다.
		String uri = request.getRequestURI();
		logger.info("[$$$$$$$$$$$$] preHandle uri:{}");
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView mav) {
		
		logger.info("[############## postHandle]");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			Exception ex) {
		
		// jsp가 html로 최종 변환된 후
		logger.info("[@@@@@@@@@@@@@] afterCompletion");
		
	}
}
