package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		System.out.print("Enter the file path: ");
		File file = new File(sc.nextLine());
		
		Map<String, Integer> candidates = new HashMap<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String line = br.readLine();
			
			while(line!= null) {
				String[] fields = line.split(",");
				String name = fields[0];
				int votes = Integer.parseInt(fields[1]);
				
				if(candidates.containsKey(name)) {
					int votesSoFar = candidates.get(name);
					candidates.put(name, votesSoFar + votes);
				}
				
				else {
					candidates.put(name, votes);
				}
				
				line = br.readLine();
			}
			
			for(String key : candidates.keySet()) {
				System.out.println(key + ": " + candidates.get(key));
			}
		}
		
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		finally{
			sc.close();
		}
	}

}
