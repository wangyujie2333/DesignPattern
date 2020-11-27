package com.design.behavior.command.design.cook.impl;

import com.design.behavior.command.design.cook.ICook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack) @2020
 */
public class JiangSuCook implements ICook {


    public void doCooking() {
        System.out.println("江苏厨师，烹饪苏菜，宫廷第二大菜系，古今国宴上最受人欢迎的菜系。");
    }

}
