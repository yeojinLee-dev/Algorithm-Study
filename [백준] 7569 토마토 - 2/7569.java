import java.util.*;
import java.io.*;

class Main {
    static int[][][] tomato;
    static boolean[][][] visited;
    static int M, N, H;
    static int answer = 0, unRipen = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());    // 가로
        N = Integer.parseInt(st.nextToken());    // 세로
        H = Integer.parseInt(st.nextToken());    // 높이
        
        tomato = new int[H][N][M];
        visited = new boolean[H][N][M];
        q = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    tomato[h][n][m] = Integer.parseInt(st.nextToken());
                    
                    if (tomato[h][n][m] == 0) 
                        unRipen += 1;
                    
                        if (tomato[h][n][m] == 1)
                        q.add(new Tomato(h, n, m, 0));
                }
            }
        }
        
        bfs();
        
        System.out.println((unRipen == 0) ? answer : -1);       
    }
    
    static Queue<Tomato> q;
    private static void bfs() {       
        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz =  {0, 0, 0, 0, 1, -1};
        
        while (!q.isEmpty()) {
            Tomato t = q.poll();
            int z = t.z;    // 높이
            int x = t.x;
            int y = t.y;
            int cnt = t.cnt;
            
            answer = Math.max(answer, cnt);
            
            for (int i = 0; i < 6; i++) {
                int zz = z + dz[i];

