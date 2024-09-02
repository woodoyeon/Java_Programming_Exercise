package JavaBasics_8_31;

public class star02_java {

public static void main(String[] args) {
		
	for(int i = 1; i <= 6; i++) {  // 외부 루프: 1부터 6까지 증가
	    for(int j = 6; j >= i; j--) {  // 내부 루프: 6부터 i까지 감소
	        System.out.print("*");
	    }
	    System.out.println();  // 각 줄을 출력한 후 줄바꿈
	}
}


}
