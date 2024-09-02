package JavaBasics_8_31;

import java.util.Scanner;

public class StudentCountAndScores {

    public static void main(String[] args) {
        
        int num = inputScanner();  // 학생 수 입력받기
        int[] scores = new int[num];
        int sum = studentNum(scores, num);  // 점수 입력받고 합계 계산
        double average = calculateAverage(sum, num);  // 평균 계산
      
        printResults(sum, average);  // 결과 출력
    }
    
    // 학생 수를 입력받는 메서드
    public static int inputScanner() {
        System.out.print("학생 수 입력: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    
    // 학생 점수를 입력받고 합계를 계산하는 메서드
    public static int studentNum(int[] scores, int num) {
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < num; i++) {  // 배열의 인덱스는 0부터 시작, 반복문 조건 수정
            System.out.print("학생 " + (i + 1) + "번째 점수 입력: ");
            scores[i] = sc.nextInt();
            sum += scores[i];
        }
        return sum;
    }
    
    // 평균을 계산하는 메서드
    public static double calculateAverage(int sum, int num) {
        return sum / (double) num;  // 실수형 나눗셈을 통해 정확한 평균 계산
    }
    
    // 합계와 평균을 출력하는 메서드
    public static void printResults(int sum, double average) {
        System.out.println("합계는: " + sum);
        System.out.println("평균은: " + average);
    }
}
