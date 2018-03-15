package com.program.string;

/**
 * @Description:数字的计算
 * @Author: WangYuJ
 * @Date 2018/3/12
 */
public class Number001 {
    /**
    * @Todo: 替换空格为%20，从后向前插入
    * @Date 2018/3/13 10:45
    * @Param [str]
    * @Return java.lang.String
    */
    public String replaceSpace(StringBuffer str){
        int len = str.length();
        for (int i = 0; i < len ; i++) {
            if(str.charAt(i) == ' ') str.append("  ");
        }
        int lennew = str.length();
        while (len >= 0 && lennew > len){
            if (' ' == str.charAt(len)){
                str.setCharAt(lennew--,'0');
                str.setCharAt(lennew--,'2');
                str.setCharAt(lennew--,'%');
            }else{
                str.setCharAt(lennew--,str.charAt(len));
            }
            len--;
        }
        return str.toString();
    }
    /**
    * @Todo: 二维数组中的查找--右边比左边大，下边比上边大
    * @Date 2018/3/12 18:18
    * @Param [arr, target]
    * @Return void
    */
    public boolean findInArr(int[][] arr, int target){
        if(null == arr || arr.length == 0 || arr[0].length == 0) return false;
        int n = arr.length,m=arr[0].length;
        int row = 0,col = m - 1;
        while (row < n && col <= 0){
            if(target == arr[row][col]) return true;
            else if(target < arr[row][col]) col--;
            else row++;
        }
        return false;
    }

    /**
    * @Todo: 计算数组重复数字--将数字i放在i个元素上
    * @Date 2018/3/12 18:15
    * @Param [numbers, length, duplication]
    * @Return java.lang.Boolean
    */
    public static Boolean duplicate(int[] numbers,int length,int[] duplication){
        if(null == numbers || length <= 0) return false;
        for (int i = 0; i < length ; i++) {
            //将数字i放在i个元素上,后面的元素是否已经在i的位置上了
            while (numbers[i] != i && numbers[i] != numbers[numbers[i]]) {
                swap(numbers, i, numbers[i]);
            }
            if(numbers[i] != i && numbers[i] == numbers[numbers[i]]){
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    private static int[] swap(int[] numbers, int i, int j) {
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
        return numbers;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 0, 3, 5, 2};
        int[] duplicate = new int[7];
        duplicate(numbers,7,duplicate);
        System.out.println(duplicate);
    }
}
