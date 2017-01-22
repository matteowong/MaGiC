import java.util.ArrayList;

public abstract class Player {
    protected static int[] _currGuess = new int[4];
    protected static int[] _finalAns = new int[4]; //correct
    protected int[] used = new int[4];
    protected int removeFromTempAns;
    protected int _currentTurn;
    protected boolean _masterOrGuesser;
    protected int[][] _gameBoard;
    protected int[][] _pegsBoard;

    //setNextGuess() will be used to set the next guess of what the code is, will be run through Game class based on input from terminal
    //pre-con: takes a four digit int array
    //post-con returns the input and sets _currGuess instance variable to input
    public int[] setGuess(int[] guess){
	for (int i=0;i<4;i++)
	    _currGuess[i]=guess[i];
	return guess;
    }

    //checks if an integer is in an int array
    //pre-con: int and an int array
    //post-con: true if int is in the array, false otherwise
    public boolean check(int val, int[] collection){
        for (int i=0; i<collection.length; i++){
            if (val==collection[i]){
                removeFromTempAns=i;
                return true;
            }
        }
        return false;
    }
    
    //will return the appropriate number/type of pegs based on the guess
    //pre-con: none. called on the _currGuess instance variable
    //post-con: returns array with the appropriate pegs
    public int[] givePegs(){ //int[]
	int[] localFin=new int[4];//local deep copy of the final answer so it doesnt get edited
	for (int i=0;i<4;i++)
	    localFin[i]=_finalAns[i];
        int[] pegs = new int[4];//will be returned
	int countPerf=0; //2
	int countAlmost=0; //1

	//checks for perfect matches, right number in right index
	for (int i=0; i<_currGuess.length; i++){
	    if (_currGuess[i]==localFin[i]){
                _currGuess[i]=-11;//removes from currGuess so it wont interfere with checking for imperfect matches
		localFin[i]=-1;//removes from local final answer
                countPerf+=1;
	    }
	}

	//checks for matches, right number but wrong index
        for (int i=0; i<_currGuess.length; i++){
            if (check(_currGuess[i], localFin) ){
                countAlmost+=1;
                _currGuess[i]=-11;
                localFin[removeFromTempAns]=-1;
            }
        }

	//constructs pegs array
        int z=0;
        while (countPerf>0 || countAlmost>0){
            if ( countPerf>0){
                pegs[z]=2;
                countPerf-=1;
            }
            else {
                pegs[z]=1;
                countAlmost-=1;
            }
            z+=1;
        }
	return pegs;
    }

    //mutator for gameboard
    //pre-con: 2d array of ints
    //post-con: sets gameboard to input
    public void setGameBoard(int[][] a) {
	_gameBoard=a;
    }

    //mutator for pegsboard, same as setGameBoard()
    //pre-con: 2d int array
    //post-con: sets pegsboard to input
    public void setPegsBoard(int[][] a) {
	_pegsBoard=a;
    }

    //increments _currentTurn by one
    public void setTurn() {
	_currentTurn+=1;
    }

    //sets final (correct) answer
    public int[] setFinal(int[] fin) {
	_finalAns=fin;
	return fin;
    }

    //accessor for final answer (correct)
    public int[] getFinal() {
	return _finalAns;
    }
    
}
