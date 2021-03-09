package back;
import java.util.*;
public class strgty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in); 
		int input = sc.nextInt(); 
		for (int i=0; i<input; i++){ 
			int[] alpa = new int[26]; 
			char[] words1 = sc.next().toCharArray(); 
			char[] words2 = sc.next().toCharArray(); 
			for (char ch : words1) alpa[ch-97]++; 
			for (char ch : words2) alpa[ch-97]--; 
			boolean flag = true; 
			for (int j : alpa) 
				if(j!=0) flag = false; 
			System.out.println(flag ? "Possible" : "Impossible");
		}


		
	}

}
