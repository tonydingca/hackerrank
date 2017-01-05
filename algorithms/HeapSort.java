public class HeapSort {

    /**
	*	need big heap 
     */
    public static void heapAdjust(int[] arr, int start, int end) {
        int temp = arr[start];

        for(int i=2*start+1; i<=end; i*=2) {
            //left = 2*i+1, right = 2*i+2

            //choose smaller from left and right
            if(i < end && arr[i] < arr[i+1]) {
                i ++; 
            }
            if(temp >= arr[i]) {
                break; //already big heap
            }
            arr[start] = arr[i]; //move child up
            start = i; //next round
        }

        arr[start] = temp; //put in correct position
    }

    public static void heapSort(int[] arr) {
        if(arr == null || arr.length == 0)
            return ;

        //build big heap 
        for(int i=arr.length/2; i>=0; i--) {
            heapAdjust(arr, i, arr.length-1);
        }

        for(int i=arr.length-1; i>=0; i--) {
            swap(arr, 0, i);
            heapAdjust(arr, 0, i-1);
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}