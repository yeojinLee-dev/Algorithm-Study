import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        // dp[N] = a : 정수 N에 사용하는 연산 횟수 a
        int[] dp = new int[N + 1];
        dp[0] = 0;    
        dp[1] = 0;

        for (int i = 2; i < N + 1; i++) {
            if (i % 6 == 0) 
                dp[i] = Math.min(dp[i - 1], Math.min(dp[i / 2], dp[i / 3])) + 1;
            else if (i % 3 == 0)
                dp[i] = Math.min(dp[i - 1], dp[i / 3]) + 1;
            else if (i % 2 == 0)
                dp[i] = Math.min(dp[i - 1], dp[i / 2]) + 1;
            else 
                dp[i] = dp[i - 1] + 1;
        }
        
        System.out.println(dp[N]);
    }
}
