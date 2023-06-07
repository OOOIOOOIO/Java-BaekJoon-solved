package problems.category.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 트리순회_1991_트리만드는법 {
	static class Node{
		char data;
		Node left;
		Node right;
		
		public Node() {;}
		
	}
	
	static class Tree{
		Node root;
		
		public Tree() {;}
		
		public void makeTree(char data, char left, char right) {
			// 맨 처음
			if(root == null) {
				root = new Node();
				
				root.data = data;
				
				if(left != '.') {
					root.left = new Node();
					root.left.data = left;
				}
				if(right !='.') {
					root.right = new Node();
					root.right.data = right;
				}
			}
			else {
				search(root, data, left, right);
				
			}
		}

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			int N = Integer.parseInt(br.readLine());

			Tree tree = new Tree();

			while(N-- > 0) {
				char[] arr = br.readLine().replaceAll(" ", "").toCharArray();
				char data = arr[0];
				char left = arr[1];
				char right = arr[2];

				tree.makeTree(data, left, right);
			}

			preorder(tree.root);
			System.out.println();
			inorder(tree.root);
			System.out.println();
			postorder(tree.root);

		}
		// 두번째부터
		public void search(Node node, char data, char left, char right) {
			if(node == null) {
				return;
			}
			else if(node.data == data) {
				if(left != '.') {
					node.left = new Node();
					node.left.data = left;
				}
				if(right != '.') {
					node.right = new Node();
					node.right.data = right;
				}
			}
			else {
				search(node.left, data, left, right);
				search(node.right, data, left, right);
			}
		}
		
	}
	
	static void preorder(Node node) {
		System.out.print(node.data);
		if(node.left != null) preorder(node.left);
		if(node.right != null) preorder(node.right);
	}
	
	static void inorder(Node node) {
		if(node.left != null) inorder(node.left);
		System.out.print(node.data);
		if(node.right != null) inorder(node.right);
	}
	
	static void postorder(Node node) {
		if(node.left != null) postorder(node.left);
		if(node.right != null) postorder(node.right);
		System.out.print(node.data);
	}
	
	
	

}



