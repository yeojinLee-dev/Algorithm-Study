import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb= new StringBuilder();
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[] nums = new int[N];
        int[] sums = new int[N];    // sums[i] -> 0번부터 i번까지의 합

        int sum = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
            
            sum += nums[i];
            sums[i] = sum;
        }
        
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            
            sb.append(Integer.toString(sums[end - 1] - sums[start - 1] + nums[start - 1]) + "\n");
        }
        System.out.println(sb.toString());
    }
}
