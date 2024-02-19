import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class bj_4179 {
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		char map[][] = new char[r][c];
		int map2[][] = new int[r][c];
		int map3[][] = new int[r][c];
		int jx=0,jy=0;
		boolean fi[][] = new boolean[r][c];
		Queue<int[]> fire = new ArrayDeque<>();
		for(int i=0;i<r;i++) {
			String str = sc.next();
			for(int j=0;j<c;j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'J') {
					jx = i;
					jy = j;
				}
				else if (map[i][j] == 'F') {
					fire.add(new int[] {i,j});
					fi[i][j] = true;
				}
			}
		}
		if(jx ==0 || jy ==0 || jx == r-1 || jy == c-1) {
			System.out.println(1);
		}
		else {
			while(!fire.isEmpty()) {
				int size = fire.size();
				for(int s=0;s<size;s++) {
					int arr[] = fire.poll();
					for(int i=0;i<4;i++) {
						int nx = arr[0]+dx[i];
						int ny = arr[1]+dy[i];
						if(nx<0||ny<0||nx>=r||ny>=c) continue;
						if(map[nx][ny] == '#') continue;
						if(fi[nx][ny] && map2[nx][ny] <= map2[arr[0]][arr[1]]+1) continue;
						fi[nx][ny] = true;
						map2[nx][ny] = map2[arr[0]][arr[1]]+1;
						fire.add(new int[] {nx,ny});
					}
				}
				
			}
			
			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[] {jx,jy});
			boolean visit[][] = new boolean[r][c];
			visit[jx][jy] = true;
			while(!q.isEmpty()) {
				int arr[] = q.poll();
				for(int i=0;i<4;i++) {
					int nx = arr[0]+dx[i];
					int ny = arr[1]+dy[i];
					if(nx<0||ny<0||nx>=r||ny>=c) {
						if(map3[arr[0]][arr[1]]<map2[arr[0]][arr[1]] || fi[arr[0]][arr[1]] != true) {
							System.out.println(map3[arr[0]][arr[1]]+1);
							System.exit(0);
						}
						else continue;
					}
					if(map[nx][ny] == '#') continue;
					if(visit[nx][ny]) continue;
					if(map[nx][ny] == 'F') continue;
					visit[nx][ny] = true;
					map3[nx][ny] = map3[arr[0]][arr[1]]+1;
					q.add(new int[] {nx,ny});
				}
			}
			System.out.println("IMPOSSIBLE");
		}
		
		
		
	}

}
