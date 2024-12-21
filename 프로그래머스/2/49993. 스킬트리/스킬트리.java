import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        ArrayList<String> skillTreeList = new ArrayList<String>();
        HashMap<Character, Integer> skillMap = new HashMap<Character, Integer>();
        
        int count = 1;
        for (int i = 0 ; i < skill.length() ; i++) {
            skillMap.put(skill.charAt(i), count);
            count++;
        }
        
        int answer = 0;
        for (String skillTree : skill_trees) {
            boolean flag = true;
            int skillTreeCount = 1;
            for (int i = 0 ; i < skillTree.length() ; i++) {
                char c = skillTree.charAt(i);
                if (skillMap.containsKey(c)) {
                    int order = skillMap.get(c);
                    if (order != skillTreeCount) {
                        flag = false;
                        break;
                    }
                    skillTreeCount++;
                }
            }
            if (flag == true) answer++;
        }
        
        return answer; 
    }
}