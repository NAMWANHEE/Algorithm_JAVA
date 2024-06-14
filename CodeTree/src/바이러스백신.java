import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 바이러스백신 {
	static int n,m, hc,virus,ans = Integer.MAX_VALUE;
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static int map[][];
	static boolean visit[][];
	static List<int[]> hospitals = new ArrayList<>();
	static boolean check[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) hospitals.add(new int[] {i,j});
				else if(map[i][j] == 0) virus++;
			}
		}
		hc = hospitals.size();
		check = new boolean[hc];
		combination(0,0);
		if(ans==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
	
	public static void combination(int count, int start) {
		if(count==m) {
			List<int[]> pick = new ArrayList<>();
			for(int i=0;i<hc;i++) {
				if(check[i]) pick.add(hospitals.get(i));
			}
			bfs(pick);
			return;
		}
		for(int i=start;i<hc;i++) {
			check[i] = true;
			combination(count+1,i+1);
			check[i] = false;
		}
		
	}

	private static void bfs(List<int[]> pick) {
		int vcnt = virus;
		int time = 0;
		Queue<int[]> q = new ArrayDeque<>(pick);
		visit = new boolean[n][n];
		for(int a[]:q) visit[a[0]][a[1]] = true;
		while(!q.isEmpty()) {
			if(vcnt == 0) break;
			int size = q.size();
			for(int i=0;i<size;i++) {
				int arr[] = q.poll();
				for(int j=0;j<4;j++) {
					int nx = arr[0]+dx[j];
					int ny = arr[1]+dy[j];
					if(nx<0||ny<0||nx>=n||ny>=n) continue;
					if(map[nx][ny] == 1) continue;
					if(visit[nx][ny]) continue;
					visit[nx][ny] = true;
					q.add(new int[] {nx,ny});
					if(map[nx][ny]!=2)vcnt--;
				}
			}
			time++;
		}
		if(vcnt == 0)
			ans = Math.min(ans, time);
	}

}
