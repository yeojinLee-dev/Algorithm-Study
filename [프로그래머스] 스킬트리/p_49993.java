import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (int i = 0; i < skill_trees.length; i++) {
            boolean isPossible = true;
            int p = 0;   // skill의 p번째 스킬을 배울 차례
            String curSkill = skill_trees[i];
            
            for (int j = 0; j < curSkill.length(); j++) {
                if (skill.contains(Character.toString(curSkill.charAt(j)))) {
                    // 만약 순서에 맞지 않게 배운다면
                    if (curSkill.charAt(j) != skill.charAt(p)) {
                        isPossible = false;
                        break;
                    } else {
                        p += 1;
                    }
                }
            }
            if (isPossible) answer++;
        }
        return answer;
    }
}
