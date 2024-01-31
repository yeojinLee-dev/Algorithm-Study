import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);      
        int n = sc.nextInt();
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            int sqrt = 1, pow = 1;    // 1^2부터 시작
            while (pow <= i) {
                dp[i] = Math.min(dp[i], dp[i - pow] + 1);
                sqrt++;
                pow  = sqrt * sqrt;
            }
        }
        
        System.out.println(dp[n]);
    }
}
