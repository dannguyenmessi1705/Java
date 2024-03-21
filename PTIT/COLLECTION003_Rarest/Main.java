package PTIT.COLLECTION003_Rarest;

import java.util.*;

public class Main {
    public int rarest(Map<String, Integer> map) {
        Map<Integer, Integer> age = new HashMap<>();
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet){
            if (age.containsKey(entry.getValue())){
                int loop = age.get(entry.getValue());
                age.put(entry.getValue(), loop+1);
            } else {
                age.put(entry.getValue(), 1);
            }
        }
        List<Map.Entry<Integer, Integer>> entrySet1 = new ArrayList<>(age.entrySet());
        entrySet1.sort(Map.Entry.comparingByValue());
        return entrySet1.getFirst().getKey();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0){
            Main m = new Main();
            Map<String, Integer> map = new HashMap<>();
            String[] arr = sc.nextLine().split(" ");
            for (int i = 0; i < arr.length - 1; i+=2){
                map.put(arr[i], Integer.parseInt(arr[i+1]));
            }
            System.out.println(m.rarest(map));
        }
    }
}
