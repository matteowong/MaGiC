public abstract class Player {
    protected int[] _nextGuess;
    protected int[] _finalAns;
    protected int _currentTurn;
    protected boolean _masterOrGuesser;
    protected int[][] _gameBoard;
    protected int[][] _pegsBoard;

    //setNextGuess() will be used to set the next guess of what the code is, will be run through Game class based on input from terminal
    public int[] setNextGuess(int[] guess);

    //will return the appropriate number/type of pegs based on the guess
    public int[] givePegs(int[] pegs);

    //will set if instance of User or Computer is master or guesser
    public void setMasterOrGuesser(boolean b);

    //will set final guess
    public int[] setFinal(int[] final) {
	_finalAns=final;
    }

}
