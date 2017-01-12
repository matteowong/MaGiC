import java.util.ArrayList;

public class Game {
    private Player _guesser; //commented to avoid error for time being
    private Player _masterMind; //see above
    private int[][] _board = new int[12][4];
    private int[][] _pegs= new int[12][4];
    private int _turn;
    private int[] _correctAns= new int[4];
    private static String[][] matching = {{"1","blue"},{"2","red"},{"3","orange"},{"4","yellow"},{"5","purple"},{"6","brown"}};

    //    commented so no errors -- does not compile yet bc no User.java or Computer.java have been written
    public Game() {
	//	if (userGuesser) {
	    _guesser = new User();
	    _masterMind = new Computer();
	    //super confusing line follows: the correct answer is being set by the setFinal() method, which takes an int array. to generate a code the _masterMind must be typecasted to a Computer to run the makeAnswer() method
	    _correctAns=_masterMind.setFinal(((Computer)_masterMind).makeAnswer());
	    /*	}
	else {
	    _guesser=new Computer();
	    _masterMind=new User();
	    }*/
	_turn=0;
    }

    public int[][] getBoard() {
	return _board;
    }

    public int[][] getPegs() {
	return _pegs;
    }

    public boolean turn(int[] guess) {
	_guesser.setGuess(guess);
	_masterMind.setGuess(guess);
	_board[_turn]=guess;
	_pegs[_turn]=_masterMind.givePegs();
	_turn+=1;
	if (_pegs[_turn-1][3]==2)
	    return true;
	else
	    return false;
    }

    public int getTurn() {
	return _turn;
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




    /*testing
    public static void main(String[] args){
        String[] x = new String[] {"blue","brown","orange","purple","blue","yellow"};
        ArrayList<String> t = new ArrayList<String>();
        for (String ret:x)
	    t.add(ret);
        Game test=new Game();
        System.out.println(test.translatorToNum(t)); //expect 1 6 3 5 1 4
	Game magic = new Game();
	int[] a = {0,1,2,3};
	magic.turn(a);
	for (int x:magic._correctAns)
	    System.out.print(x+",");
	System.out.println();
	for (int i:magic._board[0])
	    System.out.print(i+",");
	System.out.println();
	for (int j:magic._pegs[0])
	    System.out.print(j+",");
	System.out.println();
	}*/


}
