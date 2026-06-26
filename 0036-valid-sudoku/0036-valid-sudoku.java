class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set=new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char c=board[i][j];

                 if(c != '.') {
                String row="row"+i+"_"+c;
                String col="col"+j+"_"+c;
                String box="box"+(i/3)+(j/3)+"_"+c;

                if(set.contains(row)||set.contains(col)||set.contains(box)){
                    return false;
                }
                set.add(row);
                set.add(col);
                set.add(box);
                }

            }
        }

        return true;
    }
}