package PTIT.LAB02_StaticClass_Static_Account_Class;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static class Account {
        private String id;
        private String name;
        private long balance;

        public Account(){}
        public Account(String id, String name, long balance){
            this.id = id;
            this.name = name;
            this.balance = balance;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getBalance() {
            return balance;
        }

        public void setBalance(long balance) {
            this.balance = balance;
        }

        public void nap(long amount){
            if (amount < 0) return;
            this.balance += amount;
        }
        public void rut(long amount){
            if (amount > this.balance || amount < 0) return;
            this.balance -= amount;
        }
        public void chuyen(Account account, long amount){
            if (this.balance < amount || amount < 0) return;
            this.rut(amount);
            account.nap(amount);
        }

        @Override
        public String toString() {
            return "[" + id + ", " + name + ", " + balance + "]";
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0){
            int n = sc.nextInt();
            List<Main.Account> accounts = new ArrayList<>();
            String accountList = sc.nextLine();
            String[] balanceArr = accountList.split("\\D+");
            String[] accountArr = accountList.split("\\d+");
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                Main.Account account = new Main.Account(String.format("%03d", i+1), accountArr[i].trim(), Long.parseLong(balanceArr[i+1].trim()));
                accounts.add(account);
            }
            int number = sc.nextInt();
            String taskList = sc.nextLine().trim();
            String[] taskArr = taskList.split("\\s+");
            int count = 0;
            for (int i = 0; i < taskArr.length;) {
                if (count == number) break;
                count++;
                if (taskArr[i].equals("nap")) {
                    for (Main.Account account : accounts) {
                        if (Integer.parseInt(account.getId()) == Integer.parseInt(taskArr[i + 1])) {
                            account.nap(Long.parseLong(taskArr[i + 2]));
                            break;
                        }
                    }
                    i = i + 3;
                } else if (taskArr[i].equals("rut")) {
                    for (Main.Account account : accounts) {
                        if (Integer.parseInt(account.getId()) == Integer.parseInt(taskArr[i + 1])) {
                            account.rut(Long.parseLong(taskArr[i + 2]));
                            break;
                        }
                    }
                    i = i + 3;
                } else if (taskArr[i].equals("chuyen")) {
                    for (Main.Account account : accounts) {
                        if (Integer.parseInt(account.getId()) == Integer.parseInt(taskArr[i + 1])) {
                            for (Main.Account account1 : accounts) {
                                if (Integer.parseInt(account1.getId()) == Integer.parseInt(taskArr[i + 2])) {
                                    account.chuyen(account1, Long.parseLong(taskArr[i + 3]));
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    i = i + 4;
                } else {
                    i++;
                    count--;
                }
            }
            for (Main.Account account : accounts) {
                System.out.print(account);
            }
            System.out.println();
        }
    }
}