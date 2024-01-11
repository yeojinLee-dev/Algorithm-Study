import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        String s = sc.next();
        
        int i = 0, cnt = 0, answer = 0;
        while (i + 3 <= M) {
            String sub = s.substring(i, i + 3);
            
            if (sub.equals("IOI")) {
                cnt += 1;
                if (cnt == N) {
                    answer += 1;
                    cnt--;
										// cnt = 0;
										// if (N != 1) {
                    //     i = i - 2 * (N - 2);
                    //     continue;
                    // }
                } 
                i += 2;
            } else {
                i += 1;
                cnt = 0;
            }
        }
        
        System.out.println(answer);        
    }
}
