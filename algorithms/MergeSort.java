public class MergeSort {

    public static void mergeSort(int[] arr) {
        mSort(arr, 0, arr.length-1);
    }

    /**
     * Recursive process
     */
    public static void mSort(int[] arr, int left, int right) {
        if(left >= right)
            return ;
        int mid = (left + right) / 2;

        mSort(arr, left, mid); //Recursive left part (left -> mid);
        mSort(arr, mid+1, right); //Recursive right part ( mid + 1 -> righgt)
        merge(arr, left, mid, right); //Merge
    }

    /**
     * Merge two ordered parts
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        //[left, mid] [mid+1, right]
        int[] temp = new int[right - left + 1]; // temperary array

        int i = left;
        int j = mid + 1;
        int k = 0;
		// when left array and right array both have value, put smaller to temp array
        while(i <= mid && j <= right) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }
            else {
                temp[k++] = arr[j++];
            }
        }

		// if left array still have value, just copy rest to temp array
        while(i <= mid) {
            temp[k++] = arr[i++];
        }
		// if right array still have value, just copy rest to temp array
        while(j <= right) {
            temp[k++] = arr[j++];
        }

		// Over write array for left + p
        for(int p=0; p<temp.length; p++) {
            arr[left + p] = temp[p];
        }

    }
}