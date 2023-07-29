package problems.category.최단경로;

import java.util.*;
import java.io.*;
public class 최소비용구하기2_11779 {

//    static ArrayList<ArrayList<Node>> graph;
    static ArrayList<Node>[] graph2;
    static int n;
    static int m;
    static int[] dist;
    static int[] prev;

    static class Node{
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static void dijk(int start){
        Queue<Node> queue = new PriorityQueue<Node>((o1, o2) -> o1.cost - o2.cost);

        queue.offer(new Node(start, 0));

        dist[start] = 0;


        while(!(queue.isEmpty())) {
            Node curr = queue.poll();

            if (dist[curr.node] < curr.cost) {
                continue;
            }

            for (Node item : graph2[curr.node]) {
                Node next = item;

                if (dist[next.node] > curr.cost + next.cost) {
                    dist[next.node] = curr.cost + next.cost;
                    queue.offer(new Node(next.node, dist[next.node]));
                    prev[next.node] = curr.node;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n+1];
        prev = new int[n+1];
        graph2 = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            graph2[i] = new ArrayList<>();
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // v1 --> v2 연
            graph2[v1].add(new Node(v2, cost));

        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dijk(s);

        sb.append(dist[e]+"\n");
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(e);
        while (dist[e] != 0){
            int prev = dist[e];
            stack.push(prev);
            cnt++;
            e = prev;
        }


        sb.append(stack.size() + "\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }


        System.out.println(sb.toString());


    }




}
