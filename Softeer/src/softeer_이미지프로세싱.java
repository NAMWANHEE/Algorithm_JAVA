import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class softeer_이미지프로세싱 {
	static int h,w,map[][];
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		for(int i=0;i<h;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<w;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int q = Integer.parseInt(br.readLine());
		for(int i=0;i<q;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			method(x,y,c);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(j==w-1) sb.append(map[i][j]+"\n");
				else
					sb.append(map[i][j]+" ");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

	private static void method(int x, int y, int c) {
		int num = map[x][y];
		boolean visit [][] = new boolean[h][w];
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y});
		visit[x][y] = true;
		map[x][y] = c;
		while(!q.isEmpty()) {
			int arr[] = q.poll();
			for(int i=0;i<4;i++) {
				int nx = arr[0]+dx[i];
				int ny = arr[1]+dy[i];
				if(nx<0||ny<0||nx>=h||ny>=w) continue;
				if(map[nx][ny] != num) continue;
				if(visit[nx][ny]) continue;
				map[nx][ny] = c;
				visit[nx][ny] = true;
				q.add(new int[] {nx,ny});
			}
			
		}
		
	}

}
