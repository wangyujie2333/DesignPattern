package com.program.string;

/**
 * @Description:
 * @Author: WangYuJ
 * @Date 2018/3/15
 */
public class DataStructure002 {

    public static void printNumber(int n){
        if(n<0) return;
        char[] num = new char[n];
        printNumber(num,-1);
    }
    public static void printNumber(char[] num,int idx){
        if (idx == num.length -1) {
            printNumber(num);
            return;
        }
        for (int i = 0; i < 10 ; i++) {
            //
            num[idx+1] = (char) (i + '0');
            printNumber(num,idx+1);
        }
    }
    public static void printNumber(char[] num){
        boolean isbegin0 = true;

        for (char n:num){
            if (n != '0' && isbegin0) isbegin0 = false;
            if (!isbegin0)System.out.print(n);
        }
        System.out.println();
    }
    /**
    * @Todo: 求整数的n次方，利用递归求解
    * @Date 2018/3/15 22:12
    * @Param [base, expend]
    * @Return double
    */
    public static double Power1(double base,int expend){
        if (expend == 0) return 1;
        if (expend == 1) return base;
        double power = 1;
        for (int i = 0; i < expend ; i++) {
            power *=base;
        }
        return power;
    }
    public static double Power(double base,int expend){
        if(expend == 1) return base;
        if(expend == 0) return 1;
        boolean isnagtive = false;
        if (expend<0){
            expend = -expend;
            isnagtive=true;
        }
        double power = Power(base*base,expend/2);
        if(expend%2 != 0) power=power*base;
        return isnagtive? 1/power:power;
    }
    public static void main(String[] args) {
        printNumber(4);
    }
}
