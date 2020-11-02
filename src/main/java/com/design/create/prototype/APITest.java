package com.design.create.prototype;

/**
 * 原型模式主要解决的问题就是创建重复对象，⽽而这部分对象内容本身⽐比较复杂，
 * ⽣生成过程可能从库或者RPC接⼝口中获取数据的耗时较⻓长，因此采⽤用克隆隆的⽅方式节省时间。
 *
 * @author wangyuj
 * @date 2020/10/29
 **/
public class APITest {
    public static void main(String[] args) throws CloneNotSupportedException {

        QuestionBankController questionBankController = new QuestionBankController();
        String paper = questionBankController.createPaper("123", "123");
        String paper1 = questionBankController.createPaper("1234", "1234");
        System.out.println(paper);
        System.out.println(paper1);
    }
}
