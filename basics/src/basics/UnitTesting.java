package basics;

import java.util.Scanner;
class GrandFather{
	String grandFatherName;
	GrandFather(String grandFatherName){
		this.grandFatherName=grandFatherName;
	}
}

class Father extends GrandFather{

	String fatherName;
	Father(String grandFatherName, String fatherName){
		super(grandFatherName);
		this.fatherName=fatherName;
	}
}
class Son extends Father{

	String sonName;

	Son( String grandFatherName, String fatherName, String sonName){
		super(grandFatherName, fatherName);
		this.sonName=sonName;
	}

	public void printName(){

		System.out.println("sonname: "+sonName);
		System.out.println("fathername:: "+fatherName);
		System.out.println("grandfather:: "+grandFatherName);
	}
}




class UnitTesting {

	public static void main(String args[]) {

		Son s=new Son("Suresh","Ramesh","Saurabh");
		s.printName();
	}
}


