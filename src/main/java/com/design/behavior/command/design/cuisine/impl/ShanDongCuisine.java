package com.design.behavior.command.design.cuisine.impl;

import com.design.behavior.command.design.cook.ICook;
import com.design.behavior.command.design.cuisine.ICuisine;

public class ShanDongCuisine implements ICuisine {

    private ICook cook;

    public ShanDongCuisine(ICook cook) {
        this.cook = cook;
    }

    @Override
    public void cook() {
        cook.doCooking();
    }
}
