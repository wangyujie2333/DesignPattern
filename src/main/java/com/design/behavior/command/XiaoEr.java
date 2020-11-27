package com.design.behavior.command;

import com.design.behavior.command.design.cuisine.ICuisine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyuj
 * @date 2020/11/3
 **/
public class XiaoEr {
    private List<ICuisine> cuisines = new ArrayList<>();

    public void placeOrder() {
        for (ICuisine cuisine : cuisines) {
            cuisine.cook();
        }
        cuisines.clear();
    }
    public void order(ICuisine cuisine) {
        cuisines.add(cuisine);
    }
}
