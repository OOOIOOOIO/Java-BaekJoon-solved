package softeer.problem;

import java.util.*;
import java.io.*;

public class 금고털이 {

    static class Jw{
        int weight;
        int price;

        public Jw(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        PriorityQueue<Jw> pq = new PriorityQueue<>((o1, o2) -> o2.price - o1.price);

        st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken()); // 배낭 무게
        int N = Integer.parseInt(st.nextToken()); // 귀금속 종류

        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 금속 무게
            int P = Integer.parseInt(st.nextToken()); // 무게당 가격
            pq.offer(new Jw(M, P));
        }


        int restWeight = W;
        int sum = 0;

        while(!pq.isEmpty()){
            Jw curr = pq.poll();

            if(restWeight > curr.weight){
                restWeight -= curr.weight;
                sum += (curr.weight * curr.price);
            }
            else if(restWeight <= curr.weight){
                sum += (restWeight * curr.price);
                break;
            }

        }

        System.out.println(sum);

    }

}
