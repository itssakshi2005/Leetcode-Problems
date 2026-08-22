class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result=new ArrayList<>();
        for(int[] current:intervals){
          if(result.isEmpty()){
            result.add(current);
            continue;
          }
          int[] last=result.get(result.size()-1);
          if(last[1]<current[0]){
            //no overlap
            result.add(current);
          }
          else{
            //overlap->merge
            last[1]=Math.max(last[1],current[1]);
          }
        }
        return result.toArray(new int[result.size()][]);
    }
}