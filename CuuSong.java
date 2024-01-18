import java.util.Date;
import java.util.Scanner;

public class CuuSong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int power = Integer.parseInt(sc.nextLine().substring(8));
        int blood = Integer.parseInt(sc.nextLine().substring(8));
        String tmp = sc.nextLine();
        boolean alive = false;
        if(tmp.equals("ALIVE")) alive = true;
        NhanVat nv = new NhanVat(power, blood, alive);
        int suKien = sc.nextInt(); sc.nextLine();
        for(int i = 0; i < suKien; i++){
            String s = sc.nextLine();
            if(s.equals("pea")){
                nv.pea();
            }
            else if(s.equals("mushroom")){
                nv.mushroom();
            }
            else if(s.charAt(0) == 's'){
                int power1 = Integer.parseInt(s.substring(8));
                nv.soldier(power1);
            }
            else{
                int power1 = Integer.parseInt(s.substring(6));
                nv.witch(power1);
            }
            System.out.print(nv);
        }
    }
}


class NhanVat {

    private int power, blood;
    private boolean alive;

    public NhanVat(int power, int blood, boolean alive) {
        this.power = power;
        this.blood = blood;
        this.alive = alive;
    }

    public String toString() {
        String res = "";
        if (this.alive) {
            res = "ALIVE";
        } else {
            res = "DEAD";
        }
        return "POWER : " + this.power + "\nBLOOD : " + this.blood + "\n" + res + "\n--------------------\n";
    }

    public void mushroom() {
        if (this.alive) {
            this.power -= 2;
            this.blood -= 15;
            if (this.power <= 0 || this.blood <= 0) {
                this.power = 0;
                this.blood = 0;
                this.alive = false;
            }
        }
    }

    public void witch(int power) {
        if (this.alive) {
            if (power >= this.power) {
                this.power = 0;
                this.blood = 0;
                this.alive = false;
            } else {
                this.power += 5;
            }
        }
    }

    public void pea() {
        if (this.alive) {
            this.power += 2;
            this.blood += 10;
        }
    }

    public void soldier(int power) {
        if (this.alive) {
            if (power >= this.power) {
                this.power = 0;
                this.blood = 0;
                this.alive = false;
            } else {
                this.power += 7;
                this.blood += 5;
            }
        }
    }
}
