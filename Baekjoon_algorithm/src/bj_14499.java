import java.util.Scanner;

public class bj_14499 {

	static int dx[] = {0,0,0,-1,1};
	static int dy[] = {0,1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int k = sc.nextInt();
		int [] dice = {0,0,0,0,0,0}; // 위 북 동 남 서 아래
		int map[][] = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0;i<k;i++) {
			int num = sc.nextInt();
			if(x+dx[num]<0 || x+dx[num]>=n || y+dy[num]<0||y+dy[num]>=m) continue;
			x = x+dx[num];
			y = y+dy[num];
			int [] ndice = new int[6];
			for(int z=0;z<6;z++) {
				ndice[z] = dice[z];
			}
			if(num==1) {
				ndice[5] = dice[2];
				ndice[4] = dice[5];
				ndice[2] = dice[0];
				ndice[0] = dice[4];
			}
			else if(num==2) {
				ndice[5] = dice[4];
				ndice[4] = dice[0];
				ndice[2] = dice[5];
				ndice[0] = dice[2];
			}
			else if(num==3) {
				ndice[5] = dice[1];
				ndice[3] = dice[5];
				ndice[1] = dice[0];
				ndice[0] = dice[3];
			}
			else {
				ndice[5] = dice[3];
				ndice[3] = dice[0];
				ndice[1] = dice[5];
				ndice[0] = dice[1];
			}
			for(int z=0;z<6;z++) {
				dice[z] = ndice[z];
			}
			if(map[x][y] == 0) map[x][y] = dice[5];
			else {
				dice[5] = map[x][y];
				map[x][y] = 0;
			}
			System.out.println(dice[0]);
		}

	}

}
