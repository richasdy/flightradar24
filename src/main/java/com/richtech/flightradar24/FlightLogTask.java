package com.richtech.flightradar24;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import org.apache.log4j.Logger;

/**
 *
 * @author Maureen Linda Caroline
 */
public class FlightLogTask extends TimerTask {

    private static final Logger logger = Logger.getLogger(FlightLogTask.class);
    private static final String server1 = "http://krk.data.fr24.com";
    private static final String server2 = "http://arn.data.fr24.com";
    private static final String server3 = "http://bma.data.fr24.com";

    String allFlightsURL;
    
    Date oldDate;
    Date date; // to display current time

    PrintWriter out;
    
    public void setAllFlightsURL(String str) {
        allFlightsURL = str;
    }

    // Add your task here
    public void run() {
        try {
            date = new Date();

            if (oldDate == null) {
                oldDate = new Date();
                
                DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                File file = new File("data/flight-log-" + dateFormat.format(date).toString() + ".json");

                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                out = new PrintWriter(new BufferedWriter(fw));
            }

            if (date.getDate() > oldDate.getDate() || date.getMonth() > oldDate.getMonth()) {
                out.close();
                DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                File file = new File("data/flight-log-" + dateFormat.format(date).toString() + ".txt");

                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                out = new PrintWriter(new BufferedWriter(fw));
            }

            System.out.println("[FlightLogTask]Time is :" + date); // Display current time
            String allFlightsJsonString = getJsonString(allFlightsURL);

//            System.out.println(allFlightsJsonString);
//            out.write(date.toString() + "\n");
            if (allFlightsJsonString != null) {
                out.write(allFlightsJsonString + "\n");
                out.flush();
            }
        } catch (IOException ex) {
            logger.fatal(null, ex);
        }
        oldDate = date;
    }

   private static String getJsonString(String allFlightsURL) {
       Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("cache.itb.ac.id", 8080));
       
       Authenticator authenticator;
        authenticator = new Authenticator() {
            
            public PasswordAuthentication getPasswordAuthentication() {
                return (new PasswordAuthentication("donni.richasdy ",
                        "bismillah".toCharArray()));
            }
        };
        Authenticator.setDefault(authenticator);
       
       try {
           return doGet(proxy, server1 + allFlightsURL);
       } catch (NoRouteToHostException | UnknownHostException | MalformedURLException ex) {
           logger.info("masuk server2");
           logger.fatal(null, ex);
           try {
               return doGet(proxy, server2 + allFlightsURL);
           } catch (NoRouteToHostException | UnknownHostException | MalformedURLException e) {
               logger.info("masuk server3");
               logger.fatal(null, e);
               try {
                   return doGet(proxy, server3 + allFlightsURL);
               } catch (NoRouteToHostException | UnknownHostException | MalformedURLException exception) {
                   logger.fatal(null, exception);
               } catch (IOException exception) {
                   logger.fatal(null, exception);
               }
           } catch (IOException e) {
               logger.fatal(null, e);
           }
       } catch (IOException ex) {
           logger.fatal(null, ex);
       }

       return null;
   }
    
   private static String doGet(Proxy proxy, String url) throws IOException {
       HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection(proxy);
       connection.setDoOutput(true);
       connection.setRequestProperty("Proxy-Authorization", "Basic bWF1cmVlbi5saW5kYTpzeXN0ZW0ub3V0");
       connection.setRequestProperty("Connection", "keep-alive");
       connection.setRequestProperty("Content-Type", "application/json");

       connection.setRequestMethod("GET");

       connection.connect();

       BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
       StringBuilder buffer = new StringBuilder();
       String line;
       while ((line = reader.readLine()) != null) {
           buffer.append(line);
       }
       connection.disconnect();
       return buffer.toString();
   }
}
