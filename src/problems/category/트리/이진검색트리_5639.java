package problems.category.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진검색트리_5639 {
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	static void binaryTree(Node root, int data) {
		Node curr = root;
		
		while(true) {
			// 왼쪽
			if(curr.data > data) {
				if(curr.left == null) {
					curr.left = new Node(data);
					break;
				}
				else {
					curr = curr.left;
				}
			}
			// 오른쪽
			else {
				if(curr.right == null) {
					curr.right = new Node(data);
					break;
				}
				else {
					curr = curr.right;
				}
			}
		}
	}
	
	static void search(Node curr, int data) {
		
	}
	
//	static void preorder(Node root) {
//		System.out.println(root.data);
//		if(root.left != null) preorder(root.left);
//		if(root.right != null) preorder(root.right);
//	}
	
	static void postorder(Node root) {
		if(root.left != null) postorder(root.left);
		if(root.right != null) postorder(root.right);
		System.out.println(root.data);
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		//일단 하나 받고, root 설정
		String input = br.readLine();
		Node root = new Node(Integer.parseInt(input));
		
		// 이어서 받기
		// IDE에서는 입력을 계속 기다리기 때문에 !input.isEmpty()처럼 명시해주어야 한다.
		while(input != null && !input.isEmpty()) {
			
			input = br.readLine();
			if(input == null || input.isEmpty()) {
				continue;
			}
			binaryTree(root, Integer.parseInt(input));
			
		}
		
//		preorder(root);
		
		postorder(root);
		
		
	}
}
