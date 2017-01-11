import java.util.ArrayList;

public abstract class Player {
    protected static int[] _currGuess = {4,6,4,5}; 
    protected static int[] _finalAns =  {15,14,4,4}; //correct
    protected int[] used = new int[4];
    protected int removeFromTempAns;
    protected int _currentTurn;
    protected boolean _masterOrGuesser;
    protected int[][] _gameBoard;
    protected int[][] _pegsBoard;

    //setNextGuess() will be used to set the next guess of what the code is, will be run through Game class based on input from terminal
 //   public abstract int[] setGuess(int[] guess);


    public boolean check(int val, int[] collection){
        for (int i=0; i<collection.length; i++){
            if (val==collection[i]){
                removeFromTempAns=i;
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Integer> toArray(int[] toConvert){
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int i: toConvert)
            ret.add(i);
        return ret;
    }
    
    //will return the appropriate number/type of pegs based on the guess
    public ArrayList<Integer> givePegs(){ //int[]
        int[] pegs = new int[4];
	   int countPerf=0; //2
	   int countAlmost=0; //1
       for (int i=0; i<_currGuess.length; i++){
           if (_currGuess[i]==_finalAns[i]){
                _currGuess[i]=-11;
               _finalAns[i]=-1;
                countPerf+=1;
	   }
       }
        for (int i=0; i<_currGuess.length; i++){
            if (check(_currGuess[i], _finalAns) ){ 
                countAlmost+=1;
                _currGuess[i]=-11;
                _finalAns[removeFromTempAns]=-1;
            }
        }
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
        ArrayList<Integer> t = new ArrayList<Integer>();
        for (int i: pegs)
            t.add(i);
        return t;
        }
    
    
        //will set if instance of User or Computer is master or guesser
//    public void setMasterOrGuesser(boolean b);

    //will set final guess
//    public int[] setFinal(int[] fin) {
//	_finalAns=fin;
//    }
}
        
