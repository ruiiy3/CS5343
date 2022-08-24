import java.util.Arrays;

public class FloydHeap {

    public static void buildHeap(int[] arr) {
        int len = arr[0];
        int mid = len / 2;
        for(int i = mid; i > 0; i--)
            min_heapify(arr, i, len);
    }
    public static void min_heapify(int[] arr, int i, int n) {
        int left = 2*i ;
        int right = 2*i + 1;
        int min = i;
        if(left <= n && arr[left] < arr[i])
            min = left;

        if(right <= n && arr[right] < arr[min])
            min = right;

        if(min != i) {
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
            min_heapify(arr, min, n);
        }
    }
    public static void heapSort(int[] arr) {
        //buildHeap(arr);

        for(int i = arr[0]; i > 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[1];
            arr[1] = tmp;

            min_heapify(arr,   1, i-1 );
        }
    }

    public static void main(String[] args) {
        //arr[0] is the array length
        int[] arr = {15, 15, 20,5, 21,6,1,4,10,2,9,7,14,19,13, 8};
        System.out.println("Input array is:");
        System.out.println(Arrays.toString(arr));

        buildHeap(arr);
        System.out.println("\nAfter building the heap is:");
        System.out.println(Arrays.toString(arr));

        heapSort(arr);
        System.out.println("\nAfter sorting is:");
        System.out.println(Arrays.toString(arr));
    }
}