package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class gasu {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		String input2 = br.readLine();
		String[] arr = input2.split(" ");
		
		String input3 = br.readLine();
		
		int count = 0;
		
		for(int i = 0; i<arr.length;i++) {
			String a = arr[i];
			
			if(a.equals(input3)) {
				count++;
			}
		}
		
		System.out.println(count);
		
		
	}

}
