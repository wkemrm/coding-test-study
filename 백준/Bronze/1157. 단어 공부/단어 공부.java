import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toLowerCase();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0 ; i < s.length() ; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        Character result = null;
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (maxCount < entry.getValue()) {
                result = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        
        map.remove(result);
        boolean flag = true;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
          if (entry.getValue() == maxCount) {
              flag = false;
          }
        }
        
        if (flag) {
            System.out.print(String.valueOf(result).toUpperCase());
        } else {
            System.out.print("?");
        }
    }
}