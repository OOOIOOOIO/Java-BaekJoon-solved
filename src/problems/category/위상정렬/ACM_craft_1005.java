package problems.category.위상정렬;

import java.util.*;
import java.io.*;
public class ACM_craft_1005 {

    static int N;
    static int[] dp;
    static int[] inDegree;
    static ArrayList<ArrayList<Integer>> graph;


    public static void topologicalSort(String[] cost){

        // 여기부터 위상정렬
        Queue<Integer> queue = new LinkedList<>();

        // 진입차수가 0인 애들 넣기
        for(int i = 1; i <= N; i++){

            dp[i] = Integer.parseInt(cost[i-1]);

            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){

            int curr = queue.poll();

            for(Integer next : graph.get(curr)){

                dp[next] = Math.max(dp[next], Integer.parseInt(cost[next-1]) + dp[curr]);

                inDegree[next]--;

                if(inDegree[next] == 0){
                    queue.offer(next);
                }

            }

        }



    }

    public static void main(String[] args) throws IOException{

        /** 위상정렬 TopologicalSort */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;


        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            String[] cost = br.readLine().split(" ");


            graph = new ArrayList<>();
            inDegree = new int[N+1]; // 1부터 시작
            dp = new int[N+1];

            for(int i = 0; i <= N; i++){ // 1부터 시작
                graph.add(new ArrayList<Integer>());
            }

            while(K-- > 0){
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                graph.get(v1).add(v2);
                inDegree[v2]++;
            }
            int W = Integer.parseInt(br.readLine());

            topologicalSort(cost);

            System.out.println(dp[W]);
        }


    }



}
