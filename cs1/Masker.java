//since keyboard is packaged with cs1, Masker needs to be aswell
package cs1;
//this is a class that effectively masks characters as they are entered
//A Runnable is an interface that states that a class can be run in a thread
//this allows it to update the loop that masks without getting stuck in it and preventing the code from running further
//it's run on a special thread outside of the main one that executres seperately from the rest of the coded

//how it works:
//\010 is ascii for backspace, and so every milisecond it creates an * and then removes it
public class Masker implements Runnable {
    private boolean isHide;
    //this method is run it's own thread
    public void run() {
        isHide = true; //this is changed outside the thread when user input is done being taken
        System.out.print(" ");
        while (isHide) {
            System.out.print("\010"+" "); //this is a special escape character (simialr to unicode that java uses) this one is effectively a replacs
            try {
                Thread.currentThread().sleep(1); //this makes the thread it's running in stop for a milisecond, allowing it to be interupted externally
            }
            catch  (InterruptedException e) {
                //this was the error generated. I'm guessing it means the thread waws interuppted incorrectly?
            }
        }
    }
    //this will keep running until something stops it by disabling isHide
    public void stop() {
        isHide = false;
        System.out.print("\010"); //get rid of the last *
    }
}
