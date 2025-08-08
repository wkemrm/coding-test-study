import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        Set<Integer> myCard = new HashSet<>();
        Set<Integer> pullCard = new HashSet<>();
        Set<Integer> remainCard = new HashSet<>();
        
        for (int i = 0 ; i < n / 3 ; i++) {
            myCard.add(cards[i]);
        }
        
        for (int i = n / 3 ; i < n ; i++) {
            remainCard.add(cards[i]);
        }
        
        int target = n + 1;
        int round = 1;
        int nextCard = n / 3;
        
        while (true) {
            if (remainCard.size() <= 0) break;
            
            int firstCard = nextCard++;
            int secondCard = nextCard++;
            pullCard.add(cards[firstCard]);
            pullCard.add(cards[secondCard]);
            remainCard.remove(cards[firstCard]);
            remainCard.remove(cards[secondCard]);
            
            boolean flag = false;
            int a = 0;
            int b = 0;
            for (int card : myCard) {
                int targetCard = target - card;
                if (myCard.contains(targetCard)) {
                    flag = true;
                    a = card;
                    b = targetCard;
                    
                    break;
                }
            }
            
            if (flag) {
                myCard.remove(a);
                myCard.remove(b);
                round++;
                continue;
            }
            if (coin < 1) break;
            
            flag = false;
            a = 0;
            b = 0;
            for (int card : myCard) {
                int targetCard = target - card;
                if (pullCard.contains(targetCard)) {
                    flag = true;
                    a = card;
                    b = targetCard;
                    break;
                }
            }
            
            if (flag) {
                myCard.remove(a);
                pullCard.remove(b);
                coin--;
                round++;
                continue;
            }
            if (coin < 2) break;
            
            flag = false;
            a = 0;
            b = 0;
            for (int card : pullCard) {
                int targetCard = target - card;
                if (pullCard.contains(targetCard)) {
                    flag = true;
                    a = card;
                    b = targetCard;
                    break;
                }
            }
            
            if (flag) {
                pullCard.remove(a);
                pullCard.remove(b);
                coin -= 2;
                round++;
                continue;
            }
            break;
        }
        
        return round;
    }
}