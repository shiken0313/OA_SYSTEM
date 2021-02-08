package com.itcast.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Login検証
 * @author sro80
 *1.配置好攔截器攔截那些請求
 *2.把這些配置放在容器中
 */


public class LoginInterceptor implements HandlerInterceptor{
	
	
	/**
	 * ターゲットを行う前に
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object loginUser = session.getAttribute("loginUser");
		
		if(loginUser != null) {
			return true;
		}
		request.setAttribute("msg","請先登入");
		request.getRequestDispatcher("/").forward(request, response);
		return false;
	}
	
	/**
	 * ターゲットを行ったあと
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
