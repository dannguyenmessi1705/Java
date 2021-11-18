// Dùng Iterator để duyệt các phần tử trong mảng
import java.util.ArrayList;
import java.util.Iterator;

class IteratorInteger {
    public static void main(String[]args) {
        ArrayList<Integer> num = new ArrayList<Integer>();
        num.add(3);
        num.add(5);
        num.add(12);
        num.add(60);
        num.add(7);
        Iterator<Integer> it = num.iterator(); // Tạo 1 iterator
        System.out.println(it.next()); // In phần tử tiếp theo bắt đừ từ phần tử đầu tiên
        // Lúc này iterator đang ở vị trí thứ 0
        System.out.println(it.next()); // Lúc này it đang ở vị trí thứ 1
        // In tất cả các phần tử trong list
        while(it.hasNext()) // kiểm tra iterator có phần tử tiếp theo không
        {
            System.out.println(it.next()); // lúc này it đang ở vị trí thứ 2
        }
        Iterator<Integer> it1 = num.iterator();
        while(it1.hasNext()){
            if(it1.next()>10){
                it1.remove();
            }
        }
        System.out.println(num);
    }    
}
