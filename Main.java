import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String kind = sc.nextLine();
            System.out.println(kind);
            if (kind.equals("e")) {
                Essay es = new Essay(sc);
                es.readQuestion();
            } else if (kind.equals("m")) {
                MultChoice mu = new MultChoice();
                mu.addAnswer(sc);
                mu.readQuestion();
            }
        }
        sc.close();
    }
}


abstract class TestQuestion {
    protected String question;

    protected abstract void readQuestion();
}

class Essay extends TestQuestion {
    private int line;

    public Essay(Scanner sc) {
        this.line = Integer.parseInt(sc.nextLine());
        this.question = sc.nextLine();
    }

    public String toString() {
        return line + "\n" + question;
    }

    @Override
    public void readQuestion() {
        System.out.println(this.toString());
    }
}

class MultChoice extends TestQuestion {
    private int answers;
    private String[] allanswer;

    public void addAnswer(Scanner sc) {
        this.answers = Integer.parseInt(sc.nextLine());
        allanswer = new String[answers];
        question = sc.nextLine();
        for (int i = 0; i < answers; i++) {
            allanswer[i] = sc.nextLine();
        }
    }

    public String toString() {
        return answers + "\n" + question;
    }

    @Override
    public void readQuestion() {
        System.out.println(this.toString());
        for (int i = 0; i < answers; i++) {
            if (i == answers - 1) System.out.print(allanswer[i]);
            else  System.out.println(allanswer[i]);
        }
    }
}