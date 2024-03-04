package PTIT.OBEJCT_REFERENCES001_Equals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0){
            Song song1 = new Song(sc.next(), sc.next(), sc.nextInt());
            sc.nextLine();
            Song song2 = new Song(sc.next(), sc.next(), sc.nextInt());
            if (song1.equals(song2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}

class Song {
    private String name;
    private String author;
    private int duration;

    public Song() {
    }

    public Song(String name, String author, int duration) {
        this.name = name;
        this.author = author;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object obj) {
        Song song = (Song) obj;
        if (song.name.equals(this.name) && song.author.equals(this.author) && song.duration == this.duration) {
            return true;
        }
        return false;
    }
}