import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                
                if (command.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);                
                } else if (map.size() != 0) {
                    int n = 0;
                    if (num == 1) {
                        n = map.lastKey();
                    }
                    else {
                        n = map.firstKey();
                    }
                    map.put(n, map.get(n) - 1);
                    
                    if (map.get(n) == 0) 
                        map.remove(n);
                }
            }

            if (map.isEmpty()) 
                bw.write("EMPTY\n");
            else
                bw.write(Integer.toString(map.lastKey()) + " " + Integer.toString(map.firstKey()) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
