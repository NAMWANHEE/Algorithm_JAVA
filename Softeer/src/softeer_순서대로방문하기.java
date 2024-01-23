import java.util.Scanner;

public class softeer_순서대로방문하기 {
	
	static int map[][],n,m, nmap[][],ans=0;
	static boolean visit[][];
	static int dx [] = {1,-1,0,0};
	static int dy [] = {0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][n];
		nmap = new int[n][n];
		visit = new boolean[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int sx = sc.nextInt()-1;
		int sy = sc.nextInt()-1;
		visit[sx][sy] = true;
		nmap[sx][sy] = 1;
		for(int i=1;i<m;i++) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			nmap[x][y] = i+1;
		}
		
		dfs(sx,sy,1);
		System.out.println(ans);
	}
	private static void dfs(int x, int y, int depth) {
		if(depth == m) {
			ans++;
			return;
		}
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0||ny<0||nx>=n||ny>=n) continue;
			if(map[nx][ny] == 1) continue;
			if(visit[nx][ny]) continue;
			if(nmap[nx][ny]!=0 && nmap[nx][ny] != depth+1) continue;
			if(nmap[nx][ny] == depth+1) {
				visit[nx][ny] = true;
				dfs(nx,ny,depth+1);
				visit[nx][ny] = false;
			}
			else {
				visit[nx][ny] = true;
				dfs(nx,ny,depth);
				visit[nx][ny] = false;
			}
		}
		
		
	}

}
