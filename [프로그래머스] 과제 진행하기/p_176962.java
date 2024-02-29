import java.util.*;

class Solution {
    public List<String> solution(String[][] plans) {
        int n = plans.length;
        List<String> answer = new ArrayList<>();
        Stack<Assignment> remain = new Stack<>();
        PriorityQueue<Assignment> q = new PriorityQueue<>((o1, o2) -> Integer.valueOf(o1.start).compareTo(o2.start));
        
        for (int i = 0; i < n; i++) 
            q.offer(new Assignment(plans[i][0], plans[i][1], plans[i][2]));
        
        int i = 0;
        while (!q.isEmpty()) {
            if (!q.isEmpty()) {
                // 1. 큐에서 새로 시작하는 과제를 꺼낸다. 
                Assignment a = q.poll();
                int end = calEndTime(a.start, a.playtime);
                
                if (!q.isEmpty()) {
                    Assignment next = q.peek();
                    
                    // 2. 이 과제가 다음 과제보다 늦게 끝나면 remain에 넣는다. 
                    if (end > next.start) {
                        a.playtime -= calPlayTime(a.start, next.start);
                        remain.add(a);  
                        continue;
                    } else if (end < next.start) {
                    // 3. 해당 과제를 다 끝냈는데 다음 과제 시작시간보다 시간이 남으면 remain에 있는 과제를 한다. -> 한 개 이상 할 수도 있음. 
                        answer.add(a.name);
                        while (!remain.isEmpty()) {
                            Assignment ra = remain.pop();
                            
                            // 3-2. remain에 있는 과제를 하다가 과제를 시작해야하면 다시 remain에 넣는다. 
                            int raEnd = calEndTime(end, ra.playtime);
                            if (raEnd > next.start) {
                                ra.playtime -= calPlayTime(end, next.start);
                                remain.add(ra);
                                break;
                            } else {// 3-3. 다음 과제가 시작되기 전 remain의 과제를 완료하면 answer에 작성한다.
                                answer.add(ra.name);
                                end = raEnd;
                            }
                        }
                        continue;
                    }
                }
                answer.add(a.name);
                // 4. 새로 시작하는 모든 과제를 다하고 나면 remain에 있는 과제를 순서대로 한다. 
                while (q.isEmpty() && !remain.isEmpty()) {
                    Assignment ra = remain.pop();
                    answer.add(ra.name);
                }   
            }
        }
        return answer;
    }
            
    private class Assignment {
        String name;
        int start, playtime;
        
        public Assignment(String name, String start, String playtime) {           
            int hour = Integer.parseInt(start.split(":")[0]) * 100;
            int minute = Integer.parseInt(start.split(":")[1]);
            
            this.name = name;          
            this.start = hour + minute;
            this.playtime = Integer.parseInt(playtime);
        }
    }
    
    private int calEndTime(int start, int playtime) {
        int hour = start / 100;
        int minute = start % 100;
        int newMinute = minute + playtime;
        
        if (newMinute >= 60) {
            hour = hour + newMinute / 60;
            newMinute %= 60;            
        }
        return hour * 100 + newMinute;
    }
    
    static private int calPlayTime(int start, int end) {
        int sHour = start / 100;
        int sMinute = start % 100;

        int eHour = end / 100;
        int eMinute = end % 100;

        int minute = eMinute - sMinute;
        if (minute < 0) {
            eHour -= 1;
            eMinute += 60;

            minute = eMinute - sMinute;
        }
        return (eHour - sHour) * 60 + minute;
    }
}
