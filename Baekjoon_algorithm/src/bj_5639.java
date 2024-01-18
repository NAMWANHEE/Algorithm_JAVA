import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_5639 {
	
	public static class Node{
		int root;
		Node left;
		Node right;
		public Node(int root) {
			this.root = root;
		}
		
		public void insert(int num) {
			if(num<root) {
				if(this.left == null) {
					this.left = new Node(num);
				}
				else {
					this.left.insert(num);
				}
			}
			else {
				if(this.right == null) {
					this.right = new Node(num);
				}
				else {
					this.right.insert(num);
				}
			}
		}
	}
	public static void postOrder(Node node) {
		if(node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.root);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int root = Integer.parseInt(br.readLine());
		Node node  = new Node(root);
		while(true) {
			String num = br.readLine();
			if(num == null || num.equals("")) break;
			node.insert(Integer.parseInt(num));
		}
		
		postOrder(node);

	}

}


