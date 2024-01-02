import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        int N = Integer.parseInt(br.readLine());
        
        while (N-- > 0 ) {
            int x = Integer.parseInt(br.readLine()); 
            
            if (x == 0) {
                if (!q.isEmpty()) 
                    bw.write(Integer.toString(q.poll()) + "\n");
                else 
                    bw.write("0\n");
            } else {
                q.add(x);
            }
        }
        bw.flush();
        bw.close();
    }
}
