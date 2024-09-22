package 객체지향프로그래밍2;

public class Ball extends Circle {

    public Ball(double radius) {
        super(radius);
    }

    @Override
    public double getArea() {
        return 4 * PI * radius * radius;  // 구의 표면적 공식
    }
}
