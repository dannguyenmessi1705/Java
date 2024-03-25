package PTIT.INHERITANCE007_Test_Questions;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        List<String> output = new ArrayList<>();
        System.out.println(test);
        while (test-- > 0){
            String testType = sc.nextLine();
            if (testType.equals("m")) {
                MultChoice m = new MultChoice();
                m.readQuestion(sc);
                output.add(m.toString());
            } else if (testType.equals("e")) {
                Essay e = new Essay();
                e.readQuestion(sc);
                output.add(e.toString());
            }
        }
        for (String s : output) {
            System.out.println(s);
        }
    }
}

abstract class TestQuestion {
    protected String question;
    protected abstract void readQuestion(Scanner sc);
}

class Essay extends TestQuestion {
    private int lineAnswer;
    @Override
    protected void readQuestion(Scanner sc){
        this.lineAnswer = Integer.parseInt(sc.nextLine());
        question = sc.nextLine();
    }
    @Override
    public String toString(){
        return String.format("e\n%d\n%s", lineAnswer, question);
    }
}

class MultChoice extends TestQuestion {
    private List<String> choices = new ArrayList<>();
    private int choiceAnswer;
    @Override
    protected void readQuestion(Scanner sc){
        choiceAnswer = Integer.parseInt(sc.nextLine());
        question = sc.nextLine();
        for (int i = 0; i < choiceAnswer; i++) {
            this.choices.add(sc.nextLine());
        }
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("m\n");
        sb.append(choiceAnswer).append("\n");
        sb.append(question).append("\n");
        for (String choice : choices) {
            sb.append(choice).append(choice.equals(choices.get(choices.size()-1)) ? "" : "\n");
        }
        return sb.toString();
    }
}
