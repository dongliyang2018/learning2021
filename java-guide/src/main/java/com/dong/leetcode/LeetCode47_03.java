package com.dong.leetcode;

import java.util.*;

/**
 * 全排列 II
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *  
 *
 * 提示：
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @version 1.0 2021/5/19
 * @author dongliyang
 */
public class LeetCode47_03 {

    public static void main(String[] args) {
        LeetCode47_03 code = new LeetCode47_03();
        System.out.println("code.permuteUnique(new int[] { 1,1,2 }) = " + code.permuteUnique(new int[]{1, 1, 2}));
        System.out.println("code.permuteUnique(new int[] { 1,2,3 }) = " + code.permuteUnique(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtracking(result,nums,visited,new ArrayList<>());
        return result;
    }

    private void backtracking(List<List<Integer>> result, int[] nums, boolean[] visited,List<Integer> cur) {
        if (cur.size() == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //从左到右，如果有重复的数字，使用最左边的
            if(visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            cur.add(nums[i]);
            backtracking(result, nums, visited,cur);
            visited[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}
