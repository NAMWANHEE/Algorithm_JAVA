import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class bj_13549 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		boolean [] check = new boolean[100001];
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {n,0});
		int ans = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int arr[] = q.poll();
			check[arr[0]] = true;
			if(arr[0] == k) {
				ans = Math.min(ans, arr[1]);
			}
			if(arr[0]*2 <= 100000 && check[arr[0]*2] == false) {
				q.add(new int[] {arr[0]*2, arr[1]});
			}
			if(arr[0]+1 <= 100000 && check[arr[0]+1] == false) {
				q.add(new int[] {arr[0]+1,arr[1]+1});
			}
			
			if(arr[0]-1 >= 0 && check[arr[0]-1] == false) {
				q.add(new int[] {arr[0]-1,arr[1]+1});
			}
		}
		System.out.println(ans);

	}

}
