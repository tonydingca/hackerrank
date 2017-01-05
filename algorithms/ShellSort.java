public class ShellSort {

    /**
     * One round of shell sort
     */
    public static void shellInsert(int[] arr, int d) {
        for(int i=d; i<arr.length; i++) {
            int j = i - d;
            int temp = arr[i];    //keep need insert item
            while (j>=0 && arr[j]>temp) {  //like Insert sort, from back to front, find smaller item
                arr[j+d] = arr[j];    //move big item;  
                j -= d;  
            }  

            if (j != i - d)    //have smaller,
                arr[j+d] = temp;

        }
    }

    public static void shellSort(int[] arr) {
        if(arr == null || arr.length == 0)
            return ;
        int d = arr.length / 2; // first distance value
        while(d >= 1) {
            shellInsert(arr, d);
            d /= 2;
        }
    }

}