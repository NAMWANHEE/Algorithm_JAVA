import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class bj_7569 {

	static int dx[] = {1,-1,0,0,0,0};
	static int dy[] = {0,0,1,-1,0,0};
	static int dz[] = {0,0,0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int h = sc.nextInt();
		
		int map[][][] = new int[h][n][m];
		boolean visit[][][] = new boolean[h][n][m];
		int count = 0;
		Queue<int[]> q = new ArrayDeque<>();
		for(int i=0;i<h;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<m;k++) {
					map[i][j][k] = sc.nextInt();
					if(map[i][j][k] == 0) count++;
					else if(map[i][j][k] == 1) {
						q.add(new int[] {i,j,k});
						visit[i][j][k] = true;
					}
				}
 			}
		}
		int ans = 0;
		while(!q.isEmpty()) {
			if(count==0) break;
			int size = q.size();
			for(int i=0;i<size;i++) {
				int arr[] = q.poll();
				for(int j=0;j<6;j++) {
					int nx = arr[0] +dx[j];
					int ny = arr[1] +dy[j];
					int nz = arr[2] + dz[j];
					if(nx<0||ny<0||nz<0||nx>=h||ny>=n||nz>=m) continue;
					if(visit[nx][ny][nz]) continue;
					if(map[nx][ny][nz]==-1) continue;
					visit[nx][ny][nz] = true;
					if(map[nx][ny][nz] == 0) {
						count--;
						map[nx][ny][nz] = 1;
						q.add(new int[] {nx,ny,nz});
					}
				}
			}
			ans++;
			
			
		}

		if(count!=0) System.out.println(-1);
		else System.out.println(ans);

	}

}
