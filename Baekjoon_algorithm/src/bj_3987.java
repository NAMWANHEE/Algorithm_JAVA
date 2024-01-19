import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class bj_3987 {
	static int n,m;
	static char map[][];
	static int[] dx = {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new char[n][m];
		for(int i=0;i<n;i++) {
			String str = sc.next();
			for(int j=0;j<m;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int x = sc.nextInt()-1;
		int y = sc.nextInt()-1;
		int ans = 0;
		int cnt[] = new int[4];
		// i°¡ 0ÀÏ¶© À§, 1ÀÏ¶© ¿À¸¥ÂÊ, 2ÀÏ¶© ¾Æ·¡, 3ÀÏ¶© ¿ÞÂÊ ¹æÇâ
		for(int i=0;i<4;i++) {
			int num = signal(x,y,i);
			cnt[i] = num;
			ans = Math.max(ans, num);
			
		}
		Map<Integer,String> map = new HashMap<>();
		map.put(0, "U");
		map.put(1, "R");
		map.put(2, "D");
		map.put(3, "L");
		for(int i=0;i<4;i++) {
			if(cnt[i] == ans && cnt[i]==Integer.MAX_VALUE) {
				System.out.println(map.get(i));
				System.out.println("Voyager");
				break;
			}
			else if(cnt[i] == ans) {
				System.out.println(map.get(i));
				System.out.println(cnt[i]);
				break;
			}
		}


	}
	private static int signal(int x, int y, int w) {
		boolean check[][][] = new boolean[n][m][4];
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y,w});
		int cnt = 1;
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int nx = arr[0]+dx[arr[2]];
			int ny = arr[1]+dy[arr[2]];
			if(nx<0||ny<0||nx>=n||ny>=m) return cnt;
			if(map[nx][ny] == 'C') return cnt;
			if(map[nx][ny] =='.') {
				if(check[nx][ny][arr[2]]) return Integer.MAX_VALUE;
				check[nx][ny][arr[2]] = true;
				q.add(new int[] {nx,ny,arr[2]});
			}
			else if(map[nx][ny] == '/') {
				if(arr[2]==0 || arr[2] ==2) {
					if(check[nx][ny][arr[2]+1]) return Integer.MAX_VALUE;
					q.add(new int[] {nx,ny,arr[2]+1});
					check[nx][ny][arr[2]+1] = true;
				}
				else {
					if(check[nx][ny][arr[2]-1]) return Integer.MAX_VALUE;
					q.add(new int[] {nx,ny,arr[2]-1});
					check[nx][ny][arr[2]-1] = true;
				}
			}
			else {
				if(arr[2]==0 || arr[2]==2) {
					int nw = 4-arr[2]-1;
					if(check[nx][ny][nw]) return Integer.MAX_VALUE;
					q.add(new int[] {nx,ny,nw});
					check[nx][ny][nw] = true;
				}
				else {
					int nw = (arr[2]+1) % 4;
					if(check[nx][ny][nw]) return Integer.MAX_VALUE;
					q.add(new int[] {nx,ny,nw});
					check[nx][ny][nw] = true;
				}
			}
			cnt++;
					
					
			
		}
		return cnt;
		
	}
}


