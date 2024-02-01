//11279

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            
            if (x == 0) {
                if (!q.isEmpty()) {
                    bw.write(Integer.toString(q.poll()) + "\n");
                } else {
                    bw.write("0\n");
                }
            } else
                q.add(x);
        }
        bw.flush();
        bw.close();
    }        
}


//11286

import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if (abs1 == abs2) return o1 > o2 ? 1 : -1;
            else return abs1 - abs2;
        });

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (!q.isEmpty()) bw.write(Integer.toString(q.poll()) + "\n");
                else bw.write("0\n");
            } else
                q.add(x);
        }
        bw.flush();
        bw.close();
    }
}
