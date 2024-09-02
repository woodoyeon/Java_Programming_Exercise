package JavaBasics_8_31;

public class star06 {
	
	public static void main(String[] args) {
	
		for(int i = 1; i <= 6; i++) {
			
			// 공백을 출력 (점점 증가)
			for(int j = 1; j < i; j++) {
				System.out.print(" ");
			}	
			
			// 별을 출력 (점점 감소, 2 * (6 - i) + 1)
			for(int k = 1; k <= (2 * (6 - i) + 1); k++) {
				System.out.print("*");
			}
			
			System.out.println();  // 줄바꿈
		}
	}
}
