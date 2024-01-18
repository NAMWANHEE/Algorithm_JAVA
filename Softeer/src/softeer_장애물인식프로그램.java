import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class softeer_장애물인식프로그램 {

	static int n;
	static int map[][];
	static boolean visit[][];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map  = new int[n][n];
		visit = new boolean[n][n];
		for(int i=0;i<n;i++) {
			String str = sc.next();
			for(int j=0;j<n;j++) {
				map[i][j] = str.charAt(j)-48;
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j] == 1 && !visit[i][j]) bfs(i,j);
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int ans: list) {
			System.out.println(ans);
		}

	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y});
		visit[x][y] = true;
		int cnt = 1;
		while(!q.isEmpty()) {
			int [] arr = q.poll();
			for(int i=0;i<4;i++) {
				int nx = arr[0]+dx[i];
				int ny = arr[1]+dy[i];
				if(nx<0||ny<0||nx>=n||ny>=n) continue;
				if(visit[nx][ny]) continue;
				if(map[nx][ny] != 1) continue;
				visit[nx][ny] = true;
				q.add(new int[] {nx,ny});
				cnt++;
			}
		}
		list.add(cnt);
	}

}
