package 이혜정교수님과제;

public class Tree implements Countable {

	private String name;
	private int count;

	public Tree(String name, int count) {
		this.name = name;
		this.count = count;
	}

	@Override
	public void count() {
		System.out.printf("%s가 %d그루 있습니다.\n", name, count);
	}

	public void bearFruit() {
		System.out.printf("%d그루의 %s에 열매가 잘 익었습니다.\n", count, name);
	}

	// Getter 및 Setter 메서드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
