package may;

public class StringCompression {
    public int compress(char[] chars) {
        /*
        1. iterate through array.
        2. save current char in a placeholder with a counter.
        3. For each next char if the value is the same, increase the counter.
            If it is not the same, append the char and its counter to a different array.
        4. return the array length.
         */

        String s = "";
        int charCounter = 0;
        char latestChar = chars[0];
        for (int i = 0; i<chars.length; i++) {
            if (chars[i] == latestChar) {
                charCounter++;
            } else {
                s = appendToCompressedFormat(s, latestChar, charCounter);
                latestChar = chars[i];
                charCounter = 1;
            }
        }
        s = appendToCompressedFormat(s, latestChar, charCounter);

        for (int i = 0; i<s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        return s.length();
    }

    public String appendToCompressedFormat(String s, char character, int counter) {
        StringBuilder sb = new StringBuilder(s);
        sb.append(character);
        if (counter > 1) {
            sb.append(counter);
        }
        return sb.toString();
    }
}