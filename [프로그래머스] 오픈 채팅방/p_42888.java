import java.util.*;

class Solution {
    public List<String> solution(String[] record) {
        // 유저아이디, 이름
        Map<String, String> map = new HashMap<>();
        List<String> answer = new ArrayList<>();
        
        for (int i = 0; i < record.length; i++) {
            String[] ary = record[i].split(" ");
            
            if (ary[0].equals("Enter")) {
                map.put(ary[1], ary[2]);
            } else if (ary[0].equals("Change")) {
                map.put(ary[1], ary[2]);
            }
        }
        
        for (int i = 0; i < record.length; i++) {
            String s = "";
            
            String[] ary = record[i].split(" ");
            if (ary[0].equals("Enter")) {
                s = map.get(ary[1]);
                s += "님이 들어왔습니다.";
                
                answer.add(s);
            } else if (ary[0].equals("Leave")) {
                s = map.get(ary[1]);
                s += "님이 나갔습니다.";
                
                answer.add(s);
            }
        }
        
        return answer;
    }
}
