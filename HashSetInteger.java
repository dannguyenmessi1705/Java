// HashSet dùng để in ra các phần tử đúng 1 lần, cho dù các phần tử đó lặp lại nhiều trong list 
import java.util.HashSet;
class HashSetInteger {
    public static void main(String[] args) {
        HashSet<Integer> number = new HashSet<Integer>();
        number.add(3);
        number.add(5);
        number.add(7);
        number.add(7);
        number.add(9);
        System.out.println(number);
        System.out.println(number.size()); // chỉ có 4 phần tử do có 2 phần tử 7 bằng nhau
        for(int i=1; i<10; i++){
            if(number.contains(i)) // nếu tồn tại phần tử i trong list
            {
                System.out.println("Phan tu "+i+" co ton tai");
            }
            else System.out.println("Phan tu "+i+" khong ton tai");
        }
    }    
}
