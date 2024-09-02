package JavaBasics_8_31;

public class star04 {
	
	public static void main(String[] args) {
	
		for(int i = 1; i <= 6; i++) {
			
			for(int j = 1; j < i ; j++) {  // 공백을 출력
				System.out.print(" ");
			}	
			for(int k = 6; k >= i; k--) {  // 별을 출력 (k를 감소시켜야 합니다)
				System.out.print("*");
			}
			
			System.out.println();  // 줄바꿈
			
		}
		
	}

}
