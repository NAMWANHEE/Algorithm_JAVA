
public class 롤케이크자르기 {

	public int solution(int[] topping) {
        int answer = 0;
        int left = 1;
        int right = 0;
        int larr[] = new int[10001];
        int rarr[] = new int[10001];
        larr[topping[0]]++;
        for(int i=1;i<topping.length;i++){
            if(rarr[topping[i]]==0)right++;
            rarr[topping[i]] += 1;
        }
        int idx = 1;
        while(left<=right){
            if(left==right) answer++;
            if(rarr[topping[idx]] ==1) {
                right--;
            }
            rarr[topping[idx]]--;
            if(larr[topping[idx]] ==0){
                left++;
            }
            larr[topping[idx]]++;
            idx++;
        
        }
        return answer;
    }

}
