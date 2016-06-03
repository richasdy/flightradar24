package com.richtech.flightradar24;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Timer;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Maureen Linda Caroline
 * NIM: 23513001
 */
public class Main {
    
    private static final Logger logger = Logger.getLogger(Main.class);

    private static void configureLogger() {
        try {
            Properties tLogProperties = new Properties();
            // TODO: make it constant or configurable, please
            tLogProperties.load(new FileInputStream("conf/logger/log4j.properties"));
            PropertyConfigurator.configure(tLogProperties);
        } catch (IOException ex) {
            logger.fatal(null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        try {
            //String allFlightsURL = "/zones/fcgi/feed.js?bounds=-3.035727483725802,-9.81662423477226,104.1820863815924,117.191162109375&faa=1&mlat=1&flarm=1&adsb=1&gnd=1&air=1&vehicles=1&estimated=1&maxage=900&gliders=1&stats=1&";
//              String allFlightsURL = "/zones/fcgi/feed.js?bounds=-3.035727483725802,-9.81662423477226,104.1820863815924,122.445543&faa=1&mlat=1&flarm=1&adsb=1&gnd=1&air=1&vehicles=1&estimated=1&maxage=900&gliders=1&stats=1&";
            String allFlightsURL = "/zones/fcgi/feed.js?bounds=5.309037,-10.150287,95.457450,140.836291&faa=1&mlat=1&flarm=1&adsb=1&gnd=1&air=1&vehicles=1&estimated=1&maxage=900&gliders=1&stats=1&";
            configureLogger();
            
//        Timer time = new Timer(); // Instantiate Timer Object
//        FlightLogTask flightLogTask = new FlightLogTask(); // Instantiate FlightLogTask class
//        flightLogTask.setAllFlightsURL(allFlightsURL);
//        time.schedule(flightLogTask, 0, 60000); // Create Repetitively task for every 1 minute
//        time.schedule(flightLogTask, 0, 10000); // Create Repetitively task for every 10 s
        Timer time2 = new Timer(); // Instantiate Timer Object
        ScheduleTask scheduleTask = new ScheduleTask(); // Instantiate SheduledTask class
        scheduleTask.setAllFlightsURL(allFlightsURL);
        time2.schedule(scheduleTask, 0, 10000); // Create Repetitively task for every 10 seconds
//        time2.schedule(scheduleTask, 0, 300000); // Create Repetitively task for every 5 minute
//        time2.schedule(scheduleTask, 0, 60000); // Create Repetitively task for every 1 minute
//            
//            
//            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("cache.itb.ac.id", 8080));
//            HttpURLConnection connection = (HttpURLConnection) new URL("http://data.flightradar24.com/_external/planedata_json.1.4.php?f=807fa56").openConnection(proxy);
//            connection.setDoOutput(true);
//            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:42.0) Gecko/20100101 Firefox/42.0");
//            connection.setRequestProperty("Proxy-Authorization", "Basic bWF1cmVlbi5saW5kYTpzeXN0ZW0ub3V0");
//            connection.setRequestProperty("Connection", "keep-alive");
//            
//            connection.setRequestMethod("GET");
//            
//            connection.connect();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
//            StringBuilder buffer = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                buffer.append(line);
//            }
//            connection.disconnect();
//            
//            System.out.println(buffer.toString());
//        } catch (MalformedURLException ex) {
//            logger.fatal(null, ex);
//            System.out.println(ex);
//        } catch (IOException ex) {
//            logger.fatal(null, ex);
//            System.out.println(ex);
//        }
//        
//        
    }
}
