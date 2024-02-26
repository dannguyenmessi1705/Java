package PTIT.ELAB2315_Note_Class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);
            int n = Integer.parseInt(sc.nextLine());
            ArrayList<Account> accounts = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String name = sc.nextLine();
                Account account = new Account(String.format("%03d", i + 1), name, new ArrayList<>());
                accounts.add(account);
            }
            while (true) {
                try {
                    String command = sc.nextLine();
                    String[] arr = command.split("\\s+");
                    if (arr[1].equals("Add")){
                        String content = String.join(" ",Arrays.copyOfRange(arr, 3, arr.length));
                        for (Account account : accounts) {
                            if (account.getId().equals(arr[0])) {
                                account.addNote(new Note(account.getNotes().size()+1, arr[2], content));
                            }
                        }
                        continue;
                    }else if (arr[1].equals("Share")) {
                        for (Account account : accounts) {
                            if (account.getId().equals(arr[0])) {
                                ArrayList<Note> notes = account.getNotes();
                                Note note = notes.get(Integer.parseInt(arr[3]) - 1);
                                for (Account accountShared : accounts) {
                                    if (accountShared.getId().equals(arr[2])) {
                                        accountShared.addNote(new Note(accountShared.getNotes().size()+1, note.getDate(), note.getContent()));
                                    }
                                }
                            }
                        }
                        continue;
                    } else {
                        throw new Exception("invalid input");
                    }

                } catch (Exception e) {
                    if (e.getMessage().equals("invalid input")){
                        throw new Exception("invalid input");
                    }
                    break;
                }
            }
            for(Account account : accounts){
                System.out.print(account);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}

class Account {
    private String id, name;
    private ArrayList<Note> notes;

    public Account(String id, String name, ArrayList<Note> notes) throws Exception {
        String regex = ".*\\d.*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        if (matcher.matches()){
            throw new Exception("invalid input");
        }
        this.id = id;
        this.name = name;
        this.notes = notes;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public String getId() {
        return id;
    }
    @Override
    public String toString() {
        String accountName = String.format("Account: %s", name);
        StringBuilder noteList = new StringBuilder();
        for (Note note : notes) {
            noteList.append(note.convertDate()).append(" | ").append(note.getContent()).append("\n");
        }
        return String.format("%s\n%s", accountName, noteList);
    }
}

class Note {
    private int id;
    private String date, content;

    public Note() {
    }

    public Note(int id, String date, String content) throws Exception{
        if (date.length() != 7){
            throw new Exception("invalid input");
        }
        String month = date.substring(0, 3);
        if (! (month.equals("Jan") || month.equals("Feb") || month.equals("Mar") || month.equals("Apr") || month.equals("May") || month.equals("Jun") || month.equals("Jul") || month.equals("Aug") || month.equals("Sep") || month.equals("Oct") || month.equals("Nov") || month.equals("Dec"))){
            throw new Exception("invalid input");
        }
        String day = date.substring(3, 5);
        if (Integer.parseInt(day) < 1 || Integer.parseInt(day) > 31){
            throw new Exception("invalid input");
        }
        if (content.length() <1){
            throw new Exception("invalid input");
        }
        this.id = id;
        this.date = date;
        this.content = content;
    }
    public String getContent() {
        return content;
    }
    public String getDate() {
        return date;
    }
    public String convertDate() {
        String month = date.substring(0, 3);
        String day = date.substring(3, 5);
        String year = date.substring(5);
        return String.format("%s %s %s", day, month, year);
    }
}
