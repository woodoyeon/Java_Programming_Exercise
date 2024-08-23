package Java_Programming_Exercise;

import java.util.Scanner;

public class EvenOddChecker {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);

	        System.out.print("숫자를 입력하세요: ");
	        int nun = sc.nextInt();

	        if (nun % 2 == 0) {
	            System.out.println("짝수입니다.");
	        } else {
	            System.out.println("홀수입니다.");
	        }

	}

}
