import java.util.ArrayList;

public class generateAll{

    //this class is used to generate all the possibilities. It prints out the array so that we don't have to read it every time, which takes longer. Then we copy and pasted the output to a plain text  file
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>(1296);
        //for every first element, and then for every 2nd, then every third etc
        for (int h=1; h<7; h++){
            for (int i=1; i<7; i++){
                for (int j=1; j<7; j++){
                    for (int k=1; k<7; k++){
                        ArrayList<Integer> one = new ArrayList<Integer>(4);
                        one.add(k);
                        one.add(j);
                        one.add(i);
                        one.add(h);
                        all.add(one);
                    }
                }
            }
        }
// all = arraylist of arrays
// all contains arrays of [1,1,1,1] , [2,1,1,1] , [3,1,1,1] etc.
        System.out.println(all);
    }
}
