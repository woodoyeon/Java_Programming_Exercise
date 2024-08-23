package Java_Programming_Exercise;

import java.util.Scanner;

public class RectangleArea {

	public static void main(String[] args) {
		
		  Scanner sc = new Scanner(System.in);

	        System.out.print("가로 길이 : ");
	        double nun1 = sc.nextDouble();

	        System.out.print("세로 길이 : ");
	        double nun2 = sc.nextDouble();

	        double gyul = nun1 * nun2;
	        System.out.println("직사각형의 넓이: " + gyul + "cm입니다.");
	        

	}

}
