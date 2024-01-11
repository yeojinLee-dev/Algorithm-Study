import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        
        int N = sc.nextInt();
        int[] time = new int[N];
        
        for (int i = 0; i < N; i++)
            time[i] = sc.nextInt();
        
        Arrays.sort(time);
        
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            cnt = cnt + time[i];
            answer += cnt;
        }
        System.out.println(answer);
    }
}
