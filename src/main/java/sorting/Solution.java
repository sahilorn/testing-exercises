package sorting;

public class Solution {

    public static void main(String[] args) {
        int[] intArray = new int[]{3, 2, 4};
        int[] another = twoSum(intArray, 6);
        for (int i : another) {
            System.out.print(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return nums;
    }

}
