import java.util.HashMap;
class HashMapString{
  public static void main(String[]args) {
    HashMap<String,String> capital = new HashMap<String,String>();
    // thêm từ khóa và biến
    capital.put("England", "London");
    capital.put("France", "Paris");
    capital.put("USA", "Washington D.C");
    capital.put("Vietnam", "Hanoi");
    System.out.println(capital);    
    // truy cập vào 1 phần tử
    System.out.println(capital.get("England"));
    // In từ khóa
    for(String i : capital.keySet()){
      System.out.println(i);
    }
    // In biến 
    for(String i : capital.values()){
      System.out.println(i);
    }
    // In từ khóa và biến theo vòng lặp
    for(String i : capital.keySet()){
      System.out.println("key: " + i + "\tvalue: " + capital.get(i));
    }
  }
}