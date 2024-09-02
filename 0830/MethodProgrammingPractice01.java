package JavaBasics_8_31;

import java.util.Scanner;

public class MethodProgrammingPractice01 {

    public static void main(String[] args) {
        
    	System.out.println("각 배열의 수를 입력하세요 : ");
    	Scanner sc = new Scanner(System.in);
    	int arrNum = sc.nextInt();
    	
    	int[]arr = new int[arrNum];
    	
    	System.out.println("입력한 배열의 수만큼 숫자를 입력하세요.");
        for(int i = 0; i < arrNum; i++) {
        	arr[i] = sc.nextInt();
        	
        	int sum = getSum(arr);

        	
        }
        
      
    }

	private static int getSum(int[] arr) {
		
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
}  
 
