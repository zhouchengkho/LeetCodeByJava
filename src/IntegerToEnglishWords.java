public class IntegerToEnglishWords {
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        String[] q = {"Billion", "Million", "Thousand"};
        int[] qInt = {1000000000, 1000000, 1000};
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q.length; i++) {
            if(num >= qInt[i]) {
                int d = num/qInt[i];
                num-=d*qInt[i];
                sb.append(readHundred(d));
                sb.append(q[i]);
                sb.append(" ");
            }
        }

        sb.append(readHundred(num));
        return sb.toString().trim();
    }

    private String readHundred(int num) {
        String[] sq = {"Ninety", "Eighty", "Seventy", "Sixty", "Fifty", "Forty", "Thirty", "Twenty",
                "Nineteen", "Eighteen", "Seventeen", "Sixteen", "Fifteen", "Fourteen", "Thirteen", "Twelve", "Eleven",
                "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two", "One"};
        int[] sqInt = {90, 80, 70, 60, 50, 40, 30, 20,
                19, 18, 17, 16, 15, 14, 13, 12, 11,
                10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        // above 100
        if(num == 0) return " ";
        StringBuilder sb = new StringBuilder();
        if(num >= 100) {
            int d = num/100;
            num-=d*100;
            sb.append(readSingle(d));
            sb.append(" Hundred ");
        }

        for(int i = 0; i < sq.length; i++) {
            if(num - sqInt[i] >= 0) {
                num-=sqInt[i];
                sb.append(sq[i]);
                sb.append(" ");
            }
        }


        return sb.toString();

    }

    private String readSingle(int num) {
        String[] singleQ = {"Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two", "One"};
        int[] singleint = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        for(int i = 0; i < singleint.length; i++) {
            if(num == singleint[i]) {
                return singleQ[i];
            }
        }
        return singleQ[0];
    }

    public static void main(String[] args) {
        int num = 123456;
        IntegerToEnglishWords sol = new IntegerToEnglishWords();
        System.out.println(sol.numberToWords(num));
    }
}
