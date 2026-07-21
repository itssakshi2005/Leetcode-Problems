class Solution {
    public String reverseWords(String s) {
        String[] words=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<words.length;i++){
            StringBuilder temp=new StringBuilder(words[i]);
            sb.append(temp.reverse());

            if(i!=words.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    
}