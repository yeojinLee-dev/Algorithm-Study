import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N + 1];
        int[] dp = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        
        dp[0] = 0;
        dp[1] = stairs[1];
        if (N > 1) dp[2] = dp[1] + stairs[2];
        
        for (int i = 3; i <= N; i++) {
            // i번째 계단을 무조건 밟았다고 가정
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
        }
        
        System.out.println(dp[N]);        
    }
}
