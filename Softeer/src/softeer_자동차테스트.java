import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class softeer_자동차테스트 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		Map<Integer,Integer> map = new TreeMap<>();
		int [] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int idx = 1;
		for(int i: arr) {
			map.put(i, idx++);
		}
		for(int i=0;i<q;i++) {
			int target = sc.nextInt();
			if(map.get(target) == null) {
				System.out.println(0);
				continue;
			}
			int index = map.get(target);
			int left = index-1;
			int right = n-index;
			System.out.println(left * right);
		}


	}

}
