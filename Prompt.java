import java.util.ArrayList;
import cs1.Keyboard;
public class Prompt {
    //ie keyboard.java
    private static String _correct = "Please input a string in the format xxxx, where x is 1->6, inclusive";
    private static String _guess = "Please input a number 1-3, inclusive";
    private static final String NUMS = "123456";
    //these are the items printed instead of numbers on a windows machine:
    //square, triangle, circle, diamond, spade, heart, star
    private static final String[] ITEMS_WIN = {" ","\u25A0","\u25B2","\u25CF","\u25C6","\u2660","\u2665"};
    //reset, red, green, yellow, blue, magenta, cyan ANSI escapes
    private static final String[] COLORS = {
        (char)27+"[0m",
        (char)27+"[31m",
        (char)27+"[32m",
        (char)27+"[33m",
        (char)27+"[34m",
        (char)27+"[35m",
        (char)27+"[36m",
    };
    //combines the colors with the characters, leaving the first one blank because the numbers are 1-6
    private static final String[] ITEMS = {
        " ",
        COLORS[1]+ITEMS_WIN[1]+COLORS[0],
        COLORS[2]+ITEMS_WIN[2]+COLORS[0],
        COLORS[3]+ITEMS_WIN[3]+COLORS[0],
        COLORS[4]+ITEMS_WIN[4]+COLORS[0],
        COLORS[5]+ITEMS_WIN[5]+COLORS[0],
        COLORS[6]+ITEMS_WIN[6]+COLORS[0],
    };





    //OUTPUT HELPERS
    //turns Object[] into just a string with seperating string as optional second input
    public static void reference() {
        System.out.println("Symbol Guide:");
        for (int i = 1; i <= 6; i++) {
            System.out.print(i +": " + ITEMS[i] + "\t");
        }
        System.out.println();
    }
    public static String arrToStr(int[] arr, String seperator, boolean fancy) {
        String ret = new String();
        //checks to see if the OS is windows
        String OS = System.getProperty("os.name").toLowerCase();
        //returns true/false depending on whether or not the string win is in the version, as windows doesn't natively support colors via this method
                boolean isWin = OS.indexOf("win") >= 0;
        //for every element, add it to the return string with the delim
        //if fancy and os is unix or something else obscure, use colors
        if (fancy && !isWin) {
            for (int i = 0; i < arr.length; i++) {
                ret += ""+ITEMS[arr[i]]+seperator;
            }
        }
        else if (fancy && isWin) {
            for (int i = 0; i < arr.length; i++) {
                ret += ""+ITEMS_WIN[arr[i]]+seperator;
            }
        }
        else {
            for (int i = 0; i < arr.length; i++) {
                ret += ""+arr[i]+seperator;
            }
        }

        return ret;
    }


    public static String arrToStr(int[] arr) {
         return arrToStr(arr, "", false);
     }


     //INPUT HELPERS:

    public static String promptWord(String question, boolean hidden) {
        String in = new String();
        System.out.print(question+": ");
        in = Keyboard.readWord(hidden);
        //while the input token isn't valid, keep trying again.
        //this could be done with recursion, but there's no reason for the extra function call
        while (in == null || in.equals("")) {
            System.out.print(question+": ");
            //this starts the thread outside of the rest of the code, so the while loop doesnt stop the rest from running
            in = Keyboard.readWord(hidden);
        }
        return in;
    }
    //if no boolean given, assume hidden
    public static String promptWord(String question) {
        return promptWord(question, false);
    }


    public static boolean isAllDigs(String s) {
        for (int i = 0; i < s.length(); i++) {
            //if any substring of NUMS isnt found in the NUMS string, return false
            if (NUMS.indexOf(s.substring(i,i+1)) == -1) {
                return false;
            }
        }
        return true;
    }




    public static int[] getGuess(String question, boolean hidden) {

        //System.out.print(question+": ");
        String in = promptWord(question, hidden);
        if (in.length() != 4 || !isAllDigs(in)) {
            System.out.println(_correct);
            return getGuess(question, hidden);
        }
        //just another check to see if its an int, this is kind of unnessary
        /*
	  try {
	  Integer.parseInt(in);
	  }
	  catch (Exception e) {
	  System.out.println(_correct);
	  return getGuess(question);
	  }
        */
        int[] retArr = new int[4];
        for (int i = 0; i < 4; i++) {
            retArr[i] = Integer.parseInt(in.substring(i,i+1));
        }
        return retArr;
    }
    //if no boolean given, assume not hidden
    public static int[] getGuess(String question) {
        return getGuess(question, false);
    }


    //is a modified version of isAllDigs that sees if all elements are 0-3
    public static boolean isAllDigsPegs(String s) {
	String pegNums="012";
        for (int i = 0; i < s.length(); i++) {
            //if any substring of NUMS isnt found in the NUMS string, return false
            if (pegNums.indexOf(s.substring(i,i+1)) == -1) {
                return false;
            }
        }
        return true;
    }

    public static int[] getPegs(String question) {

        //System.out.print(question+": ");
        String in = promptWord(question);
	if (in.equals("help")) {
	    int[] a = {9999};
	    return a;
	}
        if (in.length() > 4 || !isAllDigsPegs(in)) {
            System.out.print("That is not between 0 and 2, try again.");
	    return getPegs(question);
        }

        int[] retArr = new int[in.length()];
        for (int i = 0; i < retArr.length; i++) {
            retArr[i] = Integer.parseInt(in.substring(i,i+1));
        }
        return retArr;
    }






    public static int getChoice(String question) {
        String in = promptWord(question, false);

        try {
            Integer.parseInt(in);
        }
        catch (Exception e) {
            System.out.println(_guess);
            return getChoice(question);
        }
        int ret = Integer.parseInt(in);
        if (ret > 3 || ret < 1) {
            System.out.println(_guess);
            return getChoice(question);
        }
        return ret;

    }



}
