package PTIT.CONTEST006_Tien_nong;

public class Main {
    public static void main(String[] args) {
        Money a = new Money(10, 8);
        Money b = new Money(5, 5);
        Money c = a.plus(b);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        Money u = new Money(10, 0);
        Money y = new Money(3, 0);
        Money w = new Money(5, 0);
        System.out.println(u.lessThan(y));
        System.out.println(y.lessThan(w));

        Money m = new Money(10, 0);
        Money n = new Money(3, 50);
        Money o = m.minus(n);
        System.out.println(m);
        System.out.println(n);
        System.out.println(o);
        o = o.minus(m);
        System.out.println(o);
    }
}

class Money {
    private int euros;
    private int cents;
    public Money(int euros, int cents) {
        this.euros = euros;
        this.cents = cents;
    }

    public Money plus(Money added) {
        int carry = (int) Math.floor((this.cents + added.cents)*1.0 / 100);
        return new Money(this.euros + added.euros + carry, (this.cents + added.cents) % 100);
    }

    public boolean lessThan(Money compare) {
        return this.euros < compare.euros || (this.euros == compare.euros && this.cents < compare.cents);
    }

    public Money minus(Money minus) {
        int carry = 0;
        int carrycent = 0;
        if (this.cents < minus.cents) {
            carry = 1;
            carrycent = this.cents + 100;
        }
        return new Money(this.euros - minus.euros - carry, this.cents + carrycent - minus.cents);
    }

    @Override
    public String toString() {
        if (euros <= 0) return "0.00e";
        String tail = cents == 0  ? "00" : String.format("%02d", cents);
        return euros + "." + tail + "e";
    }
}