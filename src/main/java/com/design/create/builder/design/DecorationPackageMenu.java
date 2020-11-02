package com.design.create.builder.design;

import com.design.create.builder.Matter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyuj
 * @date 2020/10/29
 **/
public class DecorationPackageMenu implements IMenu {

    //装修清单
    private List<Matter> matterList = new ArrayList<>();
    //装修面积
    private BigDecimal area;
    //装修价格
    private BigDecimal price = BigDecimal.ZERO;
    //套餐等级
    private String grade;

    public DecorationPackageMenu() {
    }


    public DecorationPackageMenu(Double area, String grade) {
        this.area = BigDecimal.valueOf(area);
        this.grade = grade;
    }

    @Override
    public IMenu appendCeiling(Matter matter) {
        matterList.add(matter);
        price = price.add(area.multiply(matter.price()));
        return this;
    }

    @Override
    public IMenu appendCoat(Matter matter) {
        matterList.add(matter);
        price = price.add(area.multiply(matter.price()));
        return this;
    }

    @Override
    public IMenu appendFloor(Matter matter) {
        matterList.add(matter);
        price = price.add(area.multiply(matter.price()));
        return this;
    }

    @Override
    public IMenu appendTile(Matter matter) {
        matterList.add(matter);
        price = price.add(area.multiply(matter.price()));
        return this;
    }

    @Override
    public String getDetail() {
        StringBuilder detail = new StringBuilder("\r\n-------------------------------------------------------\r\n" +
                "装修清单" + "\r\n" +
                "套餐等级：" + grade + "\r\n" +
                "套餐价格：" + price.setScale(2, BigDecimal.ROUND_HALF_UP) + " 元\r\n" +
                "房屋面积：" + area.doubleValue() + " 平米\r\n" +
                "材料清单：\r\n");

        for (Matter matter : matterList) {
            detail.append(matter.scene()).append("：").append(matter.brand()).append("、").append(matter.model()).append("、平米价格：").append(matter.price()).append(" 元。\n");
        }

        return detail.toString();
    }
}
