import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_5427 {
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for(int tc=0;tc<t;tc++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			char [][] map = new char[n][m];
			boolean [][] visit = new boolean[n][m];
			Queue<int[]> person = new ArrayDeque<>();
			Queue<int[]> fire = new ArrayDeque<>();
			for(int i=0;i<n;i++) {
				String str = br.readLine();
				for(int j=0;j<m;j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '@') person.add(new int[] {i,j});
					else if(map[i][j] == '*') fire.add(new int[] {i,j});
				}
			}
			int [] ar = person.peek();
			if(ar[0]==0 || ar[1] ==0 ||ar[0] == n-1 ||ar[1] == m-1) {
				System.out.println(1);
				continue;
			}
			int ans = 1;
			boolean check = false;
			while(!person.isEmpty()) {
				int fire_size = fire.size();
				for(int i=0;i<fire_size;i++) {
					int arr[] = fire.poll();
					for(int j=0;j<4;j++) {
						int nx = arr[0]+dx[j];
						int ny = arr[1]+dy[j];
						if(nx<0||ny<0||nx>=n||ny>=m) continue;
						if(visit[nx][ny]) continue;
						if(map[nx][ny] != '.') continue;
						visit[nx][ny] = true;
						map[nx][ny] = '*';
						fire.add(new int[] {nx,ny});
					}
				}
				int person_size = person.size();
				for(int i=0;i<person_size;i++) {
					int arr[] = person.poll();
					for(int j=0;j<4;j++) {
						int nx = arr[0]+dx[j];
						int ny = arr[1]+dy[j];
						if(nx<0||ny<0||nx>=n||ny>=m) continue;
						if(visit[nx][ny]) continue;
						if(map[nx][ny] != '.') continue;
						if(nx ==0 ||ny ==0||nx==n-1||ny==m-1) {
							check = true;
							break;
						}
						visit[nx][ny] = true;
						map[nx][ny] = '@';
						person.add(new int[] {nx,ny});
					}
					if(check) break;
				}
				if(check) break;
				ans++;
			}
			if(check) System.out.println(ans+1);
			else System.out.println("IMPOSSIBLE");
		}

	}

}
