public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int i = len - 1;
        for(; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                if(i == len - 1) {
                    len--;
                } else {
                    break;
                }
            }
        }
        return i >= 0 ? len - i - 1 : len;
    }

    public static void main(String[] args) {
        String s = "a ";
        LengthOfLastWord solution = new LengthOfLastWord();
        System.out.println(solution.lengthOfLastWord(s));
    }
}
