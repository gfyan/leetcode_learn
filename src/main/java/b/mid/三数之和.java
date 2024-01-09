package b.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ziqing
 * @date 2024/1/8 23:45
 */
@SuppressWarnings("all")
public class 三数之和 {

    /**
     * 三数之和，采用双指针的方式求解
     *
     * @param nums 数组
     * @return 结果
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        //先对数组进行check，如果数组为空或者长度小于3则直接返回
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        //先对数组进行排序
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // 如果当前数字等于前一个数字，则跳过这个数字，因为这个数字已经计算过了
            if (i > 0 && (nums[i] == nums[i - 1])) {
                continue;
            }
            int iNum = nums[i];
            //指定左右指针的位置
            //为什么是从i+1开始，而不是从0开始，因为i是从0开始循环上来的，如果左指针每次都从0开始的话，那么就会出现重复的情况，且浪费时间
            int left = i + 1;
            //右指针每次都是从数组的最后一个元素开始
            int right = nums.length - 1;
            while (left < right) {
                //针对左右指针的元素进行求和
                int sum = nums[left] + nums[right] + iNum;
                //sum要么大于0，要么小于0，要么等于0
                if (sum > 0) {
                    //如果sum大于0，那么就需要将右指针向左移动
                    right--;
                } else if (sum < 0) {
                    //如果sum小于0，那么就需要将左指针向右移动
                    left++;
                } else {
                    //如果sum等于0，那么就将三个元素都添加到结果集中
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(iNum);
                    list.add(nums[right]);
                    result.add(list);

                    // 跳过所有相同的左元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 跳过所有相同的右元素
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 最终将左、右指针都向中间移动一位，以寻找下一组可能的三元组
                    left++;
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

}
