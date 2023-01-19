import java.util.Random;

public class HelloWorldBigString {
    /**
     * Finds hello and world in a random string. And tries again with a bigger string if they aren't there...
     */
    public static void main(String[] args) {

        int startStringSize = 100;
//        int upperStringSize = 1000;
//        int upperStringSize = 1000000;      // Million
        int upperStringSize = 1000000000;   // Billion
//        int upperStringSize = 2147483647;   // Java String size limit. Expect heap errors.

        boolean hello = false;
        boolean world = false;

        /**
         * Always remember the wise words of Rami at SG. "I don't like while loops."
         */
        while (!hello || !world) {
            /**
             * Do you know what’s odd? Every other number...
             */
            for (int i = startStringSize; i <= upperStringSize; i=i+100) {
                String bigString = generateTheBigString(i);
                System.out.println("String size: " + i);
                hello = getWord(bigString, "hello");
                world = getWord(bigString, "world");

                if (hello && world) {
                    System.out.println("Hello World");
                } else {
                    hello = false;
                    world = false;
                    System.out.println("We need more String...");
                }
            }
        }
    }
    /**
     * Good code has nice comments like this.
     */
    public static String generateTheBigString(int stringSize) {
        int aChar = 97;
        int zChar = 122;
        Random random = new Random();
        return random.ints(aChar, zChar + 1)
                .limit(stringSize)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static boolean getWord(String searchIn, String searchFor) {
        String homogeniseCasing = searchIn.toLowerCase();
        if (homogeniseCasing.contains(searchFor)) {
            System.out.println(searchFor + " was found");
            return true;
//            unreachableMethod();
        } else {
            System.out.println(searchFor + " not found");
            return false;
        }
    }

    public static String unreachableMethod() {
        return "Fails accessibility testing.";
    }


}
