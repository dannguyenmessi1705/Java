import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0) {
            String[] s = sc.nextLine().split("\\s+");
            Map<String, String> m = new LinkedHashMap<>();
            for (int i = 0; i < s.length; i += 2) {
                m.put(s[i], i + 1 >= s.length ? "" : s[i + 1]);
            }
            List<String> c = new ArrayList<>();
            for (Map.Entry<String, String> entry : m.entrySet()) {
                if (entry.getKey().length() > entry.getValue().length()) {
                    c.add(entry.getKey());
                } else
                    c.add(entry.getValue());
            }
            c.forEach(res -> {
                System.out.print(res + (c.get(c.size() - 1).equals(res) ? "\n" : " "));
            });
        }
    }

}
