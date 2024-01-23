import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class softeer_동계테스트시점예측 {

	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int map[][] = new int[n][m];
		int count = 0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) count++;
			}
		}
		int ans = 0;
		while(count != 0) {
			boolean visit[][] = new boolean[n][m];
			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[] {0,0});
			visit[0][0] = true;
			while(!q.isEmpty()) {
				int arr[] = q.poll();
				for(int i=0;i<4;i++) {
					int nx = arr[0]+dx[i];
					int ny = arr[1]+dy[i];
					if(nx<0||ny<0||nx>=n||ny>=m) continue;
					if(visit[nx][ny]) continue;
					if(map[nx][ny] == 0) {
						visit[nx][ny] = true;
						q.add(new int[] {nx,ny});
					}
					else  {
						map[nx][ny]+=1;
					}
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j] >2) {
						map[i][j] = 0;
						count--;
					}
					else if(map[i][j]==2) {
						map[i][j] = 1;
					}
				}
			}
			ans++;
			

		}
		System.out.println(ans);

	


	}

}
