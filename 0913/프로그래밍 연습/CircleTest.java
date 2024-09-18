package 자바응용실습_이혜정교수님;

import java.util.Scanner;

class Circle {
    // 정적 상수로 원주율 선언
    public static final double PI = 3.14159;

    // 반지름을 저장할 변수
    private double radius;

    // 생성자: 반지름을 초기화
    public Circle(double radius) {
        this.radius = radius;
    }

    // 원의 넓이를 구하는 메서드
    public double getArea() {
        return PI * radius * radius;
    }

    // 반지름을 반환하는 getter
    public double getRadius() {
        return radius;
    }

    // 반지름을 설정하는 setter
    public void setRadius(double radius) {
        this.radius = radius;
    }
}

public class CircleTest {
    public static void main(String[] args) {
        // 사용자로부터 반지름 입력 받기
        Scanner sc = new Scanner(System.in);
        System.out.print("원의 반지름을 입력하세요: ");
        double radius = sc.nextDouble();

        // Circle 객체 생성 및 넓이 계산
        Circle circle = new Circle(radius);
        double area = circle.getArea();

        // 결과 출력
        System.out.printf("반지름이 %.1f인 원의 넓이는 %.2f입니다.%n", circle.getRadius(), area);
    }
}
