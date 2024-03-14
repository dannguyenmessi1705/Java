package PTIT.LAB02_FlightBooking_Booking_Class;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = Integer.parseInt(sc.nextLine());
        while (test-- > 0){
            String result = "";
            FlightBooking fb = new FlightBooking();
            String s = sc.nextLine();
            String[] users = s.split("\\D+");
            // regrex d+ and s+ to split string by number and space
            String[] commands = s.split("\\d+");
            for (int i = 0; i < users.length; i++) {
                if (commands[i + 1].trim().equals("Booking")) {
                    fb.bookSeat();
                    result += String.format("[Seat Available: %d]", fb.getSeatAvailable());
                }else if (commands[i+1].trim().equals("Confirmed")){
                    result += String.format("--User %s Confirmed--[Seat Available: %d]", users[i], fb.getSeatAvailable());
                }
                else if (commands[i+1].trim().equals("Cancel")){
                    fb.cancelSeat();
                    result += String.format("[Seat Available: %d]", fb.getSeatAvailable());
                }
            }
            System.out.println(result);
        }
    }

}

class FlightBooking {
    public String flightId="OOP24";
    private static int seatAvailable=180;

    public FlightBooking(){
        seatAvailable = 180;
    }

    public void bookSeat(){
        if (seatAvailable>0)
            seatAvailable--;
    }
    public void cancelSeat(){
        if (seatAvailable<180)
            seatAvailable++;
    }
    public void confirmBooking(){
        return;
    }
    public int getSeatAvailable(){
        return seatAvailable;
    }

}
