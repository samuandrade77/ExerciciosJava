package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>(); 
		
		
		list.add("Samuel");
		list.add("Larissa");
		list.add("Ana");
		list.add("Alex");
		list.add("Rogério");
		
		list.add(2, "Lorena");
		
		for(String string : list) {
			System.out.println(string);	
		}
		
		System.out.println("------------------------");
		
		list.remove(3);
		list.removeIf(name -> name.charAt(0) == 'R');
		
		for(String string : list) {
			System.out.println(string);	
		}
		
		System.out.println("------------------------");
		
		System.out.println("Index of Larissa: " + list.indexOf("Larissa"));
		
		System.out.println("------------------------");
		
		List<String> result = list.stream().filter(name -> name.charAt(0) == 'L').collect(Collectors.toList());
		
		for(String string : result) {
			System.out.println(string);	
		}
		
		System.out.println("------------------------");
		
		String nameL = list.stream().filter(name -> name.charAt(0) == 'L').findFirst().orElse(null);
		System.out.println(nameL);
	}
}
