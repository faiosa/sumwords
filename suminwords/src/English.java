public class English extends Main {

    private static final String UNIT[] = {"one ", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static final String UNITS[]  = {"ten","eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String TENS[]  = {"twenty", "thirty", "forty", "fifty",
            "sixty", "seventy", "eighty", "ninety"};
    private static final String HUNDREDS[] = {" one hundred","two hundred", "three hundred", "four hundred", "five hundred",
            "six hundred", "seven hundred", "eight hundred", "nine hundred"};
    private static final String CURRENCY[][] = { {"cent", "cents"},
            {"dollar", "dollars","1"},
            {"thousand", "thousand","0"},
            {"million", "million","1"}};

    private static String num2words(long num, int level) {
        StringBuilder words = new StringBuilder(50);
        if (num == 0) words.append(" zero ");
        int h = (int)( num % 1000);
        int d = h / 100;
        if (d > 0) words.append(HUNDREDS[d-1]).append(" ");
        int n = h % 100;
        d = n / 10;
        n = n % 10;
        switch(d) {
            case 0: break;
            case 1: words.append(UNITS[n]).append(" ");
                break;
            default: words.append(TENS[d-2]).append("-");
        }
        if (d == 1) n = 0;
        switch(n) {
            case 0: break;
            case 1:
            case 2: words.append(UNIT[n-1]).append(" ");
                break;
            default: words.append(UNIT[n-1]).append(" ");
        }
        switch(n) {
            case 1: words.append(CURRENCY[level][0]);
                break;
            case 2:
            case 3:
            case 4: words.append(CURRENCY[level][1]);
                break;
            default: if(( h!=0 )||(( h == 0 ) && (level == 1)))
                words.append(CURRENCY[level][1]);
        }
        long nextnum = num / 1000;
        if(nextnum > 0) {
            return (num2words(nextnum, level+1) + " " + words.toString()).trim();
        } else {
            return words.toString().trim();
        }
    }

    public static String inwords(double money) {
        if (money < 0.0) return "Input your number in range from 0 to 2147483647";
        String sm = String.format("%.2f", money);
        String skop = sm.substring(sm.length()-2);
        int iw;
        switch(skop.substring(1)) {
            case "1": iw = 0;
                break;
            case "2":
            case "3":
            default:  iw = 1;
        }
        int toCoin = Integer.parseInt(skop);
        String coin = null;
        if (toCoin == 0 ) {
            coin = "zero";
        }
        else if(toCoin < 10) {
            coin = UNIT[toCoin-1];
        }
        else if(toCoin < 20) {
            coin = UNITS[toCoin-10];
        }
        else if (toCoin < 100) {
            int high = toCoin / 10;
            int low = toCoin % 10;
            if (low != 0 ) {
                coin = TENS[high-2] + "-" +  UNIT[low-1];
            }
        }
        int num = (int)Math.floor(money);
        if ( num < 1 ) {
            return coin + " " + CURRENCY[0][iw];
        }
        else if (num < 2147483647) {
            return num2words(num, 1) + " " + "and " + coin + " " + CURRENCY[0][iw];
        }
        else
            return "Input your number in range from 0 to 2147483647";
    }

}
