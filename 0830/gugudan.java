package JavaBasics_8_31;

public class gugudan {

	public static void main(String[] args) {
	
	
		
	    for(int i = 2; i <= 9; i++) {        
	    	printDan(i);
	    	 
            
	    	for(int j = 1; j <= 9; j++) {    
               print(i, j); 
            }
           
        }

    }

	
	public static void print(int i, int j ) {
	
		System.out.println(i + " x " + j + " = " + (i * j));
		
}
	
	public static void printDan(int i) {
		System.out.println();          
		System.out.println( "[구구단"+i+"단]");
	}
}