package com.cyq.bookstore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Created by chenyanqiu on 2016/9/20.
 */

public class RequestInterceptor extends HandlerInterceptorAdapter {

	/* 请求被处理之后调用*/
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
//		SessionStatus sessionStatus;
		modelAndView.addObject("22","22");
	}

	/* 请求被处理之前调用*/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/* 返回值表示是否将请求拦截下来，如果返回false，请求终止。返回true，请求继续
		* handler 表示被请求的目标对象
		* */
		return super.preHandle(request, response, handler);
	}

	/* 请求结束之后调用*/
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//		做资源的销毁，关闭流等
	}

	
    
}
