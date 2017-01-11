public class Computer extends Player{
    public int[] makeAnswer(){
	int[] answer= new int[6];
	for (int i=0; i<6; i++){
	    answer[i]=(int)Math.random()*6;
	}
	return answer;
    }

    public Computer() {
	_masterOrGuesser = false; //false means it is the master
	_gameBoard=new int[12][4];
	_pegsBoard=new int[12][4];
	_currentTurn=0;
	setFinal(makeAnswer());
    }
    
    public static void main(String[] args){
        Computer t = new Computer();
        System.out.println(t.givePegs());   
    }
    
	    
}
