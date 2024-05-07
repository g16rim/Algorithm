class Solution {
    public int removeDuplicates(int [] nums) {
        int k = 1; // 정답 배열 포인터
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[k] = nums[i + 1];
                k++;
            }
        }
        return k;
    }
}