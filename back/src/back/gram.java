package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class gram {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int put = 0;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        		
        String input1 = br.readLine();
        String input2 = br.readLine();
        
        for(int i = 0; i<input1.length();i++) {
        	count1[(int)input1.charAt(i)-97] += 1;
        }
        
        for(int i = 0; i<input2.length();i++) {
        	count2[(int)input2.charAt(i)-97] += 1;
        }

		if(count1 == count2) {
	        System.out.println(put);
		}
		else {
			for(int j=0;j<26;j++) {
				if(count1[j] != count2[j]) {
					put += Math.abs(count1[j] - count2[j]);
				}
			}
			System.out.println(put);
		}
        
	}

}
