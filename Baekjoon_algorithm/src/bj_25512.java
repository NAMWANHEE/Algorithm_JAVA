import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class bj_25512 {
	static int n;
	static List<Integer> [] tree;
	static int [][] cost;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		tree = new ArrayList[n];
		for(int i=0;i<n;i++) {
			tree[i] = new ArrayList<>();
		}
		for(int i=0;i<n-1;i++) {
			int node = sc.nextInt();
			int son = sc.nextInt();
			tree[node].add(son);
			tree[son].add(node);
		}
		cost = new int[n][2];
		for(int i=0;i<n;i++) {
			int w = sc.nextInt();
			int b = sc.nextInt();
			cost[i][0] = w;
			cost[i][1] = b;

		}
		System.out.println(Math.min(bfs(0), bfs(1)));


	}
	public static long bfs(int color) {
		boolean visit[] = new boolean[n];
		long sum = 0;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0,color});
		visit[0] = true;
		sum += cost[0][color];
		while(!q.isEmpty()) {
			int arr[] = q.poll();
			for(int next: tree[arr[0]]) {
				if(visit[next]) continue;
				visit[next] = true;
				sum += cost[next][(arr[1]+1)%2];
				q.add(new int[] {next, (arr[1]+1)%2});
			}
		}
		return sum;
	}

}
