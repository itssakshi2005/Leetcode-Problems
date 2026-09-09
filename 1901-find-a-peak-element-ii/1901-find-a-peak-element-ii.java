class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;

        int start=0;
        int end=n-1;
        while(start<=end){
            //finding maxRow and midCol
            int midCol=start+(end-start)/2;
            int maxRow=0;
            for(int i=1;i<m;i++){
             if(mat[i][midCol]>mat[maxRow][midCol]){
                maxRow=i;
             }
            }
            //finding peak
            int left;
            if(midCol>0){
            left=mat[maxRow][midCol-1];
            }
            else{
                left=-1;
            }
            int right;
            if(midCol<n-1){
            right=mat[maxRow][midCol+1];
            }
            else{
                right=-1;
            }

            //peak found
            if(mat[maxRow][midCol]>left &&
               mat[maxRow][midCol]>right){
                return new int[]{maxRow,midCol};
               }

            //left neighbour is bigger
            if(mat[maxRow][midCol]<left){
             end=midCol-1;
            }  
            //right neighbour is bigger
            if(mat[maxRow][midCol]<right){
            start=midCol+1;
            } 
        }
        return new int[]{-1,-1};

    }
}