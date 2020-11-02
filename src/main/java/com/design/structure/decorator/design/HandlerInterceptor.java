package com.design.structure.decorator.design;

public interface HandlerInterceptor {

    boolean preHandle(String request, String response, Object handler);

}
