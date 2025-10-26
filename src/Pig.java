public class Pig {

    /*
    * Create a method "pigLatin" that takes a string consisting of one or more 
    * all-lowercase words separated by spaces. It should return a new string 
    * converted to "pig Latin," where each word has its first letter moved to 
    * the back and the letters "ay" are added to the end of the word. However, 
    * words starting with a vowel (a, e, i, o, or u) should not be altered.
    *
    * Examples:
    *
    * pigLatin("something")  should return "omethingsay"
    * pigLatin("awesome")    should return "awesome" (words starting with a vowel should not be altered)
    * pigLatin("latin is a hard language")  should return "atinlay is a ardhay anguagelay"
    * pigLatin("y")  should return "yay"
    * pigLatin("e")   should return "e"
    */
    public static void main(String[] args) {
        // Test cases
        assertEqual(1, pigLatin("something"), "omethingsay");
        assertEqual(2, pigLatin("awesome"), "awesome");
        assertEqual(3, pigLatin("latin is a hard language"), "atinlay is a ardhay anguagelay");
        assertEqual(4, pigLatin("y"), "yay");
        assertEqual(5, pigLatin("e"), "e");
    }

    // Pseudocode area:
    // check if first letter is a e i o u
    // if true: skip and returns word
    // if false: takes first letter, move letter back, deletes first letter, add "ay"

    // Implement your solution here!
    public static String pigLatin(String sentence) {
        String pigString = "";
        if(sentence.contains(" "))
        {
            String[] arr = sentence.split(" ");
            for(String s : arr)
            {
                String wordPig = pigWord(s);
                pigString += wordPig + " ";
            }
            pigString = pigString.substring(0, pigString.length() - 1);
        }
        else
        {
            String wordPig = pigWord(sentence);
            pigString += wordPig;
        }
        return pigString;
    }

    public static String pigWord(String word) {
        char firstLetter = word.charAt(0);
        if(firstLetter == 'a' || firstLetter == 'e' || firstLetter == 'i' || firstLetter == 'o' || firstLetter == 'u')
        {
            return word;
        }
        else
        {
            char[] pig = word.toCharArray();
            char first = pig[0];
            word = word.substring(1);
            word += first + "ay";
        }
        return word;
    }

    // Method to help with testing, you do not need to read this.
    public static void assertEqual(int testNumber, String actual, String expected) {
        if (!expected.equals(actual)) {
        System.out.println("Test " + testNumber + " failed! Expected: '" + expected + "', but got: '" + actual + "'");
        } else {
        System.out.println("Test " + testNumber + " passed!");
        }
    }
}  