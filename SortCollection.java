public class SortCollection {
    public static void main(String[] args) {
        A a1 = new A(1, 2);
        A a2 = new A(1, 3);
        System.out.println(a1.compareTo(a2));
    }
}

class A implements Comparable<A> {
    int x, y;
    public A(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean compareTo(A o) {
        if (this.x == o.x) {
            return this.y - o.y;
        } else {
            return this.x - o.x;
        }
    }
}
