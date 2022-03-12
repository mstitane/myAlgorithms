package longest_password;
// you can also use imports, for example:

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public static void main(String[] args) {
        int lenght = new Solution().solution("a");
        System.out.println("The longest password is " + lenght);
    }

    public int solution(String S) {
        int longest = -1;
        String[] strings = S.split("\\s");
        for (String string : strings) {
            try {
                itHasToContainOnlyAlphanumericalCharacters(string);
                itHasAnEvenNumberOfLetters(string);
                itHasOddNumberOfDigits(string);
                int length = string.length();
                if (longest < length)
                    longest = length;
            } catch (Exception e) {
               //ignore
            }
        }
        return longest;
    }

    private void itHasToContainOnlyAlphanumericalCharacters(String string) {
        final Pattern pattern = Pattern.compile("^[a-zA-Z0-9]*$", Pattern.DOTALL);
        final Matcher matcher = pattern.matcher(string);

        if (!matcher.find())
            throw new NullPointerException("not accpeted");
    }

    private void itHasAnEvenNumberOfLetters(String string) {
        final Pattern pattern = Pattern.compile("([a-zA-Z]+)", Pattern.DOTALL);
        final Matcher matcher = pattern.matcher(string);

        int count = 0;
        while (matcher.find()) {
            for (int i = 0; i < matcher.groupCount(); i++) {
                count += matcher.group(i).length();
            }
        }
        if (count % 2 != 0)
            throw new NullPointerException("not accpeted");
    }

    private void itHasOddNumberOfDigits(String string) {
        final Pattern pattern = Pattern.compile("(\\d+)", Pattern.DOTALL);
        final Matcher matcher = pattern.matcher(string);

        int count = 0;
        while (matcher.find()) {
            for (int i = 0; i < matcher.groupCount(); i++) {
                count += matcher.group(i).length();
            }
        }
        if (count % 2 == 0)
            throw new NullPointerException("not accpeted");
    }
}
