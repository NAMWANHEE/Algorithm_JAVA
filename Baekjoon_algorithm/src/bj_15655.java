import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class bj_15655 {

	 static int n,m;
	    static int[] arr;
	    static boolean [] visit;
	    public static void main(String[] args) throws IOException {
	        Scanner sc = new Scanner(System.in);
	        n = sc.nextInt();
	        m = sc.nextInt();
	        visit = new boolean[n+1];
	        arr = new int[n+1];
	        for(int i=1;i<n+1;i++) {
	        	arr[i] = sc.nextInt();
	        }
	        
	        Arrays.sort(arr);
	        dfs(0,new int[m],1);
	    }
		private static void dfs(int depth, int[] arr2,int idx) {
			if(depth == m) {
				for(int s: arr2) {
					System.out.print(s+" ");
				}
				System.out.println();
				return;
			}
			for(int i=idx;i<n+1;i++) {

				arr2[depth] = arr[i];
				dfs(depth+1,arr2,i+1);
				
			}
			
		}

}
