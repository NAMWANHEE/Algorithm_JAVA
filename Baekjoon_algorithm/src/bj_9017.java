import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class bj_9017 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=0;tc<t;tc++) {
			Map<Integer,Integer> check = new HashMap<>();
			int ans = -1;
			int [] point = new int[201];
			int [] counting = new int[201];
			int n = sc.nextInt();
			List<Integer> list = new ArrayList<>(); // 입력 받은 팀 저장하는 리스트
			for(int i=0;i<n;i++) {
				int team = sc.nextInt();
				list.add(team);
				if(check.containsKey(team)) {
					check.put(team, check.get(team)+1);
				}
				else {
					check.put(team, 1);
				}
			}
			int points = 1;
			
			for(int i: list) {
				if(check.get(i)<6) continue;
				else {
					if(counting[i] < 4) {
						point[i] += points;
					}
					points++;
					counting[i] += 1;
				}
			}
			List<Integer> list2 = new ArrayList<>(); // 점수가 가장 낮은 팀을 담을 리스트 
			int minnum = Integer.MAX_VALUE;
			for(int i=0;i<201;i++) {
				if(point[i] == 0) continue;
				if(point[i] < minnum) {
					list2.clear();
					list2.add(i);
					minnum = point[i];
				}
				else if(point[i] == minnum) list2.add(i);
			}
			int [] count = new int[201];
			for(int i:list) {
				if(list2.contains(i)) {
					count[i]++;
					if(count[i]==5) {
						System.out.println(i);
						break;
					}
				}
			}
			
		}
		
		
		

	}

}
