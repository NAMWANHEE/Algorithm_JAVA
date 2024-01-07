import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class bj_5014 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int f = sc.nextInt();
		int s = sc.nextInt();
		int g = sc.nextInt();
		int u = sc.nextInt();
		int d = sc.nextInt();
		int map [] = new int[f+1];
		boolean check[] = new boolean[f+1];
		int arr [] = new int[] {u,d};
		Queue<Integer> q = new ArrayDeque<>();
		q.add(s);
		check[s] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now == g) break;
			int up = now+u;
			if(up <= f && !check[up]) {
				q.add(up);
				check[up] = true;
				map[up] = map[now] + 1;
			}
			
			int down = now-d;
			if(down<1) continue;
			if(check[down]) continue;
			q.add(down);
			check[down] = true;
			map[down] = map[now] + 1;
			
		}
		if(s == g) {
			System.out.println(0);
		}
		else if(map[g] ==0) {
			System.out.println("use the stairs");
		}
		else
			System.out.println(map[g]);

	}

}
