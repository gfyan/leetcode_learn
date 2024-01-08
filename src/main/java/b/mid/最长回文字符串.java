package b.mid;

/**
 * 相关标签「字符串、动态规划」
 *
 * @author ziqing
 * @date 2024/1/8 21:42
 */
@SuppressWarnings("all")
public class 最长回文字符串 {

    /**
     * 采用中心扩散的思维进行求解
     *
     * @param s 字符串
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // 检查以 s[i] 为中心的奇数长度回文。
            int len1 = extCenter(s, i, i);
            // 检查以 s[i] 和 s[i+1] 之间的空隙为中心的偶数长度回文。
            int len2 = extCenter(s, i, i + 1);
            // 求出最长的回文长度
            int len = Math.max(len1, len2);
            // 如果当前回文长度大于之前的回文长度，则更新回文的起始位置和结束位置
            if (len > end - start) {
                // 假设len=7  i等于3，那么start=3-(7-1)/2=0，end=3+7/2=6
                // 假设len=4  i等于1，那么start=1-(4-1)/2=0，end=1+4/2=3
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public static int extCenter(String s, int left, int right) {
        //开始扩散，防止左右的边界越界，且左右的字符相等就一直往下寻找
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // 当扩展停止时，left 和 right 分别指向回文串外的第一个不匹配的字符。
        // 所以回文串实际上是介于 left+1 和 right-1 之间的子串。
        // 所以回文串的长度是 (right-1)-(left+1)+1=right - left - 1。
        return right - left - 1;
    }

    public static void main(String[] args) {
        String s = longestPalindrome("babad");
        System.out.println(s);
    }

}
