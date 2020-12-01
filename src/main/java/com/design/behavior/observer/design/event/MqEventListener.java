package com.design.behavior.observer.design.event;

/**
 * @author wangyuj
 * @date 2020/12/1
 **/
public class MqEventListener implements EventListener{
    @Override
    public void doEvent() {
        System.out.println("发消息");
    }
}
