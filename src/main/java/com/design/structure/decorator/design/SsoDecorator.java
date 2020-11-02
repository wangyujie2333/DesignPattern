package com.design.structure.decorator.design;

/** 装饰类中有两个重点的地⽅方是；1)继承了了处理理接⼝口、2)提供了了构造函数、3)覆盖了了⽅方法preHandle
 * @author wangyuj
 * @date 2020/11/2
 **/
public class SsoDecorator implements HandlerInterceptor{

    private HandlerInterceptor handlerInterceptor;

    public SsoDecorator(HandlerInterceptor handlerInterceptor) {
        this.handlerInterceptor = handlerInterceptor;
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        return handlerInterceptor.preHandle(request, response, handler);
    }
}
