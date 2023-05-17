package problems.category.dfs_bfs_그래프순회.다시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 바이러스_2606 {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int M; // 컴퓨터 수
    static int E; // 연결된 컴퓨터의 쌍 수
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        M = Integer.parseInt(br.readLine());
        E= Integer.parseInt(br.readLine());

        // 초기화
        visited = new boolean[M + 1];
        graph = new ArrayList[M+1];
        for(int i = 0; i <= M; i++){
            graph[i] = new ArrayList<>();
        }

        // 연결, 양방향
        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        dfs(1);
        System.out.println(cnt);

    }

    public static void dfs(int start){
        // 첫빠따 방문
        visited[start] = true;

        for (int next : graph[start]) {
            if (!visited[next]) {
                cnt++;
                dfs(next);
            }
        }
    }
}
