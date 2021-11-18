import java.util.HashMap;

class HashMapInteger {
    public static void main(String[] args) {
        HashMap<String, Integer> people = new HashMap<String, Integer>();
        people.put("Dan", 19);
        people.put("Thang", 17);
        people.put("Huong", 21);
        people.put("Thai", 20);
        for(String i : people.keySet()){
            System.out.println("tên: " + i + " tuổi: " + people.get(i));
        }    
    }    
}
