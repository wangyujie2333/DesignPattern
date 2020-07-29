package com.pattern.adapter;

/**
 * @author wangyuj
 * @date 2020/7/15
 **/
public class TurkeyImpl implements Turkey{
    Duck duck;

    public TurkeyImpl(Duck duck) {
        this.duck = duck;
    }

    public void turkeyCall() {
        duck.duckCall();
    }
}
