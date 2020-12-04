package CityCodeMap;

import CityCodeMap.Cities.*;
import CityCodeMap.Imp.*;
import CityCodeMap.Key_Listener.MyKeyListener;

import javax.swing.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args)  {
        System.out.println("You enter CTRL to exit the program.");

        MyKeyListener klavye = new MyKeyListener();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(klavye);
        frame.setVisible(true);

        City moscow = new Moscow("MOSCOW", "GMT+3");
        City berlin = new Berlin("BERLIN", "GMT+1");
        City london = new London("LONDON", "GMT+0");
        City newYork = new NewYork("NEWYORK", "GMT-5");
        City newDelhi = new NewDelhi("NEWDELHI", "GMT+5.30");

        CityCode mos = new CityCode("MOS");
        CityCode ber = new CityCode("BER");
        CityCode lon = new CityCode("LON");
        CityCode nyc = new CityCode("NYC");
        CityCode del = new CityCode("DEL");

        Map<CityCode, City> cityMap = new HashMap<CityCode, City>();
        cityMap.put(mos, moscow);
        cityMap.put(ber, berlin);
        cityMap.put(lon, london);
        cityMap.put(nyc, newYork);
        cityMap.put(del, newDelhi);

        cityMap = sortByValue(cityMap);

        Set<Map.Entry<CityCode, City>> entries = cityMap.entrySet();
        for (Map.Entry<CityCode, City> line : entries) {
            System.out.println(line.getKey() + " " + line.getValue());
        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        System.out.println("Enter more than 3 and less than 5 cone nemes please. (like MOS ..");
        System.out.println("if you type OK, you can see time information of cities.");

        List<String> list = new ArrayList<>();

        while (true) {
            for (int i = 0; i < 5; i++) {
                Scanner in = new Scanner(System.in);
                String choice = in.next();
                if (choice.equals("OK")) {
                    break;
                } else {

                    list.add(choice);
                }
            }

            if (list.size() >= 3 && list.size() <= 5) {
                for (String o : list) {
                    switch (o) {
                        case "MOS":
                            executorService.execute(new Thread(new MoscowT()));
                            break;
                        case "LON":
                            executorService.execute(new Thread(new LondonT()));
                            break;
                        case "DEL":
                            executorService.execute(new Thread(new NewDelhiT()));
                            break;
                        case "NYC":
                            executorService.execute(new Thread(new NewYorkT()));
                            break;
                        case "BER":
                            executorService.execute(new Thread(new BerlinT()));
                            break;
                        default:
                            System.out.println("You entered incorrectly.");
                    }
                }
            } else {
                System.out.println("Lack of number code. Again enter please.");
            }
        }

    }

    public static Map<CityCode, City> sortByValue(Map<CityCode, City> m) {
        List<Map.Entry<CityCode, City>> list =
                new LinkedList<Map.Entry<CityCode, City>>((Collection<? extends Map.Entry<CityCode, City>>) m.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<CityCode, City>>() {
            public int compare(Map.Entry<CityCode, City> o1,
                               Map.Entry<CityCode, City> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<CityCode, City> temp = new LinkedHashMap<CityCode, City>();
        for (Map.Entry<CityCode, City> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
