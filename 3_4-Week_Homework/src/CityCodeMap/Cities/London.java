package CityCodeMap.Cities;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class London extends City  {

    public London(String name, String gmt , String code) {
        super(name, gmt,code);
    }

    public London(String name, String gmt) {
        super(name, gmt);
    }

}
