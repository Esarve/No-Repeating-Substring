import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        testCase("abcabcbb", 3);
        testCase("pwwkew", 3);
        testCase("bbbbb", 1);

        // Test large alternating 1B characters.
        // Expected should be 2
        String alternatingInput = Tests.generateAlternatingString(1000000000); // 1 million characters alternating 'ab'
        testCase(alternatingInput, 2);

        // Test large string with no repeating 1B characters.
        // Expected should be 26
        String uniqueInput = Tests.generateUniqueString(1000000000); // 1 million unique characters
        testCase(uniqueInput, 26);
    }

    public static void testCase(String input, int expected) {
        int result = longestSubString(input);
        System.out.println("Input length: " + input.length());
        System.out.println("Expected: " + expected + ", Result: " + result);
        System.out.println(result == expected ? "Test passed!" : "Test failed.");
    }

    public static int longestSubString(String s) {

        if (s.length() == 0) {
            return 0;
        }

        int maxLength = 0, start = 0;

        HashSet<Character> seen = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {

            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(start));
                start++;
            }

            seen.add(s.charAt(right));

            maxLength = Math.max(maxLength, right - start + 1);
        }

        return maxLength;
    }

}
