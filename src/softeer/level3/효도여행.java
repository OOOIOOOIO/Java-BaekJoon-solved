package softeer.level3;


import java.io.*;
import java.util.*;

public class 효도여행 {

    static class Node{
        int nodeNum;
        String edge;

        public Node(int nodeNum, String edge){
            this.nodeNum = nodeNum;
            this.edge = edge;
        }
    }

    static int N, M;
    static int ans = -1;
    static String dad;
    static LinkedList<LinkedList<Node>> tree;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dad = br.readLine();

        // 초기화
        visited = new boolean[N+1];
        tree = new LinkedList<>();
        for(int i = 0; i <= N; i++){
            tree.add(new LinkedList<Node>());
        }

        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            String edge = st.nextToken();

            tree.get(node1).add(new Node(node2, edge));
            tree.get(node2).add(new Node(node1, edge));
        }

        int startNode = 1;

        dfs(startNode, "");

        System.out.println(ans);

    }

    public static void dfs(int curr, String edge){

        //종료, 리프노드일 경우
        if(tree.get(curr).size() == 1 && visited[tree.get(curr).get(0).nodeNum]){
            Integer[][] topDown = new Integer[dad.length()][edge.length()];

            ans = Math.max(ans, LCS(dad, edge, dad.length()-1, edge.length()-1, topDown));
            return;
        }

        visited[curr] = true;

        for(Node next : tree.get(curr)){
            if(!visited[next.nodeNum]){

                dfs(next.nodeNum, edge + next.edge);
            }

        }

    }

    private static int LCS(String str2, String str1, int y, int x, Integer[][] topDown){

        if(y == -1 || x == -1) return 0;

        if(topDown[y][x] == null) {
            if(str2.charAt(y) == str1.charAt(x)) {
                topDown[y][x] = LCS(str2, str1, y-1, x-1, topDown) + 1;
            }
            else {
                topDown[y][x] = Math.max(LCS(str2, str1, y-1, x, topDown),  LCS(str2, str1, y, x-1, topDown));
            }
        }

        return topDown[y][x];

    }



}



















