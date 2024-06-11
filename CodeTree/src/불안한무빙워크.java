import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class 불안한무빙워크 {

	static int arr[], people[];
    static int n,k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        int ans = 1;
        arr = new int[n*2];
        people= new int[n*2];
        for(int i=0;i<n*2;i++){
            arr[i] = sc.nextInt();

        }

        while(true){
        	int count = 0;
            first();
            second();
            third();
            for(int i=0;i<n*2;i++) {
            	if(arr[i] ==0) count++;
            }
            if(count>=k) break;
            ans++;

        }
        System.out.println(ans);

    }

    private static void third() {
		if(people[0]==0 && arr[0]!=0) {
			arr[0]--;
			people[0] = 1;
		}
		
	}

	private static void second() {
		
    	for(int i=n-1;i>=0;i--) {
    		if(people[i] == 1) {
    			if(i==n-1) people[i] = 0;
    			else {
    				if(people[i+1] != 0) continue;
    				if(arr[i+1] == 0) continue;
    				people[i+1] = 1;
    				people[i] = 0;
    				arr[i+1]--;
    			}
    		}
    	}
		
	}

	public static void first(){
        int narr[] = new int[n*2];
        int npeople[] = new int[n*2];
        for(int i=0;i<n*2;i++){
            narr[(i+1) % (n*2)] = arr[i];
            //npeople[(i+1) % (n*2)] = people[i];
        }
        
        for(int i=1;i<n;i++) {
        	npeople[i] = people[i-1]; 
        }

        for(int i=0;i<n*2;i++) {
        	arr[i] = narr[i];
        	people[i] = npeople[i];
        }

    }

}
