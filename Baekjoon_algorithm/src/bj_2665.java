import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class bj_2665 {

	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int map[][] = new int[n][n];
		boolean visit[][] = new boolean[n][n];
		for(int i=0;i<n;i++) {
			String str = sc.next();
			for(int j=0;j<n;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		if(n==1) {
			System.out.println(0);
			System.exit(0);
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
		pq.add(new int[] {0,0,0});
		visit[0][0] = true;
		
		while(!pq.isEmpty()) {
			int arr [] = pq.poll();
			if((arr[0]==n-1 && arr[1]==n-2)||(arr[0]==n-2 && arr[1]==n-1)) {
				System.out.println(arr[2]);
				break;
			}
			for(int i=0;i<4;i++) {
				int nx = arr[0]+dx[i];
				int ny = arr[1]+dy[i];
				
				if(nx<0||ny<0||nx>=n||ny>=n) continue;
				if(visit[nx][ny]) continue;
				visit[nx][ny] = true;
				if(map[nx][ny] == 0) {
					pq.add(new int[] {nx,ny,arr[2]+1});
				}
				else {
					pq.add(new int[] {nx,ny,arr[2]});
				}
				
			}
			
		}
		
		

	}

}
