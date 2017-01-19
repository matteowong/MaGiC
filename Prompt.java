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
        in = Keyboard.readWord();
        //while the input token isn't valid, keep trying again.
        //this could be done with recursion, but there's no reason for the extra function call
        while (in == null || in.equals("")) {
            System.out.print(question+": ");
            //THIS REPLACES ANY THREAD INPUT WITH "*"

            Masker mask = new Masker();
            Thread mask_thread = new Thread(mask);
            //this starts the thread outside of the rest of the code, so the while loop doesnt stop the rest from running
            if (hidden) {
                mask_thread.start();
            }
            in = Keyboard.readWord();
            if (hidden) {
                mask.stop();
            }
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


    public static int[] getPegs(String question) {

        //System.out.print(question+": ");
        String in = promptWord(question);
        if (in.length() != 4 || !isAllDigs(in)) {
            System.out.println("Wrong! Stop cheating and try again");
	    return getPegs(question);
        }

        int[] retArr = new int[4];
        for (int i = 0; i < 4; i++) {
            retArr[i] = Integer.parseInt(in.substring(i,i+1));
	    if (retArr[i]>2 || retArr[i]<0) {
		System.out.println("Wrong! Stop cheating and try again");
		return getPegs(question);
	    }
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

    public static void print( int[][] a )
    {
	for (int i=0;i<a.length;i++){
	    for (int j=0;j<a[i].length;j++) {
		System.out.print(a[i][j]);
	    }
	    System.out.print("\n");

	}
    }

}









//this is a class that effectively masks characters as they are entered
//A Runnable is an interface that states
//this allows it to update the loop that masks without getting stuck in it and preventing the code from running further
//it's run on a special thread outside of the main one that executres seperately from the rest of the coded

class Masker implements Runnable {
    private boolean isHide;
    //this method is run it's own thread
    public void run() {
        isHide = true; //this is changed outside the thread when user input is done being taken
        while (isHide) {
            System.out.print("\010*"); //this is a special escape character (simialr to unicode that java uses) this one is effectively a replacs
            try {
                Thread.currentThread().sleep(1); //this makes the thread it's running in stop for a milisecond, allowing it to be interupted externally
            }
            catch  (InterruptedException e) {
                //this was the error generated. I'm guessing it means the thread waws interuppted incorrectly?
            }
        }
    }
    //this will keep running until something stops it by disabling isHide
    public void stop() {
        isHide = false;
    }
}
