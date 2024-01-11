package b.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ziqing
 * @date 2024/1/10 23:02
 */
@SuppressWarnings("all")
public class 括号生成 {

    /**
     * 相关标签：「字符串、动态规划、回溯」
     *
     * 题目描述：
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * =======================
     *
     * @param n 生成括号的对数
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        // 存储最终的括号组合结果
        List<String> result = new ArrayList<>();
        // 递归回溯函数，用于构建括号组合
        backtrack(result, new StringBuilder(), 0, 0, n);
        // 返回存储了所有有效括号组合的列表
        return result;
    }

    // 回溯方法，用于递归构建括号组合
    private static void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // 如果当前字符串的长度等于两倍的max（括号对数的两倍），则为有效组合
        if (current.length() == max * 2) {
            // 将当前有效组合添加到结果列表中
            result.add(current.toString());
            // 返回，以结束当前递归分支
            return;
        }

        // 如果放置的开括号数小于最大对数，可以添加一个开括号
        if (open < max) {
            // 在当前字符串后添加一个开括号
            current.append("(");
            // 递归调用，增加一个开括号的计数
            backtrack(result, current, open + 1, close, max);
            // 回溯，移除上一步添加的开括号，尝试其他可能的组合
            current.deleteCharAt(current.length() - 1);
        }

        // 如果放置的闭括号数小于已放置的开括号数，可以添加一个闭括号
        if (close < open) {
            // 在当前字符串后添加一个闭括号
            current.append(")");
            // 递归调用，增加一个闭括号的计数
            backtrack(result, current, open, close + 1, max);
            // 回溯，移除上一步添加的闭括号，尝试其他可能的组合
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(4);
        System.out.println(strings);
    }

}
