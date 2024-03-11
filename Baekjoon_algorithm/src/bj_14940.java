import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_14940 {
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int map[][] = new int[n][m];
		int distance[][] = new int[n][m];
		boolean visit[][] = new boolean[n][m];
		Queue<int[]> q = new ArrayDeque<>();
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					q.add(new int[] {i,j});
					visit[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int [] arr = q.poll();
			for(int i=0;i<4;i++) {
				int nx = arr[0]+dx[i];
				int ny = arr[1]+dy[i];
				if(nx<0||ny<0||nx>=n||ny>=m) continue;
				if(visit[nx][ny]) continue;
				if(map[nx][ny] != 1) continue;
				visit[nx][ny] =  true;
				distance[nx][ny] = distance[arr[0]][arr[1]]+1;
				q.add(new int[] {nx,ny});
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] == 1 && !visit[i][j]) distance[i][j] = -1;
				sb.append(distance[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
