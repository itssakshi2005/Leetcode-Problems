class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result=new int[nums.length];
        int i=0,j=nums.length-1;
        int k=nums.length-1;
        while(i<=j){
            if(Math.abs(nums[i])>Math.abs(nums[j])){
                result[k]=nums[i]*nums[i];
                i=i+1;
            }
            else{
                result[k]=nums[j]*nums[j];
                j=j-1;
            }
            k=k-1;
             
        }
     return result;  
    }
}