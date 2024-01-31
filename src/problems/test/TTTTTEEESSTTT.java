package problems.test;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class TTTTTEEESSTTT{

    static class Node{
        int nodeNum;
        int cost;

        public Node(int nodeNum, int cost){
            this.nodeNum = nodeNum;
            this.cost = cost;
        }

    }

    static int N;
    static int M;
    static ArrayList<Node>[] graph;
    static int[] path;
    static int[] dp;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());


        //1부터 시작, 초기화
        graph = new ArrayList[N+1];
        dp = new int[N+1];
        path = new int[N+1];

        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<Node>();
        }

        Arrays.fill(dp, INF);

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int startV = Integer.parseInt(st.nextToken());
            int endV = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[startV].add(new Node(endV, cost));

        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());



        dijk(start);

        sb.append(dp[target] + "\n");
        sb.append(target + "\n");
        int prev = -1;
        int count = 0;
        while(dp[target] != 0){ // start는 무조건 0이니까
            path[target] = prev;
            sb.append(prev + " ");
            target = prev;
        }

        System.out.println(sb.toString());



    }

    // 다익스트라
    public static void dijk(int start){
        Queue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        dp[start] = 0;

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){

            Node curr = pq.poll();

//            if(curr.nodeNum == target) return;

            for(Node next : graph[curr.nodeNum]){
                if(dp[next.nodeNum] > curr.cost + next.cost){
                    dp[next.nodeNum] = curr.cost + next.cost;
                    pq.offer(new Node(next.nodeNum, dp[next.nodeNum]));
                    path[next.nodeNum] = curr.nodeNum;
                }
            }

        }

    }

}
