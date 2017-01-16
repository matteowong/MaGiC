public class Computer extends Player{
    private int iter=0;
    public int[] makeAnswer(){
	int[] answer= new int[4];
	for (int i=0; i<4; i++){
	    answer[i]=(int)(Math.random()*6)+1;
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

    public int checkZeroes(int[] a) {
	int ret=0;
	for (int x: a) {
	    if (x==0)
		ret+=1;
	}
    return ret;
    }

    /*    public int[] algo() {
	int[] guesses = new int[2];
	int[] nextGuess=new int[4];
	int numZ=0;
	if (iter==0) {
	    guesses[0]=1;
	    guesses[1]=2;
	}
	else if (iter==1) {
	    guesses[0]=3;
	    guesses[1]=4;
	}
	else {
	    guesses[0]=5;
	    guesses[1]=6;
	}
	numZ=checkZeroes(_gameBoard[_currentTurn]);

	}*/

}
