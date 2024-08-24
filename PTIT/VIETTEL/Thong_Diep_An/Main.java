package PTIT.VIETTEL.Thong_Diep_An;

import java.util.Scanner;

public class Main {
  public static int calculateSlogan(String x, String s) {
    int result = 0;
    int idx_x = 0, idx_s = 0, len_x = x.length(), len_s = s.length();
    while (idx_s < len_s) {
      if (! (x.charAt(idx_x) == s.charAt(idx_s))) {
        idx_s++;
      } else {
        idx_x++;
        idx_s++;
        if (idx_x == len_x) {
          result++;
          idx_x = 0;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(calculateSlogan(sc.nextLine(), sc.nextLine()));
    sc.close();
  }
}

/*
Đến ngày truyền thống, bộ phận truyền thông tổ chức một trò chơi "Tìm kiếm thông điệp ẩn". Trò chơi như sau: Bộ phận truyền thông đưa ra thông điệp và 1 xâu ký tự. Thông điệp có thể được ẩn trong xâu ký tự theo quy luật: các chữ cái của thông điệp có thể không đứng liền nhau trong xâu ký tự nhưng thứ tự vẫn phải đảm bảo.
Nhiệm vụ của bạn là tìm số thông điệp ẩn trong xâu ký tự.
Ví dụ nếu thông điệp là VIETTEL Và xâu ký tự là AUNGKVEVKHIASEGHTKQTLEOLPDNVBIREKHTBNTOELGTNLETTEIV
=> Ta có thể tìm ra 2 thông điệp VIETTEL được ẩn trong xâu ký tự.
(AUNGK V EVKH I AS E GH T KQ T L E O L PDN V B I R E KH T BN T O E L GTNLETTEIV)
Input Format
Dòng đầu: String X - một xâu ký tự thông điệp
Dòng hai: String S - thể hiện xâu ký tự sử dụng để tìm ra thông điệp
Constraints
Các xâu ký tự chỉ gồm các chữ cái in hoa A-Z
Độ dài X <= 10^3
Độ dài S <= 10^6
Output Format
Integer result: Một số duy nhất là số khẩu hiệu cắt ra được
 */