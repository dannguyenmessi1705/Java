import java.util.*;
import java.io.*;
import java.text.*;
public class Main {
    public static void main(String[] $) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0) {
            List<String> s = new ArrayList<>(Arrays.asList(sc.nextLine().split("\\s+")));
            Map<Integer, String> m = new HashMap<>();
            s.stream().forEach(t -> {
                m.put(t.length(), t);
            });
            List<Map.Entry<Integer, String>> l = new ArrayList<>(m.entrySet());
            l.sort(Map.Entry.comparingByKey());
            System.out.println(l.get(l.size()-1).getValue());
        }
    }
}
