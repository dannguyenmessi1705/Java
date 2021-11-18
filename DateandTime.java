import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class DateandTime{
    public static void main(String[] args) {
        LocalDateTime clock = LocalDateTime.now();
        System.out.println("Before: "+clock);
        DateTimeFormatter CLOCK = DateTimeFormatter.ofPattern("E, DD MMM yyyy HH:MM:SS");
        String Format = clock.format(CLOCK);
        System.out.println("After: "+Format);
    }
        
    }