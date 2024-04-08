import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class bj_2174 {

	static int dx [] = {-1,0,1,0};
	static int dy [] = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int map[][] = new int[b][a];
		Map<Integer,int[]> robot = new HashMap<>();
		for(int i=1;i<n+1;i++) {
			int y = sc.nextInt()-1;
			int x = Math.abs(sc.nextInt()-b);
			String str = sc.next();
			int d;
			if(str.equals("N")) d = 0;
			else if(str.equals("E")) d=1;
			else if(str.equals("S")) d=2;
			else d=3;
			map[x][y] = i;
			robot.put(i, new int[] {x,y,d});
		}
		
		for(int i=0;i<m;i++) {
			int num = sc.nextInt();
			String command = sc.next();
			int cnt = sc.nextInt();
			int[] arr = robot.get(num);
			for(int j=0;j<cnt;j++) {
				if(command.equals("L"))  arr[2] = (arr[2]+3) %4;
				else if(command.equals("R")) arr[2] = (arr[2]+1) %4;
				else {
					int nx = arr[0]+dx[arr[2]];
					int ny = arr[1]+dy[arr[2]];
					if(nx<0||ny<0||nx>=b||ny>=a) {
						System.out.printf("Robot %d crashes into the wall",num);
						System.exit(0);
					}
					if(map[nx][ny] != 0) {
						System.out.printf("Robot %d crashes into robot %d",num,map[nx][ny]);
						System.exit(0);
					}
					map[arr[0]][arr[1]] = 0;
					map[nx][ny] = num;
					arr[0] = nx;
					arr[1] = ny;
				}
			}
			robot.put(num, arr);
		}
		System.out.println("OK");

	}

}
