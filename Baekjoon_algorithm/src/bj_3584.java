import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class bj_3584 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=0;tc<t;tc++) {
			int n = sc.nextInt();
			List<Integer> [] list = new ArrayList[n+1];
			for(int i=0;i<n+1;i++) {
				list[i] = new ArrayList<>();
			}
			for(int i=0;i<n-1;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				list[b].add(a);
			}
			boolean visit[] = new boolean[n+1];
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			visit[node1] = true;
			Queue<Integer> q = new ArrayDeque<>();
			q.add(node1);
			while(!q.isEmpty()) {
				int num = q.poll();
				for(int z:list[num]) {
					visit[z] = true;
					q.add(z);
				}
			}

			
			Queue<Integer> q2= new ArrayDeque<>();
			q2.add(node2);
			while(!q2.isEmpty()) {
				int num = q2.poll();
				if(visit[num]) {
					System.out.println(num);
					break;
				}
				for(int z:list[num]) {

					q2.add(z);
				}
			}
		}

	}

}
