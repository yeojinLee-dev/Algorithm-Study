import java.util.*;

class Solution {
    Set<List<Integer>> set = new HashSet<>();
    
    public int solution(String[][] relation) {
        for (int i = 0; i < relation[0].length; i++) {
            // 모든 i + 1개짜리 후보키 조합쌍을 구한다. 
            List<List<Integer>> keySet = new ArrayList<>();
            
            for (int j = 0; j < relation[0].length; j++) {
                List<Integer> keyPair = new ArrayList<>();
                keyPair.add(j);

                dfs(j, i + 1, keyPair, relation[0].length, relation);  
            }
        }
        return set.size();
    }
    
    // n개의 속성으로 이루어진 모든 후보키 쌍 keyPair를 구한다. 
    // 최소성, 유일성을 만족시키면 Set에 추가한다. 
    private void dfs(int curKeyNum, int n, List<Integer> keyPair, int totalKeyCnt, String[][] relation) {
        if (n == keyPair.size()) {
            if (isMinimal(keyPair) && isUnique(keyPair, relation)) 
                set.add(new ArrayList<>(keyPair));        
            return;
        }
        
        for (int i = curKeyNum + 1; i < totalKeyCnt; i++) {
            keyPair.add(i);
            dfs(i, n, keyPair, totalKeyCnt, relation);
            keyPair.remove(keyPair.indexOf(i));
        }
    }
    
    // keyPair가 최소성을 만족하는 키인지 확인한다.
    private boolean isMinimal(List<Integer> keyPair) {
        for (List<Integer> list : set) {
            if (keyPair.containsAll(list))
                return false;
        }
        return true;
    }
    
    // keyPair가 유일성을 만족하는 키인지 확인한다. (모든 튜플을 구별할 수 있는지 확인)
    private boolean isUnique(List<Integer> keyPair, String[][] relation) {
        Set<String> tuples = new HashSet<>();
        boolean isUnique = true;
        
        for (int i = 0; i < relation.length; i++) {
            String tuple = "";
            for (int j = 0; j < keyPair.size(); j++) 
                tuple += relation[i][keyPair.get(j)] + " ";    
            
            tuple.trim();
            
            if (!tuples.contains(tuple)) {
                tuples.add(tuple);
            } else {
                isUnique = false;        
                break;
            }
        }
        
        if (!isUnique) 
            return false;
        else {
            set.add(new ArrayList<>(keyPair));
            return true;
        }
    }
}
