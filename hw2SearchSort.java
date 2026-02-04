public class hw2SearchSort {
    public static void main(String[] args) {
        int[] arr = {7, 900, 2, 45, 6, 1};
        System.out.println(findLargest(arr));
    }

    private static int findLargest(int[] arr) {
	int largest = arr[0];                      
	for (int i = 1; i < arr.length-1; i++) { 
		if (arr[i] > largest)                  
			largest = arr[i];                  
	}
	return largest;                            
}
}