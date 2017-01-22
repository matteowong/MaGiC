import java.util.ArrayList;
import cs1.Keyboard;
public class Prompt {
    //ie keyboard.java
    private static String _correct = "Please input a string in the format xxxx, where x is 1->6, inclusive";
    private static String _guess = "Please input a number 1-3, inclusive";
    private static String NUMS = "123456";

    
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
    //turns Object[] into just a string with seperating string as optional second input
    public static String arrToStr(int[] arr, String seperator) {
        String ret = new String();
        //for every element, add it to the return string with the delim
        for (int i = 0; i < arr.length; i++) {
            ret += ""+arr[i]+seperator;
        }
        return ret;
    }
    public static String arrToStr(int[] arr) { return arrToStr(arr, "");}

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
