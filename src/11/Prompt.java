import cs1.Keyboard;
public class Prompt {
    //ie keyboard.java
    private String _correct = "Please input a string in the format xxxx, where x is 0->5, inclusive";
    private String NUMS = "0123456789";

    public String promptWord(String question) {
        String in = new String();
        System.out.print(question+": ");
        in = Keyboard.readWord();
        //while the input token isn't valid, keep trying again.
        //this could be done with recursion, but there's no reason for the extra function call
        while (in == null || in.equals("")) {
            System.out.print(question+": ");
            in = Keyboard.readWord();
        }
        return in;
    }
    public boolean isAllDigs(String s) {
        for (int i = 0; i < s.length(); i++) {
            //if any substring of NUMS isnt found in the NUMS string, return false
            if (NUMS.indexOf(s.substring(i,i+1)) == -1) {
                return false;
            }
        }
        return true;
    }
    public int[] getGuess(String question) {

        System.out.print(question+": ");
        String in = promptWord(question);
        if (in.length() != 4 & !isAllDigs(in)) {
            System.out.println(_correct);
            return getGuess(question);
        }
        //just another check to see if its an int, this is kind of unnessary
        try {
            Integer.parseInt(in);
        }
        catch (Exception e) {
            System.out.println(_correct);
            return getGuess(question);
        }
        int[] retArr = new int[4];
        for (int i = 0; i < 4; i++) {
            retArr[i] = Integer.parseInt(in.substring(i,i+1));
        }
        return retArr;
    }
}
