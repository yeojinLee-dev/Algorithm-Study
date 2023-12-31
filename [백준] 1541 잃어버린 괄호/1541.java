import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Queue<Integer> numbers = new LinkedList<>();
        List<Character> operators = new ArrayList<>();
            
        // 식 분해
        String sNum = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if ((int) c >= 48 && (int) c <= 57) {
                sNum += c;
            } else {
                numbers.add(Integer.parseInt(sNum));
                sNum = "";
                operators.add(c);
            }
        }
        numbers.add(Integer.parseInt(sNum));

        // -가 나오면, 다음 -가 나올 때까지 계속 빼면 됨. (=괄호 치는 것)
        int answer = numbers.poll();
        boolean isMinus = false;
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == '-') {
                answer -= numbers.poll();
                isMinus = true;
            } else {
                if (isMinus) {
                    answer -= numbers.poll();
                } else {
                    answer += numbers.poll();
                    isMinus = false;
                }
            }
        }
        
        System.out.println(answer);
    }
}
