package com.design.structure.bridging;

import com.design.structure.adapter.design.IOrderAdapter;
import com.design.structure.adapter.design.MQAdapter;
import com.design.structure.adapter.design.impl.InsiderOrderAdapterService;
import com.design.structure.adapter.design.impl.POPOrderAdapterService;
import com.design.structure.bridging.channel.Pay;
import com.design.structure.bridging.channel.WxPay;
import com.design.structure.bridging.mode.IPayMode;
import com.design.structure.bridging.mode.PayCypher;
import com.design.structure.bridging.mode.PayFaceMode;

import java.math.BigDecimal;
import java.text.ParseException;

/**
 * 桥接模式的主要作⽤用就是通过将抽象部分与实现部分分离，把多种可匹配的使⽤用进⾏行行组合。
 * 说⽩白了了核⼼心实现也就是在A类中含有B类接⼝口，通过构造函数传递B类的实现，这个B类就是设计的桥
 *
 * @author wangyuj
 * @date 2020/10/29
 **/
public class APITest {
    public static void main(String[] args) throws ParseException {
/** 场景: 支付场景, 有各种第三方支付:支付宝, 微信支付, 银联支付
 * 支付方式也有: 指纹支付, 密码支付, 人脸支付
 * 现在需要做的是使用桥接模式, 将支付方和支付方式各种组合完成支付*/
        IPayMode payMode = new PayCypher();
        IPayMode payFaceMode = new PayFaceMode();
        Pay pay = new WxPay(payFaceMode);
        pay.transfer("1", "1", new BigDecimal(12));
    }
}
