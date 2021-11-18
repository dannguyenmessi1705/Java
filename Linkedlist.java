import java.util.LinkedList;

class Linkedlist {
    public static void main(String[]args) {
        LinkedList<String> teams = new LinkedList<String>();
        teams.add("Barca");
        teams.add("Paris");
        teams.add("Bayern");
        teams.add("ManCity");
        System.out.println(teams);
        // thêm phần tử vào đầu list
        teams.addFirst("Chelsea");
        // thêm phần tử vào cuối list
        teams.addLast("Real");
        System.out.println(teams);
    }
}
