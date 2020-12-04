package CityCodeMap.Imp;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class MoscowT implements Runnable {
    @Override
    public void run() {


        while(true)
        {


            Date date = Calendar.getInstance().getTime();
            // DateFormat formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy, hh:mm:ss a");
            //String today = formatter.format(date);
            ZoneId zone = ZoneId.of("Europe/Moscow");
            LocalTime now = LocalTime.now(zone);
           // System.out.print(" Moscow Time: " +now+"\r");
           System.out.printf("Moscow time: %s%n", now );
            try{
                Thread.sleep(1000);
            } catch(Exception ex){
                ex.printStackTrace();

            }
        }
    }
}
