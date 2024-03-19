import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1245 {
	static int dx[] = {1,-1,0,0,1,1,-1,-1};
	static int dy[] = {0,0,1,-1,1,-1,1,-1};
	static int n,m,map[][];
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] !=0 && !visit[i][j]) {
					if(bfs(i,j)) {
						ans++;
					}
					
				}
			}
		}
		System.out.println(ans);

	}

	private static boolean bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		visit[x][y] = true;
		q.add(new int[] {x,y});
		boolean check = true;
		while(!q.isEmpty()) {
			int arr[] = q.poll();
			for(int i=0;i<8;i++) {
				int nx = arr[0]+dx[i];
				int ny = arr[1]+dy[i];
				if(nx<0||ny<0||nx>=n||ny>=m) continue;
				if(map[x][y] < map[nx][ny]) check = false;
				if(!visit[nx][ny] && map[nx][ny] == map[x][y]) {
					visit[nx][ny] = true;
					q.add(new int[] {nx,ny});
				}
				
			}
		}
		return check;
		
	}

}
