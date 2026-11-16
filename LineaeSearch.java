public class LineaeSearch {
    static int linearSearch(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {12, 23, 45, 67, 89};
        int key = 45;
        int index = linearSearch(arr, key);

        System.out.println("Index of " + key + ": " + index);
    }
}