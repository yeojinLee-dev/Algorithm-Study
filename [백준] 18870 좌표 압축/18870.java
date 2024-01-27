import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> sums = new HashMap<>();    // 누적합
        
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            nums[i] = x; 
            sums.put(x, 1);
        }
        
        List<Integer> list = new ArrayList<>(sums.keySet());
        Collections.sort(list);
        
        sums.put(list.get(0), 0);
        for (int i = 1; i < list.size(); i++) {
            int x = list.get(i);
            sums.put(x, i);
        }
        
        for (int i = 0; i < N; i++)
            sb.append(Integer.toString(sums.get(nums[i])) + " ");
        System.out.println(sb.toString());
    }
}
