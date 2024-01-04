import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class bj_1261 {
	
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int map [][] = new int[m][n];
		boolean check[][] = new boolean[m][n];
		
		for(int i=0;i<m;i++) {
			String str = sc.next();
			for(int j=0;j<n;j++) {
				map[i][j] = str.charAt(j)-48;
			}
		}
		PriorityQueue<Point> q = new PriorityQueue<>();
		q.add(new Point(0,0,0));
		check[0][0] = true;
		int ans = 0;
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.x == m-1 && p.y == n-1) {
				ans =p.cnt;
				break;
			}
			for(int i=0;i<4;i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(nx<0||ny<0||nx>=m || ny>=n) continue;
				if(check[nx][ny]) continue;
				check[nx][ny] = true;
				if(map[nx][ny] == 1) {
					q.add(new Point(nx,ny,p.cnt+1));
				}
				else {
					q.add(new Point(nx,ny,p.cnt));
				}

					
				}
			}
		System.out.println(ans);
			
	}
	
	public static class Point implements Comparable<Point>{
		int x,y,cnt;
		public Point(int x,int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Point o) {
			return this.cnt - o.cnt;
		}
	}

}
