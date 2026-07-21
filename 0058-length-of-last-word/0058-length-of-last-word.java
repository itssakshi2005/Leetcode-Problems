class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        String[] word=s.split("\\s+");
        return word[word.length - 1].length();
    }
}