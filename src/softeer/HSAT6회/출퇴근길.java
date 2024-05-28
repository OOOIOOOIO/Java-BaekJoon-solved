package softeer.HSAT6회;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class 출퇴근길 {
    static int n;
    static int m;
    static ArrayList<ArrayList<Integer>> graph;
    static ArrayList<ArrayList<Integer>> reverseGraph;




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int size = m;
        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();

        for(int i = 0; i <= m; i++){
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            graph.get(x1).add(y1);
            reverseGraph.get(y1).add(x1);

        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());



        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        // 정방향 S --> T 도달할 수 있는 중간 정점들
        dfs(S, T, graph, s1, new boolean[n+1]);
        // 역방향  T --> 도달할 수 있는 모든 정점
        dfs(T, -1, reverseGraph, s2, new boolean[n+1]);
        System.out.println("s1 : " + s1.size());
        Stream.of(s1).forEach(System.out::println);
        System.out.println("s2 : " + s2.size());
        Stream.of(s2).forEach(System.out::println);
        s1.retainAll(s2); //교집합


        Set<Integer> s3 = new HashSet<>();
        Set<Integer> s4 = new HashSet<>();
        // 정방향 T --> S 도달할 수 있는 중간 정점들
        dfs(T, S, graph, s3, new boolean[n+1]);
        // 역방향 S -->   도달할 수 있는 모든 정점들
        dfs(S, -1, reverseGraph, s4, new boolean[n+1]);
        System.out.println("s3 : " + s3.size());
        Stream.of(s3).forEach(System.out::println);
        System.out.println("s4 : " + s4.size());
        Stream.of(s4).forEach(System.out::println);
        s3.retainAll(s4);


        s1.retainAll(s3);

        int answer = s1.size();

        if(s1.contains(S)) answer--;
        if(s1.contains(T)) answer--;

        System.out.println(answer);




    }

    private static void dfs(int start, int end, ArrayList<ArrayList<Integer>> graph, Set<Integer> set,  boolean[] visited){
        if(end != -1 && start == end) return; // -1을 해줌으로써 모든 정점 구함( 끝 포함)

        visited[start] = true;

        for(int next : graph.get(start)){
            if(!visited[next]){
                set.add(next);
                dfs(next, end, graph, set, visited);
            }
        }


    }


}
