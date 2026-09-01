class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int weight:weights){
            low=Math.max(low,weight);
            high+=weight;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            int reqDays=1;
            int currWeight=0;
            for(int weight:weights){
                if(currWeight+weight>mid){
                    reqDays++;
                    currWeight=weight;
                }
                else{
                    currWeight+=weight;
                }
            }
            if(reqDays<=days){
             high=mid-1;
            }
            else{
             low=mid+1;
            }
        }
        return low;
    }
}