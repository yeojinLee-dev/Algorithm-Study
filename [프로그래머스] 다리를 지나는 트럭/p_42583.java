import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 다리 위에 있는 트럭을 저장하는 큐
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;    // 다리 위에 있는 트럭의 무게 합
        int answer = 0; // 다리를 건너는 시간
        
        for (int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];
            
            // 현재 i번째 트럭을 올리기 위한 반복문
            while (true) {
                // 큐에 아무것도 없는 경우 -> i번 트럭을 올린다.
                if (q.isEmpty()) {
                    q.add(truck);
                    sum += truck;
                    answer++;
                    
                    break;
                
                // 다리 위에 트럭이 꽉 찼을 때 트럭 한 대 내림
                } else if (q.size() == bridge_length) {
                    sum -= q.poll();    // 이 때 1초 더하지 않음. 
                
                // 다리 길이만큼 큐가 차지 않았을 때
                } else {
                    // weight을 넘지 않으면 트럭을 한 대 올림
                    if (sum + truck <= weight) {
                        q.add(truck);
                        sum += truck;
                        answer++;
                        break;
                        
                    // 다리에 트럭이 꽉 차진 않았지만, 한 대 더 올릴 경우 weight을 넘는다면
                    // 이미 다리 위에 있는 트럭이 다리 길이만큼 건너게 만듦. 
                    } else {
                        q.add(0);   // 0을 넣어 다리를 꽉차게 만들고 다음 번 반복 때 트럭을 한 대 내리게 함. 
                        answer++;
                    }
                }
            }
        }
        // 지금까지 걸린 시간에 마지막 트럭이 건너는데 걸리는 시간인 다리 길이를 더하여 리턴
				// 마지막 i번째 트럭을 큐에 넣고 나면 마지막 트럭이 다리를 건너는 시간을 고려하지 않고 for문을 완료하기 때문
        return answer + bridge_length;
    }
}

