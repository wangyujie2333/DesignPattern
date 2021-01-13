package com.algorithm.thinking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wangyuj
 * @date 2021/1/5
 **/
public class T05回溯算法 {
    //全排列路径
    static List<List<Integer>> res = new LinkedList<>();
    static List<List<String>> res1 = new LinkedList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        permute(nums);
        System.out.println(res);
    }

    /**
     * 主函数，输入一组不重复的数字，返回它们的全排列
     */
    static List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    /**
     * 解决一个回溯问题就是解决一个决策树的遍历
     * 路径:已经做出决策的路径
     * 选择列表:当前可选的路径
     * 结束条件:结束决策的条件,到达树的底层
     * result = []
     * def backtrack(路径, 选择列表):
     * if 满足结束条件:
     * result.add(路径)
     * return
     * <p>
     * for 选择 in 选择列表:
     * 做选择
     * backtrack(路径, 选择列表)
     * 撤销选择
     * 路径：记录在 track 中
     * 选择列表：nums 中不存在于 track 的那些元素
     * 结束条件：nums 中的元素全都在 track 中出现
     */
    static void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

    /**
     * 输入棋盘边长 n，返回所有合法的放置
     *
     * @return
     */
    /*public static List<List<String>> resolveNQueue(int n) {
        // '.' 表示空，'Q' 表示皇后，初始化空棋盘。
        List<List<String>> board = new ArrayList<>();
        backtrack1(board, 0);
        return res1;
    }

    *//**
     * 路径：board 中小于 row 的那些行都已经成功放置了皇后
     * 选择列表：第 row 行的所有列都是放置皇后的选择
     * 结束条件：row 超过 board 的最后一行
     *//*
    static void backtrack1(List<List<String>> board, int row) {
        // 触发结束条件
        if (row == board.size()) {
            res1.add(board);
            return;
        }

        int n = board.get(row).size();
        for (int col = 0; col < n; col++) {
            // 排除不合法选择
            if (!isValid(board, row, col))
                continue;
            // 做选择
            board[row][col] = 'Q';
            // 进入下一行决策
            backtrack(board, row + 1);
            // 撤销选择
            board[row][col] = '.';
        }
    }*/
}
