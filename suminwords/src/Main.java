import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        HashMap<Integer, String> lang = new HashMap<>();
        lang.put(1, "Українська");
        lang.put(2, "English");
        Set<HashMap.Entry<Integer, String>> set = lang.entrySet();
        System.out.println("---------------------------------------------");
        System.out.println("List of available languages / Список доступних мов: ");
        for (HashMap.Entry<Integer, String> me : set) {
            System.out.print(me.getKey() + " - ");
            System.out.println(me.getValue());
        }
        System.out.println("---------------------------------------------");

        byte choose = in.nextByte();

        if (choose == 1) {
            Ukraine ukr = new Ukraine();
            System.out.println("Ваша мова - " + lang.get(1));
            System.out.println("---------------------------------------------");
            System.out.println("Введіть ваше число: ");
            System.out.println("Ваше число: " + ukr.inwords(in.nextFloat()));
            System.out.println("---------------------------------------------");

        } else if (choose == 2) {
            English eng = new English();
            System.out.println("Your language is - " + lang.get(2));
            System.out.println("---------------------------------------------");
            System.out.println("Enter your number: ");
            in.useLocale(Locale.ENGLISH);
            System.out.println("Your number: " + eng.inwords(in.nextFloat()));
            System.out.println("---------------------------------------------");

        } else {
            System.out.println("---------------------------------------------");
            System.out.println("Please choose your language in range from 1 to 2");
            System.out.println("---------------------------------------------");
            System.out.println("Будь-ласка, виберіть Вашу мову в діапазоні від 1 до 2");
            System.out.println("---------------------------------------------");
        }
    }

}
