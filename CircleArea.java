package Java_Programming_Exercise;

import java.util.Scanner;

public class CircleArea {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        double pi = 3.14;

	        System.out.print("반지름을 입력하세요: ");
	        double nun = sc.nextDouble();

	        double gyul = pi * nun * nun;
	        System.out.println("원의 넓이는 " + gyul+ "cm²입니다.");
	}

}
