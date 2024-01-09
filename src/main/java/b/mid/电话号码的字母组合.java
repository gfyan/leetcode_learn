package b.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ziqing
 * @date 2024/1/9 21:00
 */
@SuppressWarnings("all")
public class 电话号码的字母组合 {

    // 映射表，将数字映射为对应的字母，与电话按键相对应
    private static final Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    /**
     * 电话号码的字母组合
     *
     * 题目描述：
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * ========================
     *
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        List<String> resultList = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return resultList;
        }

        // 开始回溯，从digits字符串的第0位开始处理
        backtrack(resultList, new StringBuilder(), digits, 0);
        return resultList;
    }

    public static void backtrack(List<String> resultList, StringBuilder prefix, String digits, int index) {
        // 如果当前组合的长度与输入数字的长度相同，说明找到了一个完整组合
        if (prefix.length() == digits.length()) {
            resultList.add(prefix.toString());
            return;
        }

        // 获取index处数字对应的字母字符串
        String letters = phoneMap.get(digits.charAt(index));

        // 遍历字母字符串，将每个字母加到当前组合的末尾，然后递归处理下一个数字
        for (char letter : letters.toCharArray()) {
            // 将字母加入当前前缀后面
            prefix.append(letter);
            // 继续处理下一个数字
            backtrack(resultList, prefix, digits, index + 1);
            // 回溯，将前缀的最后一个字母去除，回到原来的状态，尝试其他字母
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }


    public static void main(String[] args) {
        List<String> strings = letterCombinations("321321");
        System.out.println(strings);
    }

}
