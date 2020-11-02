package com.design.structure.decorator.design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyuj
 * @date 2020/11/2
 **/
public class LoginSsoDecorator extends SsoDecorator {

    static Map<String, String> userAuthroMap = new HashMap<>();

    static {
        userAuthroMap.put("ww0", "ww");
        userAuthroMap.put("ww1", "ww");
    }

    public LoginSsoDecorator(HandlerInterceptor handlerInterceptor) {
        super(handlerInterceptor);
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {

        boolean success = super.preHandle(request, response, handler);
        if (!success) {
            return false;
        }
        String userId = request.substring(8);
        String methodName = userAuthroMap.get(userId);

        return "ww".equals(methodName);
    }
}
