package 이혜정교수님과제;

public class SoundableExample {

	// Static 메서드로 sound를 출력합니다.
	public static void displaySound(Soundable sound) {
		// 전달된 sound의 sound() 메서드를 실행합니다.
		System.out.println(sound.sound());
	}

	public static void main(String[] args) {
		// Cat 및 Dog 객체 생성 후 displaySound 호출
		displaySound(new Cat());
		displaySound(new Dog());
	}
}
