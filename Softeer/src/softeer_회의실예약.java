import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class softeer_회의실예약 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Map<String,Integer> map = new HashMap<>();
		int num = 0;
		for(int i=0;i<n;i++) {
			String name = sc.next();
			map.put(name, num++);
		}
		int room [][] = new int[n][20];
		for(int i=0;i<n;i++) {
			room[i][8] = 1;
			room[i][19] = 1;
		}
		for(int i=0;i<m;i++) {
			String name = sc.next();
			int start = sc.nextInt();
			int end = sc.nextInt();
			for(int j=start;j<end;j++) {
				room[map.get(name)][j] = 1;
			}
		}
		
		
		List<String> list = new ArrayList<>();
		for(String name:map.keySet()) {
			list.add(name);
		}
		Collections.sort(list);
		String aa = list.get(n-1);
		for(String name: list) {
			System.out.println("Room "+name+":");
			int cnt = 0;
			for(int i=9;i<18;i++) {
				if(room[map.get(name)][i]==0 && room[map.get(name)][i-1]==1) {
					cnt++;
				}
			}
			if(cnt==0) System.out.println("Not available");
			else System.out.println(cnt+" available:");
			for(int i=9;i<19;i++) {
				if(room[map.get(name)][i]==0 && room[map.get(name)][i-1]==1 && i!=18) {
					if(String.valueOf(i).length() == 1) {
						System.out.print("0"+String.valueOf(i)+"-");
					}
					else System.out.print(String.valueOf(i)+"-");
				}
				else if(room[map.get(name)][i]==1 && room[map.get(name)][i-1]==0) {
					if(String.valueOf(i).length() == 1) {
						System.out.println("0"+String.valueOf(i));
					}
					else System.out.println(String.valueOf(i));
				}
				else if(i==18&& room[map.get(name)][i-1]==0) {
					System.out.println(String.valueOf(i));
				}
			}
			if(!name.equals(aa))
				System.out.println("-----");
		}

	}

}
