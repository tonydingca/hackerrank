public class InsertSort {

    public static void insertSort(int[] arr) {
        if(arr == null || arr.length == 0)
            return ;

		// keep arr[0] as correct order as initial
        for(int i=1; i<arr.length; i++) { 

            int j = i;
            int target = arr[i]; // need insert item

            // reverse found bigger than target, move back
            while(j > 0 && target < arr[j-1]) {
                arr[j] = arr[j-1];
                j --;
            }

            // new place to insert the target item
            arr[j] = target;
        }

    }

}