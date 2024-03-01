import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();  // Consume the newline character
        ArrayList<TaiKhoan> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            TaiKhoan tk = new TaiKhoan(i, sc.nextLine());
            list.add(tk);
        }
        int index = 1;
        while (true) {
            try {
                String s = sc.nextLine();
                String[] arr = s.split("\\s+");
                String x = "";
                for (int i = 3; i < arr.length; i++) {
                    x += arr[i] + " ";
                }
                if (arr[1].equals("Add")) {
                    DanhSach ds = new DanhSach(index, x, arr[2]);
                    index++;
                    list.get(Integer.parseInt(arr[0]) - 1).add_Ds(ds);
                } else {
                    list.get(Integer.parseInt(arr[0]) - 1).share(list.get(Integer.parseInt(arr[2]) - 1), list.get(Integer.parseInt(arr[0]) - 1).getGhichu().get(Integer.parseInt(arr[3])-1));
                }

            } catch (Exception e) {
                break;
            }

        }
        for (int i = 0; i < list.size(); i++) {
            String[] test = list.get(i).getName().split("\\d+"); // hanoi
            if (test.length !=1 ){
                System.out.println("invalid input");
            }
            else {
                System.out.println("Account:" + " " + list.get(i).getName());
                for (int j = 0; j < list.get(i).getGhichu().size(); j++) {
                    list.get(i).getGhichu().get(j).in();
                }
            }
        }

    }
}

class TaiKhoan {
    private String id, name;
    private ArrayList<DanhSach> ghichu;

    public TaiKhoan(int id, String name) {
        this.id = String.format("%03d", id);
        this.name = name;
        this.ghichu = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<DanhSach> getGhichu() {
        return ghichu;
    }

    public void add_Ds(DanhSach ds) {
        this.ghichu.add(ds);
    }

    public void share(TaiKhoan tk, DanhSach ds) {
        tk.add_Ds(ds);
    }
}

class DanhSach {
    private int id;
    private String noiDung, date;

    public DanhSach(int id, String noiDung, String date) {
        this.id = id;
        this.noiDung = noiDung;
        this.date = date;
    }

    public void chuanHoaNgay(String date) {
        String thang = date.substring(0, 3);
        String thangch ="";
        thangch = Character.toUpperCase(thang.charAt(0)) + thang.substring(1).toLowerCase();
        String ngay = date.substring(3, 5);  // Fix index
        String nam = date.substring(5, 7);  // Fix index
        System.out.print(ngay + " " + thangch + " " + nam + " ");

    }

    public void in() {
        if (this.date.length()!=7){
            System.out.println("invalid input");
        }
        else {
            this.chuanHoaNgay(this.date);
            System.out.println("|" + " " + this.noiDung);
        }
    }
}