package binary_gap;// you can also use imports, for example:

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

    private static final Logger logger = Logger.getLogger(Solution.class.getSimpleName());

    public int solution(int N) {

        String binaryStr = Integer.toBinaryString(N);
        logger.log(Level.INFO, binaryStr);
        final String regex = "1([0]+)1";

        final Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        final Matcher matcher = pattern.matcher(binaryStr);

        int max = 0;
        while (matcher.find()) {
            logger.log(Level.INFO, "Full match: {0}" , matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                logger.log(Level.INFO, "Group match: {0}" ,matcher.group(i));
                int length = matcher.group(i).length();
                if (max < length)
                    max = length;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int missing = new Solution().solution(328);
        logger.log(Level.INFO, "The smallest positive missing number is {0}" , missing);
    }
}
