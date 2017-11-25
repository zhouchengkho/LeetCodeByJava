import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Map.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        String line = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        line = br.readLine();
        String[] times = line.split(",");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Date dStart = null;
        Date dEnd = null;
        try {
            dStart = format.parse(times[0].trim());
            dEnd = format.parse(times[1].trim());
        } catch(Exception e) {
            // System.out.println(e);
        }
        LocalDate start = dStart.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        start = start.withDayOfMonth(1);
        LocalDate end = dEnd.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        // end = end.withDayOfMonth(end.lengthOfMonth());
        end = end.withDayOfMonth(1);
        TreeMap<String, TreeMap<String, String>> map = new TreeMap<>();

        line = br.readLine(); // return
        line = br.readLine(); // first input
        while(line != null) {
            String[] log = line.split(",");
            String time = log[0].trim();
            int len = (log.length-1)/2;
            if(len < 1) continue;
            String[] action = new String[len];
            String[] count = new String[len];
            for(int i = 0; i < len; i++) {
                action[i] = log[i*2+1].trim();
                count[i] = log[i*2+2].trim();
            }
            if(inRange(start, end, time)) {
                time = time.substring(0, time.length()-3);
                if(!map.containsKey(time)) {
                    TreeMap<String, String> smallMap = new TreeMap<>();
                    map.put(time, smallMap);

                }
                TreeMap<String, String> smallMap = map.get(time);
                for(int i = 0; i < len; i++) {
                    if(smallMap.containsKey(action[i])) {
                        int counts = Integer.parseInt(smallMap.get(action[i])) + Integer.parseInt(count[i]);
                        smallMap.replace(action[i], String.valueOf(counts));
                    } else {
                        smallMap.put(action[i], count[i]);
                    }
                }
            }
            line = br.readLine();
        }

        Stack<String> stack = new Stack<>();
        for(Entry<String, TreeMap<String, String>> e : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            TreeMap<String, String> smallMap = e.getValue();
            sb.append(e.getKey());
            for(Entry<String, String> se : smallMap.entrySet()) {
                sb.append(", ");
                sb.append(se.getKey());
                sb.append(", ");
                sb.append(se.getValue());
            }
            stack.push(sb.toString());

        }
        while(stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    static boolean inRange(LocalDate start, LocalDate end, String s) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;

        try {
            d = format.parse(s);

        } catch(Exception e) {
            // System.out.println(e);
            return false;
        }
        LocalDate time = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return time.isAfter(start) && time.isBefore(end) || time.equals(start);
    }
}