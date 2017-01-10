public class Computer extends player{
    public int[] makeAnswer(){
	int[] answer= new int[6];
	for (int i=0; i<6; i++){
	    answer[i]=(int)Math.random()*6;
	}
	return answer;
    }
	    
}
