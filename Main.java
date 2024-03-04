public class Main {
    public static void swap(int[] a){
        int temp = a[0];
        a[0] = a[1];
        a[1] = temp;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int [] arr = new int[]{a, b};
        swap(arr);
        a = arr[0];
        b = arr[1];
        System.out.println(a + " " + b);
    }
}