class Solution {
    public int[] twoSum(int[] nums, int target) {
      HashMap<Integer , Integer> map = new HashMap<>();
      for(int i = 0 ; i < nums.length ; i++){
        int calc = target - nums[i];
        if(map.containsKey(calc)){
            return new int[]{map.get(calc) , i};
        }
        map.put(nums[i],i);
      }
      return new int[]{};
    }
}
