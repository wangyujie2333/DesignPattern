package com.design.behavior.observer.design;

import com.design.behavior.observer.design.event.MqEventListener;
import com.design.behavior.observer.design.event.MsgEventListener;

/**
 * @author wangyuj
 * @date 2020/12/1
 **/
public abstract class LotteryService {

    private EventManager eventManager;

    public LotteryService() {
        this.eventManager = new EventManager();
        eventManager.subscribe(EventManager.EventType.MQ,new MqEventListener());
        eventManager.subscribe(EventManager.EventType.MSG,new MsgEventListener());
    }
    public LotteryResult draw(String uId){
        LotteryResult lotteryResult = doDraw(uId);
        eventManager.notice(EventManager.EventType.MQ);
        eventManager.notice(EventManager.EventType.MSG);
        return lotteryResult;
    }
    protected abstract LotteryResult doDraw(String uId);
}
