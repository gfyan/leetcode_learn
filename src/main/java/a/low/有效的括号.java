package a.low;

import java.util.LinkedList;

/**
 * @author ziqing
 * @date 2024/1/9 22:27
 */
@SuppressWarnings("all")
public class 有效的括号 {

    /**
     * 关键字「栈」
     *
     * 题目描述：
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     * ========================
     *
     * @param s 字符串
     * @return 是否有效
     */
    public static boolean isValid(String s) {
        // 1. 如果字符串为空，或者字符串长度为0，那么直接返回false
        if (s == null || s.isEmpty()) {
            return false;
        }

        LinkedList<Character> linkedList = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)
                || '[' == s.charAt(i)
                || '{' == s.charAt(i)) {
                linkedList.push(s.charAt(i));
            } else {
                if (linkedList.isEmpty()) {
                    return false;
                }
                Character pop = linkedList.pop();
                if ('(' == pop) {
                    if (')' != s.charAt(i)) {
                        return false;
                    }
                } else if ('[' == pop) {
                    if (']' != s.charAt(i)) {
                        return false;
                    }
                } else if ('{' == pop) {
                    if ('}' != s.charAt(i)) {
                        return false;
                    }
                }
            }
        }

        return linkedList.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

}
