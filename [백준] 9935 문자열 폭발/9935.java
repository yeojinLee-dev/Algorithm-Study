import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        String s = sc.next();
        String explosion = sc.next();
        
        int length = explosion.length();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));

            if (stack.size() >= length) {   
                boolean isSame = true;
                
                for (int j = 0; j < length; j++) {
                    if (stack.get(stack.size() - length + j) != explosion.charAt(j)) {
                        isSame = false;
                        break;
                    }
                }

                if (isSame) {
                    for (int j = 0; j < length; j++) 
                        stack.pop();
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        
        for (char c : stack)
            sb.append(c);

        if (size == 0) System.out.println("FRULA");
        else System.out.println(sb.toString());
    }
}
