class Solution {
    public int[] solution(int n, int s) {
        if (s / n == 0) {
            return new int[]{-1};
        }
        
        int div = s / n;
        int c = s % n;
        int count = n - c;
        int[] answer = new int[n];
        
        for (int i = 0 ; i < n ; i++) {
            if (i < count) {
                answer[i] = div;
            } else {
                answer[i] = div + 1;
            }
        }
        
        
        return answer;
    }
}