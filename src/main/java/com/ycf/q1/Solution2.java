package com.ycf.q1;

/**
 * Created by yuchunfan on 2023/2/25
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution2 {
  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length - 1; i++) {
      int num = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        int num1 = nums[j];
        if (num + num1 == target) {
          return new int[] {i, j};
        }
      }
    }
    return null;
  }

  public static void main(String[] args) {

    for (int i = -1000; i < 1000; i++) {
      System.out.println(">> " + new Integer(i).hashCode());
    }

    int[] nums = new int[] {2,7,11,15};
    Solution2 solution2 = new Solution2();
    for (int i : solution2.twoSum(nums, 9)) {
      System.out.println(i);
    }
  }
}
