import java.util.ArrayList;

public class Game {
    //private Player _guesser; //commented to avoid error for time being
    //private Player _masterMind; //see above
    private int[][] _board = new int[12][4];
    private int[][] _pegs= new int[12][4];
    private int _turns;
    private int[] _correctAns= new int[4];
    private static String[][] matching = {{"1","blue"},{"2","red"},{"3","orange"},{"4","yellow"},{"5","purple"},{"6","brown"}};

    /*commented so no errors -- does not compile yet bc no User.java or Computer.java have been written
      public Game(boolean userGuesser) {
      if (userGuesser) {
      _guesser = new User(true);
      _masterMind = new Computer(false);
      _correctAns=_masterMind.setFinal();
      }
      else {
      _guesser=new Computer();
      _masterMind=new User();
      }
      _turns=0;
      }*/

    public int[][] getBoard() {
	return _board;
    }

    public int[][] getPegs() {
	return _pegs;
    }

    
    public static String searchColor(String key){
	for (int i=0; i<6; i++){
	    if (matching[i][1].equals(key))
		return matching[i][0];
	}
	return "";
    }
    public static ArrayList<String> translatorToNum(ArrayList<String> input){
        ArrayList<String> output = new ArrayList<String>();
        for (int i=0; i<input.size(); i++){
            output.add(searchColor(input.get(i)));
        }
        return output; //NOTE: output is a string, so must still parse to get int
    }




    //testing
    public static void main(String[] args){
        String[] x = new String[] {"blue","brown","orange","purple","blue","yellow"};
        ArrayList<String> t = new ArrayList<String>();
        for (String ret:x)
	    t.add(ret);
        Game test=new Game();
        System.out.println(test.translatorToNum(t)); //expect 1 6 3 5 1 4
    }


}
