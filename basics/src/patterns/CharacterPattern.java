package patterns;

import java.util.Scanner;

public class CharacterPattern {

	public static void main(String[] args) {

		int n=3;

		for(int i=1;i<=n;i++) {

			for(int j=1;j<=n;j++) {
				char value=(char) (64+j);
				System.out.print(value);
			}
			System.out.println();
		}
		
		
		System.out.println("*****************");
		for(int i=1;i<=n;i++) {

			for(int j=1;j<=n;j++) {
				char value=(char) (64+i);
				System.out.print(value);
			}
			System.out.println();
		}
		
		System.out.println("*****************");
		for(int i=1;i<=n;i++) {
			char ith=(char) (65+i-1);
			for(int j=1;j<=n;j++) {
				
				System.out.print(ith);
				ith=(char) (ith+1);
			}
			System.out.println();
		}
		System.out.println("*****************");
		char ch='A';
		// int n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			
			for(int j=1;j<=n;j++) {
				System.out.print(ch);
				ch++;
			}

			System.out.println();
		}
		System.out.println("*****************");
		
		for (int i=1;i<=n;i++) {
			char ch2='A';
			ch2=(char) (ch2+n-i);
			for(int j=1;j<=i;j++) {
				System.out.print(ch2);
				ch2=(char) (ch2+1);
			}
			System.out.println();
		}
		
		
		System.out.println("*****************");
		
		
		for(int i=1;i<=n;i++) {
			char ch3=(char) ('A'+n-1);
			for(int j=1;j<i;j++) {
				
				System.out.print(ch3);
				ch3--;
				
			}
			System.out.println(ch);
		}
	}

}
