import java.util.Scanner;

public class bj_2852 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int nh = 0;
		int nt = 0;
		int one = 0;
		int two = 0;
		int oh = 0;
		int ot = 0;
		int th = 0;
		int tt = 0;
		for(int i=0;i<n;i++) {
			int team = sc.nextInt();
			String time [] = sc.next().split(":");
			int h = Integer.parseInt(time[0]);
			int t = Integer.parseInt(time[1]);
			
			if(one>two) {
				if(nt> t) {
					ot += 60-nt+t;
					oh += h-nh-1;
				}
				else {
					ot += t-nt;
					oh += h-nh;
				}
			}
			else if(two>one) {
				if(nt> t) {
					tt += 60-nt+t;
					th += h-nh-1;
				}
				else {
					tt += t-nt;
					th += h-nh;
				}
			}
			
			if(team == 1) one++;
			else two++;
			nh = h;
			nt = t;
		}
		if(one>two) {
			if(nt> 0) {
				ot += 60-nt;
				oh += 48-nh-1;
			}
			else {
				ot += nt;
				oh += 48-nh;
			}
		}
		else if(two>one) {
			if(nt> 0) {
				tt += 60-nt;
				th += 48-nh-1;
			}
			else {
				tt += nt;
				th += 48-nh;
			}
		}
		int pt = ot/60;
		ot = ot%60;
		oh += pt;
		pt = tt/60;
		tt = tt%60;
		th += pt;
		StringBuilder sb = new StringBuilder();
		if(oh < 10) sb.append("0"+Integer.toString(oh)+":");
		else sb.append(Integer.toString(oh)+":");
		
		if(ot < 10) sb.append("0"+Integer.toString(ot));
		else sb.append(Integer.toString(ot));
		sb.append("\n");
		if(th < 10) sb.append("0"+Integer.toString(th)+":");
		else sb.append(Integer.toString(th)+":");
		
		if(tt < 10) sb.append("0"+Integer.toString(tt));
		else sb.append(Integer.toString(tt));
		System.out.println(sb);

	}

}
