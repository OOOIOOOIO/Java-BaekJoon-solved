package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리의순회_2263 {
	// 문제가 inorder, postorder를 이용해 preorder를 구하는 문제다. 출력만 되게 만들면 되나보다.
	// tree의 공간만 만들어서 어떻게 만들어봐야겠다.
	
	static int[] preorder, inorder, postorder;
	static int N;
	static int idx;
	
	// makePreorder(0, N-1, 0, N-1);
	static void getPreorder(int inStart, int inEnd, int postStart, int postEnd) {
		
		if(inStart <= inEnd && postStart <= postEnd) {
				
			// postorder로 root구하기
			// subtree의 마지막 얘가 그 트리의 root
			int root = postorder[postEnd];
			
			
			// preorder는 subtree의 왼쪽부터 순회한다.
			preorder[idx++] = root;
			
			
			// inorder의 root 인덱스 구하기 
			// inorder을 이용해 
			int rootIdx = -1;
			for(int i = 0; i < N; i++) {
				if(inorder[i] == root) {
					rootIdx = i;
				}
			}
			
			// inorder의  root index를 기준으로 왼쪽 요소들의 수이다.
			// 왼쪽 요소의 수만큼 postorder의 subtree가 묶이고 현재위치 + 요소의 수를 해주어야 그 다음 postorder의  위치가 된다.
			// subtree의 맨 왼쪽 요소가 preorder의 root이므로
			int leftElem = rootIdx - inStart;
			
			// left subtree, postorder에 -1을 해주는 이유는 subtree의 맨 마지막 요소가 root이기 때문이다. 그리고 그 root가 preorder의 순회 순서이다.
			getPreorder(inStart, rootIdx-1, postStart, postStart + leftElem -1);
//			getPreorder(inStart, rootIdx-1, postStart, leftElem -1);
			
			// right subtree
			getPreorder(rootIdx + 1, inEnd, postStart + leftElem, postEnd -1);
//			getPreorder(rootIdx + 1, inEnd, leftElem + 1, postEnd -1);
		}
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		preorder = new int[N];
		inorder = new int[N];
		postorder = new int[N];
		
		// inorder, idx는 0부터 시작
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			inorder[i] = Integer.parseInt(st.nextToken());
		}
		
		// postorder, idx는 0부터 시작
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			postorder[i] = Integer.parseInt(st.nextToken());
		}
		
		getPreorder(0, N-1, 0, N-1);
		
		for(int i : preorder) {
			System.out.print(i + " ");
		}
	}
}
