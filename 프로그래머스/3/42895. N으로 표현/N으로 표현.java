import java.util.*;
class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0 ; i <= 8 ; i++) {
            list.add(new HashSet<>());
        }
        
        list.get(1).add(N);
        
        for (int i = 2 ; i <= 8 ; i++) {
            Set<Integer> now = list.get(i);
            
            for (int j = 1 ; j < i ; j++) {
                Set<Integer> pre = list.get(j);
                Set<Integer> post = list.get(i - j);
                
                for (int a : pre) {
                    for (int b : post) {
                        now.add(a + b);
                        now.add(a - b);
                        now.add(a * b);
                        if (a != 0 && b != 0) {
                            now.add(a / b);
                        }
                    }
                }
            }
            now.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }
        
        for (int i = 1 ; i <= 8 ; i++) {
            if (list.get(i).contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}