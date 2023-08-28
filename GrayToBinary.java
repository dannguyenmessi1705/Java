import java.util.Scanner;
public class GrayToBinary {
    // Function to convert a Gray code string to a binary string
    public static String grayToBinary(String gray) {
        // Convert the first bit of Gray code to binary
        String binary = "" + gray.charAt(0);
 
        // Loop through the remaining bits and calculate the
        // corresponding binary bits using XOR operation
        for (int i = 1; i < gray.length(); i++) {
            if (binary.charAt(i - 1) == gray.charAt(i))
                binary += "0";
            else
                binary += "1";
        }
        return binary;
    }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int test = Integer.parseInt(sc.nextLine());
      while (test > 0) {
         String gray = sc.next();
         String binary = grayToBinary(gray);
         System.out.println(binary);
         --test;
      }
      sc.close();
   }
}
