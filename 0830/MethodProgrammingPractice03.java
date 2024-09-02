package JavaBasics_8_31;

import java.util.Scanner;

public class MethodProgrammingPractice03 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("배열의 크기를 입력하세요: ");
        int num = sc.nextInt();
        int[] arr = new int[num];
        
        System.out.println("배열에 숫자를 저장하세요: ");
        for(int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        
        int max = getMax(arr);
        
        System.out.println("배열에서 가장 큰 숫자는: " + max);
    }
    
    public static int getMax(int[] arr) {
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
