/**
 * Created by zhoucheng on 11/11/17.
 */
public class InformationMasking {
    String handle(String text) {
        String[] lines = text.split("\n");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < lines.length; i++) {
            StringBuilder sbt = new StringBuilder();
            String line = lines[i];
            if(line.startsWith("E:")) {
                // email
                int start = findStart(line);
                String email = line.substring(start);
                sbt.append(line.substring(0, start));
                sbt.append(maskEmail(email));
            } else if (lines[i].startsWith("P:")){
                // phone
                int start = findStart(line);
                String phone = line.substring(start);
                sbt.append(line.substring(0, start));
                sbt.append(maskPhone(phone));

            } else {
                sbt.append(lines[i]);
            }
            sb.append(sbt);
            sb.append("\n");
        }

        return sb.toString();
    }

    int findStart(String s) {
        int i = 2;
        for(; i < s.length(); i++) {
            if (s.charAt(i) == ' ') continue;
            break;
        }
        return i;
    }

    String maskPhone(String phone) {
        // digit to *
        // (,) to _
        // space to _
        // preserve +
        phone = phone.trim();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < phone.length() - 4; i++) {
            if(phone.charAt(i) >= '0' && phone.charAt(i) <= '9') {
                sb.append('*');
            } else if(phone.charAt(i) == '(' || phone.charAt(i) == ')' || phone.charAt(i) == ' ' || phone.charAt(i) == '-') {
                sb.append('_');
            } else {
                sb.append(phone.charAt(i));
            }
        }
        sb.append(phone.substring(phone.length()-4));
        return sb.toString();
    }

    String maskEmail(String email) {
        StringBuilder sb = new StringBuilder();
        email = email.trim();
        int at = email.indexOf('@');
        sb.append(email.charAt(0));
        sb.append("*****");
        sb.append(email.charAt(at-1));
        sb.append(email.substring(at));
        return sb.toString();
    }

    public static void main(String[] args) {
        InformationMasking sol = new InformationMasking();

        String text = "E: zhouchengkho@gmail.com\n" +
                "P: 646 568 0208";
        System.out.println(sol.handle(text));
    }
}
