import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class bj_18404 {
	static int dx [] = {-2,-2,-1,-1,1,1,2,2};
	static int dy[] = {-1,1,-2,2,-2,2,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt()-1;
		int y = sc.nextInt()-1;
		int map[][] = new int[n][n];
		int cnt = 3;
		List<int[]> list = new ArrayList<>();
		boolean check[][] = new boolean[n][n];
		for(int i=0;i<m;i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			list.add(new int[] {a,b});
			map[a][b] = 1;
			
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y});
		check[x][y] = true;
		while(!q.isEmpty()) {
			int [] arr = q.poll();
			
			for(int i=0;i<8;i++) {
				int nx = arr[0]+dx[i];
				int ny = arr[1]+dy[i];
				if(nx<0||ny<0||nx>=n||ny>=n) continue;
				if(check[nx][ny]) continue;
				map[nx][ny] = map[arr[0]][arr[1]] + 1;
				check[nx][ny] =true;
				q.add(new int[] {nx,ny});
			}
		}
		
		for(int [] a: list) {
			System.out.print(map[a[0]][a[1]]+" ");
		}

	}

}
