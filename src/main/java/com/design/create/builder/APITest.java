package com.design.create.builder;

import com.design.create.builder.ceiling.LevelOneCeiling;
import com.design.create.builder.coat.DuluxCoat;
import com.design.create.builder.design.DecorationPackageMenu;
import com.design.create.builder.design.IMenu;
import com.design.create.builder.floor.DerFloor;
import com.design.create.builder.tile.DongPengTile;
import com.design.create.factory.design.ICommodity;
import com.design.create.factory.design.StoreFactory;

/**
 * 建造者模式所完成的内容就是通过将多个简单对象通过一步步的组装构建出一个复杂对象的过程。
 * @author wangyuj
 * @date 2020/10/29
 **/
public class APITest {
    public static void main(String[] args) {

        IMenu iMenu = new DecorationPackageMenu(100.0,"豪华别野")
                .appendCeiling(new LevelOneCeiling())
                .appendCoat(new DuluxCoat())
                .appendFloor(new DerFloor())
                .appendTile(new DongPengTile());
        System.out.println(iMenu.getDetail());
    }
}
