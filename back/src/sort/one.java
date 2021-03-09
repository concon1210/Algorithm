package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class one {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<Integer>();
		int n = Integer.parseInt(br.readLine());
		
		// 전체 n을 저장
		for(int i = 0; i < n;i++) {
			int m = Integer.parseInt(br.readLine());
			list.add(m);
    	}
		
		
    	Collections.sort(list);
    	for(int i:list) {
    		System.out.println(i);
    	}
    	
    	
		
	}


}
