import java.util.ArrayList;

class ArrayString {
    public static void main(String[] args) {
        // Khởi tạo mảng có thể thay đổi kích thước
        ArrayList<String> mycar = new ArrayList<String>();
        // Thêm vào mảng 
        mycar.add("BMW");
        mycar.add("Volvo");
        mycar.add("Chevrolet");
        mycar.add("Yokohama");
        System.out.println(mycar);
        // xóa thành phần thứ ba trong mảng
        mycar.remove(2);
        mycar.add("Ford");
        /* Xóa tất cả
        // mycar.clear();
        */
        // Truy xuất kích thước mảng
        System.out.println(mycar.size());
        // Đổi 1 thành phần thứ 4 
        mycar.set(3, "Honda");
        // Truy xuất các thành phần
        for(String i:mycar){
            System.out.println(i);
        }
        /* hoặc
        for(int i=0;i<mycar.size();i++){
            System.out.println(mycar.get(i));
        } 
        */
        
    }    
}
