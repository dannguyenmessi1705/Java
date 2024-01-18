import java.util.*;

public class EPL {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        List<Team> teams = new ArrayList<Team>();
        for(int i=0; i<20; i++){
            sc.nextLine();
            teams.add(new Team(sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
            sc.nextLine();
            sc.nextLine();
        }
        for(int i=0; i<10; i++){
            String tmp[] = sc.nextLine().split(" - ");
            String[] left = tmp[0].split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
            String teamA = left[0].trim();
            int goalA = Integer.parseInt(left[1].trim());
            String[] right = tmp[1].split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
            String teamB = right[1].trim();
            int goalB = Integer.parseInt(right[0].trim());
            Team home = new Team();
            Team away = new Team();
            for (Team t : teams){
                if(t.getNameClub().equals(teamA)){
                    home = t;
                }
                else if(t.getNameClub().equals(teamB)){
                    away = t;
                }
            }
            if(goalA - goalB > 0){
                home.win(goalA-goalB);
                away.lose((goalA-goalB));
            }
            else if(goalA - goalB < 0){
                home.lose(goalA - goalB);
                away.win((goalA - goalB));
            }
            else {
                home.draw(goalA - goalB);
                away.draw(goalA - goalB);
            }
        }
        Collections.sort(teams, Comparator.comparing(Team::getPoint).reversed().thenComparing(Team::getGA).reversed().thenComparing(Team::getNameId).reversed());
        int rankId = 1;
        for(Team t : teams){
            System.out.println("#"+rankId+" "+t);
            rankId++;
        }
    }
}

class Team {
    private String nameId;
    private String nameClub;
    private int totalMatch;
    private int point;
    private int GA;
    public Team(){}
    public Team(String nameId, String nameClub, int totalMatch, int GA, int point){
        this.nameId = nameId;
        this.nameClub = nameClub;
        this.totalMatch = totalMatch;
        this.point = point;
        this.GA = GA;
    }

    @Override
    public String toString(){
        return this.nameId +" "+this.nameClub+" "+this.totalMatch+" "+this.GA+" "+this.point;
    }
    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public String getNameClub() {
        return nameClub;
    }

    public void setNameClub(String nameClub) {
        this.nameClub = nameClub;
    }

    public int getTotalMatch() {
        return totalMatch;
    }

    public void setTotalMatch(int totalMatch) {
        this.totalMatch = totalMatch;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getGA() {
        return GA;
    }

    public void setGA(int GA) {
        this.GA = GA;
    }
    public void win(int goals){
        this.point+=3;
        this.GA+=goals;
        this.totalMatch+=1;
    }
    public void lose(int goals){
        this.GA+=goals;
        this.totalMatch+=1;
    }
    public void draw(int goals){
        this.point+=1;
        this.totalMatch+=1;
    }
}