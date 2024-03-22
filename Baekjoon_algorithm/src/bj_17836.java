import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_17836 {
	
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int map[][] = new int[n][m];
		boolean visit[][][] = new boolean[n][m][2];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<int[]> q = new ArrayDeque<>();
		visit[0][0][0] = true;
		q.add(new int[] {0,0,0,0});
		while(!q.isEmpty()) {
			int arr[] = q.poll();
			if(arr[3]>t) {
				System.out.println("Fail");
				System.exit(0);
			}
			if(arr[0]==n-1 && arr[1]==m-1) {
				System.out.println(arr[3]);
				System.exit(0);
				
			}
			for(int i=0;i<4;i++) {
				int nx = dx[i] +arr[0];
				int ny = dy[i] + arr[1];
				if(nx<0||ny<0||nx>=n||ny>=m)continue;
				if(visit[nx][ny][arr[2]]) continue;
				if(map[nx][ny] == 1) {
					if(arr[2] == 0)continue;
					q.add(new int[] {nx,ny,arr[2],arr[3]+1});
					visit[nx][ny][arr[2]] = true;
				}
				if(map[nx][ny] == 2) {
					q.add(new int[] {nx,ny,1,arr[3]+1});
					visit[nx][ny][arr[2]] = true;
				}
				else {
					q.add(new int[] {nx,ny,arr[2],arr[3]+1});
					visit[nx][ny][arr[2]] = true;
				}
			}
		}
		System.out.println("Fail");
	}

}
