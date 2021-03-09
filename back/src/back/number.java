package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class number {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		
        int input1 = Integer.parseInt(br.readLine());
        int input2 = Integer.parseInt(br.readLine());
        int input3 = Integer.parseInt(br.readLine());
        
        int mul = input1 * input2 * input3;
        String limit = Integer.toString(mul);
        
        
        int[] count = new int[10];
        		
        
        for(int i = 0; i<limit.length();i++) {

        	int temp = limit.charAt(i)-'0';
        	count[temp] += 1;	
        }

			
        for(int i = 0; i<count.length;i++) {
        	sb.append(count[i]);
        	sb.append("\n");
        }
        
        System.out.println(sb);
		
		
	}

}
