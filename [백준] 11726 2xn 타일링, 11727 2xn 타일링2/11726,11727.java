// 1
import java.util.*;

class Main {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        
        dp = new int[1001];
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i < 1001; i++) 
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        
        System.out.println(dp[n]);
    }
}

// 2
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] dp = new int[1001];
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;
        
        for (int i = 3; i < 1001; i++) 
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        
        System.out.println(dp[n]);
    }
}
