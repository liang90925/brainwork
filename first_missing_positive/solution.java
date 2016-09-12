public class Solution {
  public int firstMissingPositive(int[] nums) {
    int i = 0;
    while(i < nums.length){
        if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != i+1 && nums[i] != nums[nums[i]-1]){
            int temp = nums[nums[i]-1];
            nums[nums[i]-1] = nums[i];
            nums[i] = temp;
        }
        else{
            i++;
        }
    }
    for(i = 0; i < nums.length; i++){
        if(i+1 != nums[i]){
            return i+1;
        }
    }
    return nums.length+1;
  }
}
