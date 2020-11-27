package com.design.behavior.command.design.cuisine.impl;

import com.design.behavior.command.design.cook.ICook;
import com.design.behavior.command.design.cuisine.ICuisine;

public class JiangSuCuisine implements ICuisine {

    private ICook cook;

    public JiangSuCuisine(ICook cook) {
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCooking();
    }
}
