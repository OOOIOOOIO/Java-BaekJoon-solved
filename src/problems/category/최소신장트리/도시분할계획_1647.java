package problems.category.최소신장트리;

import java.util.*;
import java.io.*;

public class 도시분할계획_1647 {

    static class Edge{
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost){
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

    }

    static int N;
    static int M;
    static int[] parent;
    static ArrayList<Edge> edgeList;



    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edgeList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(v1, v2, weight));
        }

        parent = new int[N+1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }

        Collections.sort(edgeList, (o1, o2) -> o1.cost - o2.cost);

        int ans = 0;
        int maxCost = 0;

        for(int i = 0; i < edgeList.size(); i++){
            Edge edge = edgeList.get(i);

            if(!isSameParent(edge.v1, edge.v2)){
                ans += edge.cost;
                union(edge.v1, edge.v2);

                maxCost = edge.cost; // cost로 오름차순 정렬, 맨 마지막이 가장 큰 cost 간선 -> 이 간선을 없애면 최소로 양분됨
            }
        }

        System.out.println(ans);
        System.out.println("maxCost = " + maxCost);
        System.out.println(ans - maxCost);

    }


    private static int find(int v){
        if(parent[v] == v) return v;

        return parent[v] = find(parent[v]);
    }

    private static void union(int v1, int v2){

        v1 = find(v1);
        v2 = find(v2);

        if(v1 != v2){
            if(v1 > v2) parent[v1] = v2;
            else parent[v2] = v1;
        }
    }

    private static boolean isSameParent(int v1, int v2){

        v1 = find(v1);
        v2 = find(v2);

        if(v1 == v2) return true;

        return false;

    }
}
