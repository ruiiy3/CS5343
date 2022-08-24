public class Main {
    public static int tertnarySearch(int arr[], int key, int start, int end){
        if(start > end)
            return -1;
        int mid1 = start + (end - start) / 3;
        int mid2 = end - (end - start) / 3;

        if(key == arr[mid1])
            return mid1;
        if(key == arr[mid2])
            return mid2;

        if(key < arr[mid1])
            return tertnarySearch(arr, key, start, mid1 - 1);
        else if(key >= arr[mid1] && key <= arr[mid2])
            return tertnarySearch(arr, key, mid1 + 1, mid2 - 1);
        else
            return tertnarySearch(arr, key, mid2 + 1, end);
    }
    public static void main(String[] args) {
	// write your code here
        int[] test = {20,21,24,33,44,50,80,100};
        int start = 0;
        int end = test.length - 1;
        int searchKey1 = 1;
        int result = tertnarySearch(test, searchKey1, start, end);

        if(result == -1)
            System.out.println("SearchKey is " + searchKey1 + " the result is: " + result + ". Not in the array.");
        else
            System.out.println("SearchKey is " + searchKey1 + " the result is: " + result);
    }
}
