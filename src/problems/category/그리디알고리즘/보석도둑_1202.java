package problems.category.그리디알고리즘;

import java.io.*;
import java.util.*;


class Jewel {
    int weight; // 무게
    int price; // 가격

    Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }
}

public class 보석도둑_1202 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewel[] jewelries = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewelries[i] = new Jewel(m, v);
        }

        List<Jewel> list = new ArrayList<>();

        Collections.sort(list, (o1, o2) -> {
            if (o1.weight == o2.weight) {
                return o2.price - o1.price;
            }
            return o1.weight - o2.weight;
        });

        // 무게를 오름차순 정렬하되, 무게가 같을 경우 가격을 내림차순 정렬.
        Arrays.sort(jewelries, (o1, o2) -> {
            if (o1.weight == o2.weight) {
                return o2.price - o1.price;
            }
            return o1.weight - o2.weight;
        });

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        // 오름차순 정렬
        Arrays.sort(bags);

        // 내림차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0;
        int j = 0;
        for (int i = 0; i < bags.length; i++) {
            // 일단 다 떄려박기
            while (j < jewelries.length && jewelries[j].weight <= bags[i]) {
                pq.offer(jewelries[j++].price);
            }

            // k개수만큼 맨 위에서 빼기
            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }

        System.out.println(sum);
    }

}