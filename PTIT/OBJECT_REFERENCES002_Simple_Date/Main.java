package PTIT.OBJECT_REFERENCES002_Simple_Date;

public class Main {
    public static void main(String[] args) {
        SimpleDate d = new SimpleDate(1, 2, 2000);
        System.out.println(d.equals("heh"));
        System.out.println(d.equals(new SimpleDate(5, 2, 2012)));
        System.out.println(d.equals(new SimpleDate(1, 2, 2000)));
    }
}

class SimpleDate {
    private int day;
    private int month;
    private int year;

    public SimpleDate() {
    }


    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof SimpleDate)) {
            return false;
        }
        SimpleDate simpleDate = (SimpleDate) obj;
        if (simpleDate.day == this.day && simpleDate.month == this.month && simpleDate.year == this.year) {
            return true;
        }
        return false;
    }
}
