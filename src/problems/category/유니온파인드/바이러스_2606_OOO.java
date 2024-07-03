package problems.category.유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바이러스_2606_OOO {
    static int N, M;
    static int[] parent;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // 초기화
        parent = new int[N+1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }


        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            // 일단 다 이어버리기
//            if(!isSameP(v1, v2)){
            union(v1, v2);
//            }
        }



        int cnt = 0;

        // 같으면 카운트
        for(int i = 2; i <= N; i++){
            if(isSameP(1, i)){
                cnt++;
            }
        }


        System.out.println(cnt);



    }

    private static void union(int v1, int v2) {
        v1 = find(v1);
        v2 = find(v2);

        if(v1 != v2) {
            if(v1 < v2) {
                parent[v2] = v1;
            }
            else {
                parent[v1] = v2;
            }
        }
    }

    private static int find(int v){

        if(parent[v] == v) return parent[v];

        return parent[v] = find(parent[v]);
    }

    private static boolean isSameP(int v1, int v2){
        int p1 = find(v1);
        int p2 = find(v2);

        if(p1 == p2) return true;

        return false;
    }



}





