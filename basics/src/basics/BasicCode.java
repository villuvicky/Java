package basics;

public class BasicCode {

	public static void main( String[] args )// main method which has static , so it will run at initially without creating an object
	{
		
	int a=10; 
	// here a is reference variable and 10 is object. a is stored in stack memory, object is stored in heap
	
	int b=a;
	//here be also points to same object 10.
	
	a=5;
	//here 10 is moved to garbage collection as it is not used now.
	
	System.out.println( "Hello World!" );
	
	int [][] arr = new int[2][5];
	System.out.println(arr[0].length);

	}

}
