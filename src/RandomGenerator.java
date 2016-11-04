import java.util.ArrayList;
import java.util.Random;

public class RandomGenerator {
    public static Random intGenerator = new Random();

    public static String nextWord(int length, boolean includeCaps, boolean includelowerCase, boolean includeNumbers) {

        ArrayList<String> charTypes = new ArrayList();
        if (includeCaps) {
            charTypes.add("c");
        }
        if (includelowerCase) {
            charTypes.add("l");
        }
        if (includeNumbers) {
            charTypes.add("n");
        }

        for(int i=0;i<=length;i++) {
            String charType = charTypes.get(intGenerator.nextInt(charTypes.size()));
            System.out.println(charType);
            char charType2 = charType.charAt(0);
            switch (charType2){
                case 'c':
                    break;
                case 'l':
                    break;
                case 'n':
                    break;
            }
        }
        return "null";
    }
}
