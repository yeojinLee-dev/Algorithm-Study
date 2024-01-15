import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dp = new int[12];
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        for (int i = 4; i < 12; i++) 
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        
        int T = sc.nextInt();
        
        while (T-- > 0) {
            int n = sc.nextInt();
            bw.write(Integer.toString(dp[n]) + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}
