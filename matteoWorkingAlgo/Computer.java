public class Computer extends Player{
    private int _iter=0;
    private int _turnsSinceUpdatedIter=0;
    private int[] _correct=new int[4];
    private int[] _possible=new int[4];
    
    public int[] makeAnswer(){
	int[] answer= new int[4];
	for (int i=0; i<4; i++){
	    answer[i]=(int)(Math.random()*6);
	}
	return answer;
    }

    public Computer() {
	_masterOrGuesser = false; //false means it is the master
	//_gameBoard=new int[12][4];
	//_pegsBoard=new int[12][4];
	_currentTurn=0;
	setFinal(makeAnswer());
    }

    //public int[] setGuess(int[] guess) will NOT use the given input
    
    /*    public static void main(String[] args){
	  Computer t = new Computer();
	  System.out.println(t.givePegs());   
	  }*/

    //checks num zeroes in the arrray so they can be replaced
    public int checkZeroes(int[] a) {
	int ret=0;
	for (int x: a) {
	    if (x==0)
		ret+=1;
	}
    }

    //sets possible digits for the algo
    public int[] setPossibleDigits(int a) {
	int[] guesses = new int[2];
	if (a==0) {
	    guesses[0]=1;
	    guesses[1]=2;
	}
	else if (a==1) {
	    guesses[0]=3;
	    guesses[1]=4;
	}
	else {
	    guesses[0]=5;
	    guesses[1]=6;
	}
	return guesses;
    }

    //pre-con: gets peg array of 1s and 2s w/ all other slots as 0s
    //post-con: returns # of 1s, 2s
    public int numPegs(int[] pegs){
	int ret=0;
	for (int i:pegs)
	    if (i>0) ret+=1;
	return ret;
    }

    //pre-con: takes peg array
    //post-con: returns # of 2's (right color and right place)
    public int numTwos(int[] pegs) {
	int ret=0;
	for (int i:pegs)
	    if (i==2) ret+=1;
	return ret;
    }

    public int numOnes(int[] pegs) {
	int ret=0;
	for (int i:pegs)
	    if (i==1) ret+=1;
	return ret;
    }
    
    public int[] algo() {
	int[] guesses = new setPossibleDigits(_iter);//sets possible digits to guess
	int[] nextGuess=new int[4];//will return this
	int[] currPegs=new int[4];//_gameBoard[turn];
	int[] lastPegs=new int[4];//_pegsBoard[turn-1];
	for (int i=0;i<4;i++) {//maks a deep copy, 
	    nextGuess[i]=_correct[i];//correct is the current values known to the AI
	}
	int numZ=checkZeroes(nextGuess);//sets number of zeroes -- possibly unnecessary we'll see
	// if this is the first time since the iteration has been updated then the slots that have zeroes (have nothing in them) are updated
	if (_turnsSinceUpdatedIter==0) {
	    for (int i=0;i<4;i++) {
		if (nextGuess[i]==0 && i<=numZ/2)//this alternates between the two possible guesses so it is changed
		    nextGuess[i]=guesses[0];
		else if (nextGuess[i]==0 && i>numZ/2)//does every other
		    nextGuess[i]=guesses[1];
	    }

	}
	//this is the second time through, it replaces all the 1's with 2's or the 3's with 4's so that the pegs will change
	else if (_turnsSinceUpdatedIter==1) {
	    for (int i=0;i<4;i++) {
		if (nextGuess[i]==guesses[0])
		    nextGuess[i]==guesses[1];
	    }
	}
	//this is the first time it can check the difference b/w the pegs
	else if (_turnsSinceUpdatedIter==2) {
	    currPegs=_pegsBoard[turn];
	    lastPegs=_pegsBoard[turn-1];
	    int numCurrPegs=numPegs(currPegs);
	    int numLastPegs=numPegs(lastPegs);
	    //need to replace boolean #s (3,2, etc) with proportional int to numZeroes
	    if (numCurrPegs==numLastPegs && numCurrPegs<Math.round(numZ/2)) {
		//means there are Math.round(numZ/2)  guesses[1] and zero or 1  guesses[0]
		//if countTwos(currPegs)>countTwos(lastPegs)
		// => means there are guesses[1] in slots 0 or 1
		//else there are guesses[1] in slots 2 or 3, only
	    }
	    else if (numCurrPegs==numLastPegs && numCurrPegs==Math.round(numZ/2)) {
		//means there are three guesses[1] and 1 guesses[0]
	    }
	    else if (numCurrPegs< numLastPegs) {
		//there are (numCurrPegs-numLastPegs) guesses[0]
		//there are numCurrPegs guesses[1]
		//have to account for case of three or more guesses[0]
	    }
	    else if (numCurrPegs>numLastPegs) {
		//0 guesses[0]
		//numCurrPegs guesses[1]
	    }



	}
    

    return nextGuess;
    }
    
	    
}
