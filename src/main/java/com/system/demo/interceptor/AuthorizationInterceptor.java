package com.system.demo.interceptor;


import com.system.demo.annotation.Login;

import com.system.demo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 拦截器
 *
 * @author root
 */
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {
    public static final String USER_KEY = "token";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    IUserService iUserService;

    /**
     * 预处理
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Login annotation;
        if (handler instanceof HandlerMethod) {
            // 获取方法上的注解
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);

            // 如果方法上的注解为空 则获取类的注解
            if (annotation == null) {
                annotation = ((HandlerMethod) handler).getMethod().getDeclaringClass().getAnnotation(Login.class);
            }
        } else {
            return true;
        }

        // 类也没有注解
        if (annotation == null) {
            return true;
        }

        // 查询token信息


        return true;
    }

    private void writeReturnJson(HttpServletResponse response, String json) throws Exception {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);

        } catch (IOException e) {

        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
