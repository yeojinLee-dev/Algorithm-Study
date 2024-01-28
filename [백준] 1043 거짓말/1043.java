import java.util.*;

class Main {
    
    static int[] parent;
    static boolean[] people;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        parent = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }

        int t = sc.nextInt();
        people = new boolean[N+1];
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            people[n] = true;
        }
        
        // 입력 받을 때 같은 파티에 있는 사람들끼리는 같은 부모 노드를 갖게 한다. 
        List<List<Integer>> party = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            party.add(new ArrayList<>());

            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                int m2 = sc.nextInt();
                party.get(i).add(m2);
            }    
        }

        // 같은 파티에 있는 사람들끼리 합쳐준다. 
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < party.get(i).size() - 1; j++) {
                int a = party.get(i).get(j);
                int b = party.get(i).get(j + 1);

                if (find(a) != find(b)) {
                    union(a, b);
                }
            }
        }

        // 진실을 알게 된 모든 사람을 구한다. 
        for (int i = 1; i < N+1; i++) {
            if (people[i]) {
                int px = find(i);
                people[px] = true;
            }
        }
        
        // 과장되게 말할 수 있는 파티를 카운트 한다. 
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            List<Integer> list = party.get(i);
            boolean isTruth = false;
            for (int j = 0; j < list.size(); j++) {
                int x = list.get(j);
                int px = find(x);

                if (people[px]) {
                    isTruth = true;
                    break;
                }
            }

            if (!isTruth)
                cnt++;
        }
        System.out.println(cnt);   
    }
    private static void union(int x, int y) {
        // x, y의 부모 노드를 찾는다. 
        int rx = find(x);
        int ry = find(y);

        // 노드 x와 노드 y를 연결해준다. 노드 y의 부모노드의 부모노드를 x의 부모노드로 바꾸어준다. 
        if (rx != ry) {
            parent[ry] = rx;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) 
            return x;
        return find(parent[x]);
    }    
}
