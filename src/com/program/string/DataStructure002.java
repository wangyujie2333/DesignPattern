package com.program.string;

import java.lang.reflect.Field;

/**
 * @Description: 二分查找的用法
 * @Author: WangYuJ
 * @Date 2018/3/15
 */
public class DataStructure002 implements Runnable {

    public static <T extends Object> T setBean(T class1, T class2) {
        try {
            Class<?> clazz1 = class1.getClass();
            Class<?> clazz2 = class2.getClass();
            Field[] fields1 = clazz1.getDeclaredFields();
            Field[] fields2 = clazz2.getDeclaredFields();

            for (int i = 0; i < fields1.length; ++i) {
                fields1[i].setAccessible(true);
                fields2[i].setAccessible(true);
                Object obg1 = fields1[i].get(class1);
                Object obg2 = fields2[i].get(class2);

                if (null != fields2[i].get(class2)) {
                    fields1[i].set(class1, fields2[i].get(class2));
                }
            }
        } catch (Exception e) {
        }
        return class1;
    }

    private static class student {
        public int age;
        public String sex;
        public String name;

        public student() {
        }

        public student(int age, String sex, String name) {
            this.age = age;
            this.sex = sex;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "student{" +
                    "age=" + age +
                    ", sex='" + sex + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        student s1 = new student(1, "www", null);
        student s2 = new student(3, null, "www");
        setBean(s1, s2);
        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }

    /**
     * @Todo: 获取 Single Element in Array;
     * @Date 2018/3/22 23:16
     * @Param [arr]
     * @Return int
     */
    public static int getSingleNo(int[] arr) {
        int l = 0, h = arr.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (m % 2 == 1) m--;
            if (arr[m] == arr[m + 1]) l = m + 2;
            else h = m;
        }
        return arr[l];
    }

    public static int getArrayCoins(int n) {
        int l = 1, h = n;
        while (l <= h) {
            int m = l + (h - l) / 2;
            long x = m * (m + 1L) / 2;
            if (x == n) return m;
            if (x < n) l = m + 1;
            else h = m - 1;
        }
        int level = 1;
        while (n > 0) {
            n -= level;
            level++;
        }
        int x = n == 0 ? level - 1 : level - 2;
        return h;
    }

    /**
     * @Todo: 求开方 二分法逼近
     * @Date 2018/3/22 22:37
     * @Param [x]
     * @Return void
     */
    public static int getSqrt(int x) {
        if (x <= 1) return x;
        int l = 1, h = x;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int sqrt = x / mid;
            if (mid == sqrt) return mid;
            if (sqrt < mid) h = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    /**
     * @Todo: 二分查找 mid 取值 h 取值 l 取值
     * @Date 2018/3/22 22:16
     * @Param [arr]
     * @Return int
     */
    public static int search(int key, int[] arr) {
        int l = 0, h = arr.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (key == arr[mid]) return mid;
            if (key < arr[mid]) h = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    public static void printNumber(int n) {
        if (n < 0) return;
        char[] num = new char[n];
        printNumber(num, -1);
    }

    public static void printNumber(char[] num, int idx) {
        if (idx == num.length - 1) {
            printNumber(num);
            return;
        }
        for (int i = 0; i < 10; i++) {
            //
            num[idx + 1] = (char) (i + '0');
            printNumber(num, idx + 1);
        }
    }

    public static void printNumber(char[] num) {
        boolean isbegin0 = true;

        for (char n : num) {
            if (n != '0' && isbegin0) isbegin0 = false;
            if (!isbegin0) System.out.print(n);
        }
        System.out.println();
    }

    /**
     * @Todo: 求整数的n次方，利用递归求解
     * @Date 2018/3/15 22:12
     * @Param [base, expend]
     * @Return double
     */
    public static double Power1(double base, int expend) {
        if (expend == 0) return 1;
        if (expend == 1) return base;
        double power = 1;
        for (int i = 0; i < expend; i++) {
            power *= base;
        }
        return power;
    }

    public static double Power(double base, int expend) {
        if (expend == 1) return base;
        if (expend == 0) return 1;
        boolean isnagtive = false;
        if (expend < 0) {
            expend = -expend;
            isnagtive = true;
        }
        double power = Power(base * base, expend / 2);
        if (expend % 2 != 0) power = power * base;
        return isnagtive ? 1 / power : power;
    }


    @Override
    public void run() {
        System.out.print("runnable is run");
        System.out.println(System.getProperty("user.dir"));
    }
}
