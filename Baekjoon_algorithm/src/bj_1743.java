import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class bj_1743 {

	static int dx [] = {1,-1,0,0};
	static int dy [] = {0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int map[][] = new int[n][m];
		boolean visit[][] = new boolean[n][m];
		for(int i=0;i<k;i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			map[x][y] = 1;
		}
		int ans = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					visit[i][j] = true;
					Queue<int[]> q = new ArrayDeque<>();
					q.add(new int[] {i,j});
					int cnt = 1;
					while(!q.isEmpty()) {
						int []arr = q.poll();
						
						for(int z=0;z<4;z++) {
							int nx = arr[0] + dx[z];
							int ny = arr[1] + dy[z];
							if(nx<0||ny<0||nx>=n||ny>=m) continue;
							if(map[nx][ny] ==0 || visit[nx][ny]) continue;
							visit[nx][ny] = true;
							cnt++;
							q.add(new int[] {nx,ny});
							
						}
					}
					ans = Math.max(ans, cnt);
				}
			}
		}
		System.out.println(ans);

	}

}
