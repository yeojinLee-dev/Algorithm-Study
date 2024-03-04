class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long n = numbers[i];
            if (n % 2 == 0) {
                answer[i] = n + 1;
            } else {
                String s = Long.toBinaryString(n);

                if (!s.contains("0")) {   // 전부 1인 수이면
                    String ss = "10" + s.substring(0, s.length() - 1);
                    answer[i] = Long.parseLong(ss, 2);
                } else {
                    int idx = s.lastIndexOf("0");
                    s = s.substring(0, idx) + "10" + s.substring(idx + 2);

                    answer[i] = Long.parseLong(s, 2);           
                }               
            }
        }
        return answer;
    }
}
