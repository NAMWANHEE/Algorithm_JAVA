import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj_16946 {
	
	static int n,m,map[][],chcnt=1;
	static boolean visit[][];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static int [][] nmap;
	static int [][] vmap;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		nmap = new int[n][m];
		vmap = new int[n][m];
		visit = new boolean[n][m];
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] == 0 && !visit[i][j]) {
					bfs(i,j);
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] == 1) {
					boolean check[] = new boolean[chcnt+1];
					for(int s=0;s<4;s++) {
						int nx = i+dx[s];
						int ny = j+dy[s];
						if(nx<0||ny<0||nx>=n||ny>=m) continue;
						if(check[vmap[nx][ny]])continue;
						check[vmap[nx][ny]] = true;
						map[i][j] += nmap[nx][ny];
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				sb.append(map[i][j]%10);
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
	private static void bfs(int x, int y) {
		visit[x][y] = true;
		Queue<int[]> q = new ArrayDeque<>();
		List<int[]> list = new ArrayList<>();
		q.add(new int[] {x,y});
		list.add(new int[] {x,y});
		int cnt = 1;
		while(!q.isEmpty()) {
			int [] arr = q.poll();
			for(int i=0;i<4;i++) {
				int nx = arr[0]+dx[i];
				int ny = arr[1]+dy[i];
				if(nx<0||ny<0||nx>=n||ny>=m) continue;
				if(visit[nx][ny]) continue;
				if(map[nx][ny] == 1) continue;
				visit[nx][ny] = true;
				cnt++;
				q.add(new int[] {nx,ny});
				list.add(new int[] {nx,ny});
			}
		}
		
		for(int []a: list) {
			nmap[a[0]][a[1]] = cnt % 10;
			vmap[a[0]][a[1]] = chcnt;
		}
		chcnt++;
		
		
	}

}
