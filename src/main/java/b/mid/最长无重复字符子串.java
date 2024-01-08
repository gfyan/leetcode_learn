package b.mid;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 关键字「哈希表、字符串、哈希表」
 *
 * @author ziqing
 * @date 2024/1/8 17:38
 */
@SuppressWarnings("all")
public class 最长无重复字符子串 {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        //滑动窗口的左边界
        int left = 0;
        //最大的子串长度
        int maxSize = 0;
        //滑动窗口的哈希表
        Map<Character,Integer> windowMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            //查看当前字符是否在窗口中出现过
            if (windowMap.containsKey(s.charAt(i))) {
                //出现过则需要将窗口的左边界移动到出现过的位置的下一个位置。
                //这里需要注意的是，如果出现的位置在当前窗口的左边界的左边，则不需要移动。
                left = Math.max(left, windowMap.get(s.charAt(i)) + 1);
            }
            windowMap.put(s.charAt(i), i);
            //计算当前窗口的大小，这里为什么不放在contains条件里面去是因为有可能字符串全都不重复
            maxSize = Math.max(maxSize, i - left + 1);
        }

        return maxSize;
    }

    public static void main(String[] args) {
        String s = "pwwwwwkew";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

}
