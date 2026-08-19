class Solution {
    public int compress(char[] chars) {

        int i = 0;
        int write = 0;

        while (i < chars.length) {

            // Current character
            char ch = chars[i];

            // Count consecutive characters
            int count = 0;

            while (i < chars.length && chars[i] == ch) {
                i++;
                count++;
            }

            // Write the character
            chars[write] = ch;
            write++;

            // Write count only if count > 1
            if (count > 1) {

                String s = String.valueOf(count);

                for (char c : s.toCharArray()) {
                    chars[write] = c;
                    write++;
                }
            }
        }

        return write;
    }
}