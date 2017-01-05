// Bubble + partition + recursive
public class QuickSort {

    /**
     * partition 
     */
    public static int partition(int[] arr, int left, int right) {
        int pivotKey = arr[left];

        while(left < right) {
            while(left < right && arr[right] >= pivotKey)
                right --;
            arr[left] = arr[right]; //move small to left
            while(left < right && arr[left] <= pivotKey)
                left ++;
            arr[right] = arr[left]; //move big to right
        }
        arr[left] = pivotKey; //put pivot to middle
        return left;
    }

    /**
     * Recursive sort
     */
    public static void quickSort(int[] arr, int left, int right) {
        if(left >= right)
            return ;
        int pivotPos = partition(arr, left, right);
        quickSort(arr, left, pivotPos-1);
        quickSort(arr, pivotPos+1, right);
    }

    public static void sort(int[] arr) {
        if(arr == null || arr.length == 0)
            return ;
        quickSort(arr, 0, arr.length-1);
    }

}