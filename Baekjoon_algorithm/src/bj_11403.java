import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class bj_11403 {

	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		int n = sc.nextInt();
		int map[][] = new int[n][n];
		List<Integer> [] list = new ArrayList[n+1];
		for(int i=0;i<n+1;i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int num = sc.nextInt();
				if(num==1) list[i].add(j);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			int arr[] = new int[n];
			Queue<Integer> q = new ArrayDeque<>();
			q.add(i);
			while(!q.isEmpty()) {
				int num = q.poll();
				
				for(int s: list[num]) {
					if(arr[s] == 1) continue;
					arr[s] = 1;
					q.add(s);
				}
			}
			for(int num: arr) sb.append(num+" ");
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
