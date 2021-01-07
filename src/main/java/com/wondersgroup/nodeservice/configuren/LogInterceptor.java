package com.wondersgroup.nodeservice.configuren;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.unit.DataUnit;
import cn.hutool.core.util.StrUtil;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2021/1/7 16:42
 * @description: logger HandlerInterceptor  class
 */
@Slf4j
@Component
public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("处理拦截之前");
        request.setAttribute("startTime", DateUtil.current());
        log.info("访问请求的类：{}", ((HandlerMethod) handler).getBean().getClass().getName());
        log.info("访问请求的方法：{}", ((HandlerMethod) handler).getMethod().getName());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("开始处理拦截");
        Long start = (Long) request.getAttribute("startTime");
        log.info("【拦截器】耗时 " + StrUtil.toString( DateUtil.current()-start));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("处理拦截之后");
        Long start = (Long) request.getAttribute("startTime");
        log.info("【拦截器】耗时 " + StrUtil.toString( DateUtil.current()-start));
        log.error("异常信息 " + ex);
    }
}
