import java.util.Arrays;
import java.util.Scanner;

class Node {

	String s;
	Node left;
	Node right;

	Node() {
	}

}

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine()); // 노드의 개수

		Node[] nodes = new Node[N + 1];
		for (int i = 1; i <= N; i++) {
			nodes[i] = new Node();
		}
		
		for(int i=1; i<=N; i++) { // 각 노드와 그의 왼쪽 or 오른쪽 자식 입력받기
			String[] str = sc.nextLine().split(" ");
			
			int num = str[0].charAt(0)-'A'+1;
			nodes[num].s = str[0];
			
			if(!str[1].equals(".")) {
				nodes[num].left = nodes[str[1].charAt(0)-'A'+1];
			} else {
				nodes[num].left = null;
			}
			
			if(!str[2].equals(".")) {
				nodes[num].right = nodes[str[2].charAt(0)-'A'+1];
			} else {
				nodes[num].right = null;
			}
			
		}
		
		
		preorder(nodes[1]);
		System.out.println();
		inorder(nodes[1]);
		System.out.println();
		postorder(nodes[1]);

	}

	static void preorder(Node node) { // 전위순회

		if (node == null)
			return;

		System.out.print(node.s);
		preorder(node.left);
		preorder(node.right);
	}

	static void inorder(Node node) { // 중위순회

		if (node == null)
			return;

		inorder(node.left);
		System.out.print(node.s);
		inorder(node.right);
	}

	static void postorder(Node node) { // 후위순회

		if (node == null)
			return;

		postorder(node.left);
		postorder(node.right);
		System.out.print(node.s);
	}

}