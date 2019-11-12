class Solution {
    public int maxSubArray(int[] nums) {
        
        int max_cont_sum = 0;
        int sum = 0;
        int neg = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            
            if(sum+nums[i]>=0){
                sum = sum + nums[i];
                count++;
            }
            else{
                
                sum =0;
                
            }
            
            if(neg==0){
                neg = nums[i];
            }
            else{
                neg = Math.max(neg,nums[i]);
            }
            
            max_cont_sum = Math.max(max_cont_sum, sum);
        }
        
        if(count ==0){
            max_cont_sum = neg;
        }
        return max_cont_sum;
    }
}
