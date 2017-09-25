import java.util.Stack;

public class AddBinary {
    public String addBinary(String a, String b) {
        if(b.length() < a.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        Stack<Character> s = new Stack();
        int carry = 0;
        for(int i = 0; i < b.length(); i++) {
            int fromA = i <= a.length() - 1 ? Character.getNumericValue(a.charAt(a.length() - 1 - i)) : 0;
            int fromB = Character.getNumericValue(b.charAt(b.length() - 1 - i));
            Character c = (char) ((fromA+fromB+carry)%2+48);
            s.push(c);
            carry = fromA + fromB + carry > 1 ? 1 : 0;
        }
        if(carry == 1) s.push('1');
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AddBinary solution = new AddBinary();
        String a = "1010";
        String b = "1011";
        System.out.println(solution.addBinary(a, b));
    }
}
