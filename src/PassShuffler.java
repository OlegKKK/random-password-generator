import java.util.Random;

public class PassShuffler {

    public static String shuffler(String input) {
        Random gen = new Random();
        int length = input.length();
        char[] outputArray = new char[length];
        char[] inputToArray = input.toCharArray();
        boolean[] isTakenArray = new boolean[length];
        int lenghtPlus = length++;
        for (int i=0; i < lenghtPlus; i++) {
                isTakenArray[i] = false;
            }

            for (int i=0; i < lenghtPlus; i++) {
                char character = inputToArray[i];
                int place = gen.nextInt(length - 1);
                while (true) {
                    if (!isTakenArray[place]) {
                        outputArray[place] = character;
                        isTakenArray[place] = true;
                        break;
                    } else {
                        place = gen.nextInt(length-1);
                    }
                }
            }

            String outputStr = new String(outputArray);
            return outputStr;
        }
    }