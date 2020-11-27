package com.design.behavior.command;

import com.design.behavior.command.design.cook.impl.GuangDongCook;
import com.design.behavior.command.design.cook.impl.JiangSuCook;
import com.design.behavior.command.design.cook.impl.ShanDongCook;
import com.design.behavior.command.design.cook.impl.SiChuanCook;
import com.design.behavior.command.design.cuisine.ICuisine;
import com.design.behavior.command.design.cuisine.impl.GuangDongCuisine;
import com.design.behavior.command.design.cuisine.impl.JiangSuCuisine;
import com.design.behavior.command.design.cuisine.impl.ShanDongCuisine;
import com.design.behavior.command.design.cuisine.impl.SiChuanCuisine;

/**
 * 在这个设计模式的实现过程中有如下几个比较重要的点；
 * 1. 抽象命令类；声明执行命令的接口和方法
 * 2. 具体的命令实现类；接口类的具体实现，可以是一组相似的行为逻辑
 * 3. 实现者；也就是为命令做实现的具体实现类
 * 4. 调⽤用者；处理命令、实现的具体操作者，负责对外提供命令服
 *
 * @author wangyuj
 * @date 2020/10/29
 **/
public class APITest {
    public static void main(String[] args) {
        // 菜系 + 厨师；广东（粤菜）、江苏（苏菜）、山东（鲁菜）、四川（川菜）
        ICuisine guangDoneCuisine = new GuangDongCuisine(new GuangDongCook());
        ICuisine jiangSuCuisine = new JiangSuCuisine(new JiangSuCook());
        ICuisine shanDongCuisine = new ShanDongCuisine(new ShanDongCook());
        ICuisine siChuanCuisine = new SiChuanCuisine(new SiChuanCook());

        // 点单
        XiaoEr xiaoEr = new XiaoEr();
        xiaoEr.order(guangDoneCuisine);
        xiaoEr.order(jiangSuCuisine);
        xiaoEr.order(shanDongCuisine);
        xiaoEr.order(siChuanCuisine);

        // 下单
        xiaoEr.placeOrder();

    }
}
