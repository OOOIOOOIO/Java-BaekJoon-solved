package problems.category.dfs_bfs_그래프순회.다시;

import java.util.*;
import java.io.*;

public class Main{

    static class Node{
        int nodeNum;
        int cost;
        Node next;

        public Node(int nodeNum, int cost){
            this.nodeNum = nodeNum;
            this.cost = cost;
        }
    }

    static int n, m, r;
    static int result = 0;
    static ArrayList<Integer> itemList = new ArrayList<>();
    static ArrayList<ArrayList<Node>> graph;
    static int INF = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        // 초기
        n = Integer.parseInt(st.nextToken()); // 지역 개수
        m = Integer.parseInt(st.nextToken()); // 수색 범위
        r = Integer.parseInt(st.nextToken()); // 길의 개수(간선)

        st = new StringTokenizer(br.readLine());

        // item
        for(int i = 0; i < n; i++){
            itemList.add(Integer.parseInt(st.nextToken()));
        }

        // 초기화

        graph = new ArrayList<ArrayList<Node>>();



        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Node>());
        }


        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(v1).add(new Node(v2, cost));
            graph.get(v2).add(new Node(v1, cost));
        }

        for(int i = 1; i <= n; i++){
            int[] dist = dijk(i);
            result = Math.max(result, check(dist));
        }

        System.out.println(result);




    }

    static int[] dijk(int start){
        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        queue.offer(new Node(start, 0));
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);

        dist[start] = 0;

        while(!queue.isEmpty()){
            Node curr = queue.poll();

            for(Node next : graph.get(curr.nodeNum)){

                if(dist[next.nodeNum] > curr.cost + next.cost){
                    dist[next.nodeNum] = curr.cost + next.cost;
                    queue.offer(new Node(next.nodeNum, dist[next.nodeNum]));
                }
            }
        }
        return dist;


    }

    static int check(int[] dist){
        int sum = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] <= m){
                sum += itemList.get(i-1);
            }
        }

        return sum;
    }


}
