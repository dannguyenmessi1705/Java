class NapChong{
    public static int sumOfArray(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }
    public static double sumOfArray(double[] arr){
        double sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }
    public static int maxOfArray(int[] arr){
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max) max=arr[i];
        }
        return max;
    }
    public static double maxOfArray(double[] arr){
        double max=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max) max=arr[i];
        }
        return max;
    }
    public static int minOfArray(int[] arr){
        int min=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min) min=arr[i];
        }
        return min;
    }
    public static double minOfArray(double[] arr){
        double min=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min) min=arr[i];
        }
        return min;
    }
    public static void main(String[]args) {
        int[] arr1=new int[] {1, 2, 3};
        double[] arr2=new double[] {3.4, 5.6, 7.8};
        System.out.println(NapChong.sumOfArray(arr1));
        System.out.println(NapChong.sumOfArray(arr2));
        System.out.println(NapChong.maxOfArray(arr1));
        System.out.println(NapChong.maxOfArray(arr2));
        System.out.println(NapChong.minOfArray(arr1));
        System.out.println(NapChong.minOfArray(arr2));
        
    }
}
