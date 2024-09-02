package JavaBasics_8_31;

import java.util.Scanner;

public class ControlStatementsMethodPractice {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num;
        int choice;

        do {
            System.out.print("숫자를 입력하세요: ");
            num = sc.nextInt();

            if (num == 0) {
                break;  // 0이 입력되면 반복문을 종료합니다.
            }

            if (num % 2 == 0) {
                System.out.println(">> 짝수입니다.");
            } else {
                System.out.println(">> 홀수입니다.");
            }

            System.out.print("계속 하시겠습니까? (0-멈춤/1-계속): ");
            choice = sc.nextInt();

        } while (choice != 0);

        sc.close();  
    }
}
