package softeer.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 9 12
 * 4 6 24
 * 3 2 2
 * 1 4 8
 * 4 3 8
 * 4 3 16
 * 3 5 6
 * 2 6 29
 * 1 5 30
 * 7 9 28
 * 1 8 10
 * 7 6 16
 *
 *
 * 29
 */
public class 지우는소수를좋아해_다익스트라 {

    static class Node{
        int nodeNum;
        int cost;

        Node node;

        public Node(int nodeNum, int cost) {
            this.nodeNum = nodeNum;
            this.cost = cost;
        }
    }
    static int N;
    static int M;
//    static ArrayList[] graph; // 모든 노드를 돌 떄 좋음
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist; // 최단거리 저장
    static int INF = Integer.MAX_VALUE;
    static int maxCost = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 초기화
        dist = new int[N + 1];
//        graph = new ArrayList[N+1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        Arrays.fill(dist, INF);

        // 연결
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 노드1
            int B = Integer.parseInt(st.nextToken()); // 노드2
            int C = Integer.parseInt(st.nextToken()); // 가중치(필요 레벨)
            graph.get(A).add(new Node(B, C));
            graph.get(B).add(new Node(A, C)); // 양방향
        }

        dijkstra(1, N);

        for (int i = 1; i < dist.length; i++) {
            System.out.println(i+"번쨰 = " + dist[i]);
        }

        boolean flag = true;

        for (int i = dist[N] + 1; ; i++) { // 이하는 오지 말라고 했으니까 +1 해주어야 함

            for (int j = 2; j <= Math.sqrt(i); j++) { // 소수 구하기
                if(i % j == 0){
                    flag = false;
                    break;
                }
                flag = true;
            }
            if(flag){
                System.out.println(i);
                break;
            }
        }

    }

    public static void dijkstra(int start, int target){
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost)); // 오름차순

        //처음
        pq.add(new Node(start, 0));
        dist[start] = 0;

        // 순회
        while (!pq.isEmpty()) {
            // 현재
            Node curr = pq.poll();

            // curr은 현재  비용을 갖고 있는 노드이다. 즉 해당 노드의 비용보다 dp에 저장되어 있는 최단거리가 더 짧다면
            // 현재 노드는 고려할 필요가 없으므로 continue를 해준다.
            if(dist[curr.nodeNum] < curr.cost) {
                continue;
            }

            for (Node next : graph.get(curr.nodeNum)) {
                int max = Math.max(next.cost, curr.cost); // 현재까지와 다음 노드까지의 거리 중 더 큰 레벨 고르면 됨 -> 최대 레벨 확보
                if (dist[next.nodeNum] > max) { // 최저 레벨(최단거리)!!
                    dist[next.nodeNum] = max;
                    pq.add(new Node(next.nodeNum, dist[next.nodeNum]));

                }
            }
        }
    }



}
