package com.lhqs.boot.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
* 拦截器实现
* 拦截条件，拦截那些请求
 * 将配置放在容器中
* */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    /**
    * 方法执行之前
    * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //拦截逻辑，登录检查
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        //放行条件
        if( loginUser != null ){
            return true;
        }
        //拦截后跳转页面
        //反馈信息给用户，放在session中，request只在请求作用域中有效
        session.setAttribute("msg","请先登录");
        response.sendRedirect("/");
        return false;
    }

    /**
     * 方法执行之后
    * */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 页面渲染以后
     * */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
