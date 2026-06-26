class Solution {

   public int findDays(int[] weights,int cap){
        int d=1;
        int load=0;
        int n=weights.length;
        for(int i=0;i<n;i++){
            if(load+weights[i]>cap){
              d=d+1;
              load=weights[i];  
            }
            else{
                load+=weights[i];
            }
        }
        return d;
    }


    public int shipWithinDays(int[] weights, int days) {
       int low=Integer.MIN_VALUE;
       int high=0;
       for(int i=0;i<weights.length;i++){
        high=high+weights[i];
        low=Math.max(low,weights[i]);
       }
       while(low<=high){
        int mid=low+(high-low)/2;

        int numofdays=findDays(weights,mid);
        if(numofdays<=days){
            high=mid-1;
        }
        else{
            low=mid+1;
        }
       }
       return low;
       
    }


    
}