public class Tests {
    public static String generateAlternatingString(int length) {
        StringBuilder sb = new StringBuilder(length);
        String pattern = "ab";
        for (int i = 0; i < length; i++) {
            sb.append(pattern.charAt(i % pattern.length()));
        }
        return sb.toString();
    }

    public static String generateUniqueString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append((char) ('a' + (i % 26)));  // Generate repeating lowercase alphabet characters
        }
        return sb.toString();
    }
}
