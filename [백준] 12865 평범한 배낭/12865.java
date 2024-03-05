import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int[][] things = new int[N + 1][2];
        
        for (int i = 1; i < N + 1; i++) {
            things[i][0] = sc.nextInt();
            things[i][1] = sc.nextInt();
        }
        
        int[] dp = new int[K + 1];
        dp[1] = 0;
        
        for (int i = 1; i < N + 1; i++) {
            for (int j = K; j - things[i][0] >= 0; j--) {
								// 최대 수용 가능 무게가 j - W[i]일 때 최대 가치 + V[i]와 dp[j] 중 최댓값 구함
                dp[j] = Math.max(dp[j], dp[j - things[i][0]] + things[i][1]);        
            }
        }
        
        System.out.println(dp[K]);
    }
}
