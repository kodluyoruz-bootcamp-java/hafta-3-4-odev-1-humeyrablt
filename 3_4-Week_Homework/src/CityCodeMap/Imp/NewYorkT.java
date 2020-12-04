package CityCodeMap.Imp;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class NewYorkT implements Runnable {
    @Override
    public void run() {
        while (true) {
            Date date = Calendar.getInstance().getTime();
            ZoneId zone = ZoneId.of("America/New_York");
            LocalTime now = LocalTime.now(zone);
            //System.out.print(" New_York Time: " + now + "\r");
            System.out.printf("Moscow_York: %s%n", now);
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }
    }
}


