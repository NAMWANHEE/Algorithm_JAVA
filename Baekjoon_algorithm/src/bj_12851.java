import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class bj_12851 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		if(n == k) {
			System.out.println(0);
			System.out.println(1);
			System.exit(0);
		}
		boolean visit[] = new boolean[200001];
		visit[n] = true;
		Queue<Integer> q = new ArrayDeque<>();
		q.add(n);
		int time = 0;
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			boolean check = false;
			List<Integer> list = new ArrayList<>();
			for(int i=0;i<size;i++) {
				int subin = q.poll();
				int move1 = subin+1;
				if(move1 <200001 && !visit[move1]) {
					list.add(move1);
					q.add(move1);
					if(move1 == k) {
						check = true;
						cnt ++;
					}
				}
				int move2 = subin-1;
				if(move2 >= 0 && !visit[move2]) {
					list.add(move2);
					q.add(move2);
					if(move2 == k) {
						check = true;
						cnt ++;
					}
				}
				int move3 = subin*2;
				if(move3<200001 && !visit[move3]) {
					list.add(move3);
					q.add(move3);
					if(move3 == k) {
						check = true;
						cnt ++;
					}
				}
			}
			for(int s:list) {
				visit[s] = true;
			}
			time++;
			if(check) break;
		}
		System.out.println(time);
		System.out.println(cnt);

	}

}
