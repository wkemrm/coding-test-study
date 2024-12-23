import java.util.*;

class Solution {
    HashMap<String, Integer> costMap = new HashMap<String, Integer>();
    HashMap<String, String> rMap = new HashMap<String, String>();
    
    public void DFS(String r, int curAm) {
        String now = rMap.get(r);
        if (now.equals("-")) {
            costMap.put(now, curAm);
        } else {
            int nextAm = curAm / 10;
            costMap.put(now, costMap.getOrDefault(now, 0) + curAm - nextAm);
            if (nextAm != 0) {
                DFS(now, nextAm);
            }
        }
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for (int i = 0 ; i < enroll.length ; i++) {
            costMap.put(enroll[i], 0);
            rMap.put(enroll[i], referral[i]);
        }
        
        for (int i = 0 ; i < seller.length ; i++) {
            String sell = seller[i];
            int am = amount[i] * 100;
            int nextAm = am / 10;
            int curAm = am - nextAm;
            costMap.put(sell, costMap.getOrDefault(sell, 0) + curAm);
            DFS(sell, nextAm);
        }
        int[] answer = new int[enroll.length];
        
        for (int i = 0 ; i < enroll.length ; i++) {
            answer[i] = costMap.get(enroll[i]);
        }
        return answer;
    }
}