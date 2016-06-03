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
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

/**
 *
 * @author Maureen Linda Caroline
 */
public class ScheduleTask extends TimerTask {

    private static final Logger logger = Logger.getLogger(ScheduleTask.class);
    private static final String server1 = "http://krk.data.fr24.com";
    private static final String server2 = "http://arn.data.fr24.com";
    private static final String server3 = "http://bma.data.fr24.com";
    private static final String urlSchedule = "http://data.flightradar24.com/_external/planedata_json.1.4.php?f=";
    
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
            File file = new File("data/schedule-" + System.currentTimeMillis() + ".json");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            out = new PrintWriter(new BufferedWriter(fw));
            
            System.out.println("[ScheduleTask]Time is :" + new Date()); // Display current time
            String allFlightsJsonString = getJsonString(allFlightsURL);
            

//            System.out.println(allFlightsJsonString);
//            out.write(date.toString() + "\n");
            if (allFlightsJsonString != null) {
                 Pattern pattern = Pattern.compile("(\")[a-zA-Z0-9]+(\"):(\\[)(.*?)(\\])");

                //memproses ke sql
                Matcher matcher = pattern.matcher(allFlightsJsonString);

                List<String> listMatches = new ArrayList<>();

                while (matcher.find()) {
                    listMatches.add(matcher.group(0));
                }
                
                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("cache.itb.ac.id", 8080));
                StringBuilder sb = new StringBuilder();
//                System.out.println(doGet(proxy, "http://data.flightradar24.com/_external/planedata_json.1.4.php?f=807fa56"));
                for (String s : listMatches) {
                    //"562e34c":["78018B",-2.3616,114.8793,178,41000,458,"5347","F-WALL2","B772","B-HNL",1422510709,"HKG","DPS","CX785",0,0,"CPA785",0]
//                    System.out.println(s);
                    String[] tokenColon = s.split(":");
//                    System.out.println(tokenColon[0]);
//                    System.out.println(tokenColon[1]);
                    
//                    System.out.println(urlSchedule + tokenColon[0].trim().replace("\"", ""));

                    
                        System.out.println(s);
                        sb.append(System.currentTimeMillis()+";"+s+"\n");
//                    try {
////                        System.out.println(doGet(proxy, urlSchedule + tokenColon[0].trim().replace("\"", "")));
//                        sb.append(s);
//                        sb.append(doGet(proxy, urlSchedule + tokenColon[0].trim().replace("\"", ""))).append("\n");
//                    } 
//                    catch (NoRouteToHostException | UnknownHostException | MalformedURLException ex) {
//                        logger.fatal(null, ex);
//                        System.out.println("gagal");
//                    } 
//                    catch (IOException ex) {
//                        logger.fatal(null, ex);
//                        System.out.println("error");
//                    }
                }
                
                out.write(sb.toString() + "\n");
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
                return (new PasswordAuthentication("donni.richasdy",
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
       connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:42.0) Gecko/20100101 Firefox/42.0");
       connection.setRequestProperty("Proxy-Authorization", "Basic bWF1cmVlbi5saW5kYTpzeXN0ZW0ub3V0");
       connection.setRequestProperty("Connection", "keep-alive");
       connection.setRequestProperty("Content-Type", "application/json");

       connection.setRequestMethod("GET");

       connection.connect();

       BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
       StringBuilder buffer = new StringBuilder();
       String line;
       while ((line = reader.readLine()) != null) {
           buffer.append(line);
       }
       connection.disconnect();
       return buffer.toString();
   }
}
