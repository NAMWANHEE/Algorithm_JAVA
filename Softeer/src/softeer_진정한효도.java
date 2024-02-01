import java.util.Scanner;

public class softeer_진정한효도 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int map [][] = new int[3][3];

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                map[i][j] = sc.nextInt();
            }
        }
        int ans = 10000;
        for(int i=0;i<3;i++){
            int arr [] = new int[4];
            for(int j=0;j<3;j++){
                arr[map[i][j]] += 1;
            }
            int idx = 1;
            for(int j=1;j<4;j++){
                if(arr[j] >= 2) {
                    idx = j;
                    break;
                }
            }
            int sum = 0;
            for(int j=1;j<4;j++){
                if(arr[j] >= 1) {
                	sum += Math.abs(idx-j);
                }
            }
            ans = Math.min(ans, sum);
        }
        for(int j=0;j<3;j++){
            int arr [] = new int[4];
            for(int i=0;i<3;i++){
                arr[map[i][j]] += 1;
            }
            int idx = 1;
            for(int i=1;i<4;i++){
                if(arr[i] >= 2) {
                    idx = i;
                    break;
                }
            }
            int sum = 0;
            for(int i=1;i<4;i++){
                if(arr[i] >= 1) {
                	sum += Math.abs(idx-i);
                }
            }
            ans = Math.min(ans, sum);
    }
        System.out.println(ans);
}

}
