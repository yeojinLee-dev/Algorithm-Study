class Solution {
    public long[] solution(int n, long left, long right) {
        long[] answer = new long[(int)(right - left) + 1];
        
        long leftRow = left / n;
        long leftCol = left % n;
        long rightRow = right / n;
        long rightCol = right % n;
        
        int x = 0;

        for (long i = leftRow; i <= rightRow; i++) {
            long j = 0, end = n;
            
            if (i == leftRow) 
                j = leftCol;

            if (i == rightRow)
                end = rightCol + 1;

            for (; j < end; j++) {
                if (j <= i) answer[x++] = i + 1;
                else answer[x++] = j + 1;
            } 
        }

        return answer;
    }
}
