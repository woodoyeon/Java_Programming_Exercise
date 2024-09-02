package JavaBasics_8_31;

import java.util.Scanner;

public class MethodProgrammingPractice04 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        int[] arrSize = new int[num];
        
        for(int i = 0; i < num; i++) {
            arrSize[i] = sc.nextInt();
        }
        
        int[] reversedArr = getReversedArray(arrSize);
        
        for(int i = 0; i < reversedArr.length; i++) {
            System.out.print(reversedArr[i] + " ");
        }
    }
    
    public static int[] getReversedArray(int[] arr) {
        int[] reversedArr = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            reversedArr[i] = arr[arr.length - 1 - i];
        }
        return reversedArr;
    }
}
