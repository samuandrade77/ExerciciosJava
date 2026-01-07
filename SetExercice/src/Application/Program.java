package Application;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		Set<Integer> setA = new HashSet<>();
		Set<Integer> setB = new HashSet<>();
		Set<Integer> setC = new HashSet<>();
		
		System.out.print("How many students for course A?");
		int courseA = sc.nextInt();
		
		for(int i=0; i<courseA; i++) {
			setA.add(sc.nextInt());
		}
		
		System.out.print("How many students for course B?");
		int courseB = sc.nextInt();
		
		for(int i=0; i<courseB; i++) {
			setB.add(sc.nextInt());
		}

		System.out.print("How many students for course C?");
		int courseC = sc.nextInt();
		
		for(int i=0; i<courseC; i++) {
			setC.add(sc.nextInt());
		}
		
		setB.addAll(setC);
		setA.addAll(setB);
		
		System.out.println("Total students: " + setA.size());
		
		sc.close();
	}

}
