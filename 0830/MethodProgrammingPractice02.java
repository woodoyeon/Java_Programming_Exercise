//배열에 저장된 숫자 중 입력된 숫자보다 큰 수가 몇 개있는지 구하기

package JavaBasics_8_31;

import java.util.Scanner;

public class MethodProgrammingPractice02 {

public static void main(String[] args) {
	
	
	Scanner sc = new Scanner(System.in);
	System.out.println("배열의 크기를 입력하세요: ");
	int arrNum = sc.nextInt();
	
	int[] arr = new int[arrNum];
	System.out.println("배열의 요소를 입력하세요:");
	
	 for(int i = 0; i < arrNum; i++) {
         arr[i] = sc.nextInt();
     }
	 
	 System.out.println("기준 숫자를 입력하세요:");
	 int referenceNum = sc.nextInt();
	
	 int count = getSum(arr, referenceNum);
	 
	 System.out.println("기준 숫자보다 큰 수의 개수는: " + count);
	}

private static int getSum(int[] arr, int referenceNum) {
	int count = 0;
	for(int i = 0; i < arr.length; i++) {
		if(arr[i] > referenceNum) {
			count++;
		}
	}
	return 0;
}

	

	
}
