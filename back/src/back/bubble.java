package back;

public class bubble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, j, temp;
		int array[] = {1,10,5,8,7,6,4,3,2,9};
		for(i = 0; i < 10; i++) {
			for(j = 0; j < 9 - i; j++) {
				if(array[j] > array[j+1]) {
					temp = array[j];
					array[j] = array[j+1];
					array[j + 1] = temp;
				}
			}
		}
		
		for(i = 0; i < 10; i++) {
			System.out.printf("%d ",array[i]);
		}
		
		
		return;

	}
 
}
// 버블정렬 O(N^2)
