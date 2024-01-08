package b.mid;

/**
 * @author ziqing
 * @date 2024/1/8 23:29
 */
@SuppressWarnings("all")
public class 盛最多水的容器 {

    /**
     * 采用双指针求解
     *
     * @param height 柱子的高度数组
     * @return
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        //最左边指针
        int left = 0;
        //最右边指针
        int right = height.length - 1;

        //开始循环
        while (left < right) {
            //找出两根水柱最小的一个
            int low = Math.min(height[left], height[right]);
            //计算当前指针的情况下盛水的面积
            int area = low * (right - left);
            //面积替换
            if (area > maxArea) {
                maxArea = area;
            }

            //如何移动指针，移动最小的那个指针
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int maxArea = maxArea(new int[] {2, 7, 11, 15});
        System.out.println(maxArea);
    }

}
