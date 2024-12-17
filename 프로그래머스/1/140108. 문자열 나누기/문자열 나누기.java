class Solution {
    public int solution(String s) {
        String x = null;
        String result = "";
        String other = "";
        int count = 0;

        for (int i = 0 ; i < s.length() ; i++) {
            String now = String.valueOf(s.charAt(i));
            if (x == null) {
                x = now;
            }
            if (x.equals(now)) {
                result += now;
            } else {
                other += now;
            }

            if (result.length() == other.length()) {
                count++;
                result = "";
                other = "";
                x = null;
            }
        }
        if (result.length() > 0) {
            count++;
        }
        return count;
    }
}