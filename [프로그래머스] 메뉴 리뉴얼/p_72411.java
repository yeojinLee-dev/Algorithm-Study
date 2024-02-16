import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    boolean[] visited;
    
    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        // 1. 각 주문 정렬 (그래야 abc = cda가 됨) {
        for (int i = 0; i < orders.length; i++) {
            char[] order = orders[i].toCharArray();
            Arrays.sort(order);
            orders[i] = String.valueOf(order);
        }
        
        // 2. dfs를 이용해 각 메뉴 조합을 카운트한다. 
        for (int i = 0; i < orders.length; i++) {
            String s = "";
            // A부터 Z까지 방문표시 (ex. A -> visited[(int)A - 65])
            visited = new boolean[26];
            // 손님 한 명의 주문 중 메뉴 조합을 모두 구한다. 
            dfs(i, 0, "", orders, course);
        }
        
        // 3. n인 메뉴 조합별 count 값이 가장 큰 메뉴를 선택한다. 
        // count 값이 가장 큰 메뉴가 두 개 이상이면 다 담는다. 
        // 이를 사전순으로 오름차순 정렬해서 리턴한다. 
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> Integer.valueOf(map.get(o2)).compareTo(map.get(o1)));
        for (int i = 0; i < course.length; i++) {
            int length = course[i];
            int max = 1;
            
            for (int j = 0; j < list.size(); j++) {
                String menu = list.get(j);
                
                if (menu.length() == length) {
                    if (max == 1 && map.get(menu) > max) {
                        max = map.get(menu);   
                        answer.add(menu);
                    } else if (max > 1 && max == map.get(menu)) {
                        answer.add(menu);
                    }
                    
                } else if (menu.length() == length && max > map.get(menu))
                    break;
            }
        }
        
        Collections.sort(answer);
        
        return answer;
    }

    private void dfs(int orderNum, int start, String menu, String[] orders, int[] course) {
        if (course[course.length - 1] >= menu.length() && course[0] <= menu.length()) {
            // course에 2, 3, 4가 들어있다면 현재 menu의 길이가 2이상 4이하일 경우 map에 담는다.
						map.put(menu, map.getOrDefault(menu, 0) + 1);
        } else if (menu.length() > course[course.length - 1]) {
            return;
        }
        
        for (int i = start; i < orders[orderNum].length(); i++) {
            char c = orders[orderNum].charAt(i);
            
            if (!visited[(int)c - 65]) {
                visited[(int)c - 65] = true;
                String newMenu = menu + c;
                dfs(orderNum, i, newMenu, orders, course);
                visited[(int)c - 65] = false;
            }  
        }
    }
}
