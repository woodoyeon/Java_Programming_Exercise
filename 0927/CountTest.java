package 이혜정교수님과제;

public class CountTest {

	public static void main(String[] args) {
		// 일반적인 배열 선언
		Countable[] elements = { new Bird("비둘기", 4), new Bird("매", 3), new Tree("자작나무", 8), new Tree("소나무", 6) };

		// Countable 배열을 순회하면서 count 메서드 호출
		for (Countable element : elements) {
			element.count();
		}

		// 요소 타입에 따라 적절한 메서드 호출
		for (Countable element : elements) {
			if (element instanceof Bird) {
				((Bird) element).fly();
			} else if (element instanceof Tree) {
				((Tree) element).bearFruit();
			}
		}
	}
}
