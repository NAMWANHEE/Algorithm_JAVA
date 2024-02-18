import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bj_1068 {
	static int n,del,ans=0;
	static List<Integer> [] tree;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		tree = new ArrayList[n];
		for(int i=0;i<n;i++) {
			tree[i] = new ArrayList<>();
		}
		int start = 0;
		for(int i=0;i<n;i++) {
			int num = sc.nextInt();
			if(num == -1) {
				start = i;
				continue;
			}
			tree[num].add(i);
			
		}
		del = sc.nextInt();
		if(del == start) {
			System.out.println(0);
		}
		else {
			dfs(start);
			System.out.println(ans);
		}
		

	}
	
	private static void dfs(int node) {
		if(tree[node].size()==0) {
			ans++;
			return;
		}
		for(int next: tree[node]) {
			
			if(next == del) {
				if(tree[node].size()==1) ans++;
				continue;
			}
			dfs(next);
		}
		
	}

}
