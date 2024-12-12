import java.util.Arrays;

public class audit_3 {

    public static void main(String[] args) {

        int[] array = {5, 2, 9, 1, 5, 6};
        int[] sortedArray1 = {1, 3, 5};
        int[] sortedArray2 = {2, 4, 6};


        System.out.println("Array is sorted: " + isSorted(array));


        insertionSort(array);
        System.out.println("Insertion Sort: " + Arrays.toString(array));


        int[] merged = mergeSortedArrays(sortedArray1, sortedArray2);
        System.out.println("Merged Array: " + Arrays.toString(merged));


        int[] unsortedArray = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(unsortedArray);
        System.out.println("Merge Sort: " + Arrays.toString(unsortedArray));


        int index = binarySearch(merged, 4);
        System.out.println("Binary Search: " + (index >= 0 ? "Found at index " + index : "Not found"));


        Arrays.sort(array);
        System.out.println("Arrays.sort: " + Arrays.toString(array));
        System.out.println("Binary Search (Arrays.binarySearch): " + Arrays.binarySearch(merged, 4));
    }

    public static boolean isSorted(int[] array) {
        boolean ascending = true;
        boolean descending = true;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) ascending = false;
            if (array[i] > array[i - 1]) descending = false;
        }

        return ascending || descending;
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static int[] mergeSortedArrays(int[] array1, int[] array2) {
        int[] merged = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                merged[k++] = array1[i++];
            } else {
                merged[k++] = array2[j++];
            }
        }

        while (i < array1.length) merged[k++] = array1[i++];
        while (j < array2.length) merged[k++] = array2[j++];

        return merged;
    }

    public static void mergeSort(int[] array) {
        if (array.length < 2) return;

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        mergeSort(left);
        mergeSort(right);

        int[] merged = mergeSortedArrays(left, right);
        System.arraycopy(merged, 0, array, 0, array.length);
    }

    public static int binarySearch(int[] array, int key) {
        int left = 0, right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == key) return mid;
            if (array[mid] < key) left = mid + 1;
            else right = mid - 1;
        }

        return -1; // элемент не найден
    }
}
