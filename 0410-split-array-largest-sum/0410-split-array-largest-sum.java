class Solution {
    public int splitArray(int[] nums, int k) {
        int low=getMax(nums);
        int high=getSum(nums);

        while(low<high){
          int mid=low+(high-low)/2;
          if(canSplit(nums,k,mid)){
            high=mid;
          }
          else{
            low=mid+1;
          }
          
        }
        return low;
    }

    public int getMax(int[] nums){
       int max=Integer.MIN_VALUE;
       for(int i:nums){
        max=Math.max(i,max);
       }
       return max;
    }
    public int getSum(int[] nums){
        int sum=0;
        for(int i:nums){
            sum=sum+i;
        }
        return sum;
    } 

    public boolean canSplit(int[] nums,int k, int target){
       int count=1;
       int currsum=0;

       for(int i:nums){
        if(currsum+i>target){
            count++;
            currsum=i;
        }
        else{
            currsum=currsum+i;
        }
       }
       return count<=k;
    }  
    
}