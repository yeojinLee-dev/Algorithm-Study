import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        s = s.substring(2, s.length() - 2);
        String[] ary = s.split("},\\{");
                
        Arrays.sort(ary, (o1, o2) -> Integer.valueOf(o1.length()).compareTo(o2.length()));

        for (int i = 0; i < ary.length; i++) {
            for (String ss : ary[i].split(",")) {
                int num = Integer.parseInt(ss);
                
                if (!set.contains(num)) {
                    set.add(num);
                    answer.add(num);
                }
            }
        }        
        return answer;
    }
}
