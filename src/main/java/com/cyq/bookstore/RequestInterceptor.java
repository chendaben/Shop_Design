package com.cyq.bookstore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cyq.bookstore.common.Constants;

/**
 * Created by chenyanqiu on 2016/9/20.
 * 拦截器。对于所有的请求的处理
 */

public class RequestInterceptor extends HandlerInterceptorAdapter {

	/* 请求被处理之后调用*/
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//SessionStatus sessionStatus;
		modelAndView.addObject("22","22");
	}

	/* 请求被处理之前调用*/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 跨域设置
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Content-type", "application/json;charset=UTF-8");
		response.addHeader("Cache-Control", "no-cache"); //解决IE9的REST api缓存问题
		HttpSession session=request.getSession();
		//如果session为空，则表示用户登录失效
		if (session.getAttribute(Constants.USERID)==null) {
			
		}
		/* 返回值表示是否将请求拦截下来，如果返回false，请求终止。返回true，请求继续
		* handler 表示被请求的目标对象
		* */
		return true;
	}

	/* 请求结束之后调用*/
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//		做资源的销毁，关闭流等
	}

	
    
}
