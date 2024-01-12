import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class bj_20058 {

	static int map[][];
	static int cp[][];
	static int size, ans;
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	static boolean visit[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		size = (int) Math.pow(2, n);
		map= new int[size][size];
		cp = new int[size][size];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0;i<q;i++) {
			int lev = sc.nextInt();
			for(int z=0;z<size;z++) {
				for(int j=0;j<size;j++) {
					cp[z][j] = map[z][j];
				}
			}
			storm(lev);
			
		}
		int ice = 0;
		ans = 0;
		visit = new boolean[size][size];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				ice += map[i][j];
				if(map[i][j] > 0 && !visit[i][j]) bfs(i,j);
			}
		}
		System.out.println(ice);
		System.out.println(ans);


	}
	private static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y});
		visit[x][y] = true;
		int cnt = 1;
		while(!q.isEmpty()) {
			int arr[] = q.poll();
			for(int i=0;i<4;i++) {
				int nx = arr[0]+dx[i];
				int ny = arr[1] +dy[i];
				if(nx<0||ny<0||nx>=size||ny>=size) continue;
				if(visit[nx][ny]) continue;
				if(map[nx][ny] <1) continue;
				q.add(new int[] {nx,ny});
				visit[nx][ny] = true;
				cnt++;
				
			}
		}
		ans = Math.max(ans, cnt);
		
	}
	private static void storm(int level) {
		if(level == 0) fire();
		else {
			int cnt = (int) Math.pow(2, level);
			for(int i=0;i<size;i+=cnt) {
				for(int j=0;j<size;j+=cnt) {
					spin(i,j,cnt);
				}
			}
			fire();
		}
		
	}
	private static void spin(int x, int y, int cnt) {
		int mii = 0;
		for(int i=x;i<x+cnt;i++) {
			int mi = 1;
			for(int j=y;j<y+cnt;j++) {
				map[i][j] = cp[x+cnt-mi++][y+mii];
			}
			mii++;
		}
		
		
	}
	private static void fire() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				cp[i][j] = map[i][j];
			}
		}
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(map[i][j] == 0) continue;
				int count = 0;
				for(int z=0;z<4;z++) {
					int nx = i+dx[z];
					int ny = j+dy[z];
					if(nx<0||ny<0||nx>=size||ny>=size) continue;
					if(map[nx][ny] >= 1) count++;
				}
				if(count<3) cp[i][j] -= 1;
			}
		}
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				map[i][j] = cp[i][j];
			}
		}
		
	}

}
