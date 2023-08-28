class Math1{
    public static final double PI=3.14;
    public static int abs(int x){
        return x<0?-x:x;
    }
    public static int add(int x, int y){
        return x+y;
    }
    public static int subtract(int x, int y){
        return x-y;
    }
    public static int min(int x, int y){
        return x<y?x:y;
    }
    public static int max(int x, int y){
        return x>y?x:y;
    }
    public static int pow(int x, int y){
        int gt=1;
        for(int i=0;i<y;i++) gt*=x;
        return gt;
    }
public static void main(String[]args) {
    System.out.println(Math1.PI);
    System.out.println(Math1.subtract(21, 7));
    System.out.println(Math1.add(21, 7));
    System.out.println(Math1.min(21, 7));
    System.out.println(Math1.max(21, 7));
    System.out.println(Math1.abs(-7));
    System.out.println(Math1.pow(3, 3));
}
}