import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj_10655 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<int[]> list = new ArrayList<>();
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new int[] {x,y});
		}
		int idx = 0;
		int max = 0;
		for(int i=1;i<n-1;i++) {
			int[] back = list.get(i-1);
			int[] now = list.get(i);
			int[] next = list.get(i+1);
			int n1 = Math.abs(now[0]-back[0])+Math.abs(now[1]-back[1])+Math.abs(now[0]-next[0])+Math.abs(now[1]-next[1]);
			int n2 = Math.abs(next[0]-back[0])+Math.abs(next[1]-back[1]);
			if(max< Math.abs(n1-n2)) {
				max = Math.abs(n1-n2);
				idx = i;
			}
		}
		System.out.println(idx);
		list.remove(idx);
		int ans=0;
		for(int i=0;i<list.size()-1;i++) {
			int[] now = list.get(i);
			int[] next= list.get(i+1);
			ans+= Math.abs(now[0]-next[0])+Math.abs(now[1]-next[1]);
		}
		System.out.println(ans);
		

	}
	

}
