package 자바응용실습_이혜정교수님;

class Cat {
    // 품종, 색, 나이 필드 선언
    private String breed;
    private String color;
    private int age;

    // 생성자: 품종, 색, 나이를 초기화
    public Cat(String breed, String color, int age) {
        this.breed = breed;
        this.color = color;
        this.age = age;
    }

    // 먹기 메서드 (매개변수로 시간을 받아 사료 먹는 상황 출력)
    public void eat(String time) {
        System.out.println(time + "에 사료를 먹습니다.");
    }

    // 야옹 메서드
    public void meow() {
        System.out.println("야옹~~~");
    }

    // 스크래치 메서드
    public void scratch() {
        System.out.println("스크래치를 긁습니다.");
    }

    // 고양이 정보 출력 메서드
    public void printInfo() {
        System.out.println("나의 고양이는 " + color + " " + breed + "입니다.");
    }

    // getter와 setter 추가 (필요 시 사용)
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class CatTest {
    public static void main(String[] args) {
        // Cat 객체 생성
        Cat myCat = new Cat("코숏", "노랑", 3);

        // 고양이 정보 출력
        myCat.printInfo();

        // 고양이의 일과 출력
        myCat.eat("아침");
        myCat.meow();
        myCat.eat("점심");
        myCat.scratch();
        myCat.meow();
    }
}
