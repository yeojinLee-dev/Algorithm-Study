import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Time> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        int cnt = 1;

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            list.add(new Time(start, end)); 
        }
        
        Collections.sort(list, (o1, o2) -> Integer.valueOf(o1.start).compareTo(o2.start));
        Collections.sort(list, (o1, o2) -> Integer.valueOf(o1.end).compareTo(o2.end));
        
        int curEndTime = list.get(0).end;
        for (int i = 1; i < list.size(); i++) {
            if (curEndTime <= list.get(i).start) {
                curEndTime = list.get(i).end;
                cnt++;
            }
        }
        
        System.out.println(cnt);
    }
    
    private static class Time {
        int start, end;
        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
