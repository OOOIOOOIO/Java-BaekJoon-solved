package problems.category.dfs_bfs_그래프순회.다시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS와BFS {

    static int N; // 정점의 개수
    static int M; // 간선의 개수
    static int V; // 시작 노드
    static boolean[] bfsVisited;
    static boolean[] dfsVisited;
//    static ArrayList<Integer>[] graph;
    static int[][] graph;
    static String bfsResult = "";

    static String dfsResult = "";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 초기화
        bfsVisited = new boolean[N + 1];
        dfsVisited = new boolean[N + 1];
//        graph = new ArrayList[N + 1];
        graph = new int[N+1][N+1];

//        for(int i = 0; i <= N; i++){
//            graph[i] = new ArrayList<>();
//        }

        // 연결
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

//            graph[v1].add(v2);
//            graph[v2].add(v1);
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
//        for (int i = 1; i <= N; i++) {
//            Collections.sort(graph[i]);
//        }

        dfs(V);
        bfs(V);
        System.out.println(dfsResult + "\n" + bfsResult);

    }

    public static void dfs(int start){

        dfsVisited[start] = true; // 시작 방문
        dfsResult += start + " ";

        for(int i = 1; i <= N; i++){
            if (!dfsVisited[i] && graph[start][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start){
        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(start); // 시작 노드 적재
        bfsVisited[start] = true; // 시작 방문

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for(int i = 1; i <= N; i++){
                if (!bfsVisited[i] && graph[curr][i] == 1) {
                    bfsVisited[i] = true; // 시작 방문
                    queue.offer(i);
                }
            }

            // curr 적재
            bfsResult += curr + " ";
        }

    }
}
