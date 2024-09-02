package JavaBasics_8_31;

public class star05 {

	public static void main(String[] args) {
		
		for(int i = 1; i <= 6; i++) {
			for(int j = 6; j > i ; j--) {
				System.out.print(" ");
			}	
			for(int k = 1; k <= (2 * i - 1); k++) {
					System.out.print("*");
				}
				System.out.println();
		}
		
	}


	}


