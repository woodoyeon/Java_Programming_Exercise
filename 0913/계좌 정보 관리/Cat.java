package 자바응용실습_이혜정교수님;

public class Cat {
	String feed; // 스택
	int age; // 스택
	
	void eat() { // 스태틱
		System.out.println("사료 " + feed + "를 먹었습니다.");
	}
}

class CatTest { 
	public static void main(String[] args) {
		Cat myCat = new Cat(); //힙
		myCat.feed = "힐스";  // 스택
		myCat.age = 10; // 스태틱(메서드)
		myCat.eat(); // 스태틱(메서드)
	}
}
