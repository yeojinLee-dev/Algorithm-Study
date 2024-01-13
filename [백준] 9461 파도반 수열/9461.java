import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] dp = new long[101];
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        
        for (int i = 5; i < 101; i++) 
            dp[i] = dp[i - 1] + dp[i - 5];
        
        int T = sc.nextInt();
        
        while (T-- > 0) {
            int N = sc.nextInt();
            bw.write(Long.toString(dp[N]) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
