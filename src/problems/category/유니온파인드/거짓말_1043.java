package problems.category.유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 거짓말_1043 {
	static int[] parent;
	static ArrayList<Integer>[] party;
	static boolean[] truth;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사람 수
		int M = Integer.parseInt(st.nextToken()); // 파티 수
		parent = new int[N + 1];
		truth = new boolean[N + 1];
		party = new ArrayList[M+1];

		// 초기화
		for(int i = 1; i <= N; i++){
			parent[i] = i;
		}

		for (int i = 1; i <= M; i++) {
			party[i] = new ArrayList<>();
		}


		// 진실
		st = new StringTokenizer(br.readLine());
		int truthNum = Integer.parseInt(st.nextToken()); // 진실 수
		while (truthNum-- > 0) {
			truth[Integer.parseInt(st.nextToken())] = true;
		}

		// 파티 형성 및 유니온
		for (int i = 1; i <= M; i++) {
			String[] inputs = br.readLine().split(" ");
			int party_num = Integer.parseInt(inputs[0]); // 파티에 오는 사람 수

			if(party_num<=1) {
				party[i].add(Integer.parseInt(inputs[1]));
				continue;
			}

			for (int j = 1; j < party_num; j++) { // 연관 관계 이어줌
				int v1 = Integer.parseInt(inputs[j]);
				int v2 = Integer.parseInt(inputs[j+1]);

				if (!isSameParent(v1, v2)) {
					union(v1, v2);
				}

				party[i].add(v1); // 파티에 참여하는 사람 저장
				party[i].add(v2);
			}

		}

		// 진실을 알고 있는 애들
		for (int i = 1; i <= N; i++) {
			if (truth[i]) { //알고 있다면
				int root = find(i);

				for (int j = 1; j <= N; j++) {
					int v = find(j);
					if(isSameParent(root, v)){
						truth[j] = true;
					}
				}
			}
		}

		int result = 0;
		// 파티 순회하며 진실인애가 있다면 break
		for (int i = 1; i <= M; i++) {
			boolean flag = false;

			for (int n : party[i]) {
				if (truth[n]) {
					flag = true;
					break;
				}
			}
			if(!flag){
				result++;
			}
		}

		System.out.println(result);


	}

	static int find(int v) {
		if(parent[v] == v) return v;
		else return parent[v] = find(parent[v]);

	}

	static void union(int v1, int v2) {
		v1 = find(v1);
		v2 = find(v2);

		if(v1 != v2) {
			if(v1 < v2) parent[v2] = v1;
			else parent[v1] = v2;
		}
	}

	static boolean isSameParent(int v1, int v2) {
		v1 = find(v1);
		v2 = find(v2);

		if(v1 == v2) return true;
		else return false;
	}
}
