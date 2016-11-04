import java.util.ArrayList;
import java.util.Random;

public class RandomGenerator {
    public static Random intGenerator = new Random();

    public static String nextWord(int length, boolean includeCaps, boolean includelowerCase, boolean includeNumbers) {
        String word = "";

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

            //x = minRange
            //y = maxRange
            //nextInt(y-x) + x;
            switch (charType2){
                case 'c':
                word+=(char) intGenerator.nextInt(90-65) + 65;
                    break;
                case 'l':
                word+=(char) intGenerator.nextInt(122-97) + 97;
                    break;
                case 'n':
                word+=(char) intGenerator.nextInt(48-57) + 57;
                    break;
            }
        }
        return word;
    }
}
