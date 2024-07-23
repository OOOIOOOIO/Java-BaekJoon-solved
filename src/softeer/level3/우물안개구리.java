package softeer.level3;

import java.io.*;
import java.util.*;

public class 우물안개구리 {

    static class Person{
        int num;
        int weight;

        public Person(int num, int weight){
            this.num = num;
            this.weight = weight;
        }

    }

    static int N, M;
    static boolean[] isNotBest;
    static boolean[] visited;
    static int[] weight;
    static ArrayList<ArrayList<Person>> pList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 회원수
        M = Integer.parseInt(st.nextToken()); // 회원관계수

        // 초기화
        isNotBest = new boolean[N+1];
        visited = new boolean[N+1];
        weight = new int[N+1];
        for(int i = 0; i <= N; i++){
            pList.add(new ArrayList<>());
        }


        // 회원
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            weight[i] = Integer.parseInt(st.nextToken());
        }


        // 관계
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            pList.get(A).add(new Person(B, weight[B]));
            pList.get(B).add(new Person(A, weight[A]));
        }

        solve();

        int ans = 0;
        for(int i = 1; i <= N; i++){
            if(!isNotBest[i]) ans++;
        }

        System.out.println(ans);



    }


    private static void solve(){


        for(int i = 1; i <= N; i++){
            int currWeight = weight[i];

            // 내가 짱이라고 여겼을 때
            if(!isNotBest[i]){
                for(Person next : pList.get(i)){

                    //나보다 친구들이 더 크다면 -> 나는 쩌리다
                    if(next.weight > currWeight){
                        isNotBest[i] = true;
                        break;
                    }
                    else if(next.weight == currWeight){ //나랑 친구랑 같다면 -> 둘다 쩌리다
                        isNotBest[i] = true;
                        isNotBest[next.num] = true;
                        break;
                    }

                    else{ //내가 친구보다 더 크다면 -> 걔는 검사할 필요가 없다. 이미 쩌리가 되어버렸다
                        isNotBest[next.num] = true;
                    }


                }

            }


        }


    }

}





















