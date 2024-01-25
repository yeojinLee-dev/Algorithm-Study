import java.util.*;
import java.io.*;

class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n <= K)
                list.add(n);  
        }
        
        Collections.sort(list);
        for (int i = list.size() - 1; i >= 0; i--) {
            if (K >= list.get(i)) {
                cnt += K / list.get(i); 
                K %= list.get(i);
            } 
                
            if (K == 0) 
                break;            
        }
        System.out.println(cnt);
    }
}
