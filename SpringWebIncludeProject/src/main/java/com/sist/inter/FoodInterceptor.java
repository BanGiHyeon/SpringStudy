package com.sist.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/*
 *                   FrontController : ��û �ޱ� => ���� 
 *   main.do ====== DispatcherServlet ====== HandlerMapping : Modelã��
 *                                            | @GetMapping/@PostMapping => ��� ����
 *                                              ========================   Back-end
 *                                               ���α׷��� (Model) ã��
 *                       |                       Model(Controller,Action)
 *                                                1) VO
 *                                                2) DAO
 *                                                3) Manager
 *                                                4) Service
 *                                                => �������� (���Һд�)
 *                    preHandle        => @GetMapping("main.do")
 *                                          |
 *                                        return "main/main";
 *                                          | ---> postHandle 
 *                                        ViewResolver
 *                                          | request
 *                                          | ---> afterCompletion
 *                                         JSP => Front-end
 */
// <bean�̿�> => Login
public class FoodInterceptor extends HandlerInterceptorAdapter{

	@Override
	// main.do ã���� (�� ���� ��)
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("===== preHandle() Call... ======");
		return super.preHandle(request, response, handler);
	}

	@Override
	// ViewResolver�� �Ѿ������ ��� 
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("===== preHandle() Call... ======");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	// JSP�� �Ѿ�� �� 
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("===== afterCompletion ======");
		super.afterCompletion(request, response, handler, ex);
	}
	
}
