package a.low;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * @author ziqing
 * @date 2024/1/8 16:10
 */
@SuppressWarnings("all")
public class 两数之和 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numHash = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (numHash.containsKey(target - nums[i])) {
                return new int[]{numHash.get(target - nums[i]),i};
            }
            numHash.put(nums[i], i);
        }

        return new int[] {0, 0};
    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[] {2, 1, 7, 15}, 9);
        System.out.println(JSON.toJSONString(ints));
    }

}
