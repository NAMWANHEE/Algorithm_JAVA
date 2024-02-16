import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_21772 {
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static int r,c,t;
	static char map[][];
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		boolean visit[][] = new boolean[r][c];
		int sp [][] = new int[r][c];
		int gx = 0;
		int gy = 0;
		for(int i=0;i<r;i++) {
			String str = br.readLine();
			for(int j=0;j<c;j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'G') {
					gx = i;
					gy = j;
				}
			}
		}
		dfs(gx,gy,0,0);

		
		System.out.println(ans);

	}
	private static void dfs(int x, int y, int cnt, int move) {
		if(move == t) {
			if(cnt > ans) ans = cnt;
			return;
		}
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||ny<0||nx>=r||ny>=c) continue;
			if(map[nx][ny] == '#') continue;
			if(map[nx][ny] == 'S') {
				map[nx][ny] = '.';
				dfs(nx,ny,cnt+1,move+1);
				map[nx][ny] = 'S';
			}
			else dfs(nx,ny,cnt,move+1);
		}
		
	}

}
