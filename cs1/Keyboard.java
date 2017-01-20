package cs1;

//********************************************************************
//  Keyboard.java       Author: Lewis and Loftus
//
//  Facilitates keyboard input by abstracting details about input
//  parsing, conversions, and exception handling.
//********************************************************************

import java.io.*;
import java.util.*;

public class Keyboard
{
   //*************  Error Handling Section  **************************

   private static boolean printErrors = true;
   private static int errorCount = 0;

   //-----------------------------------------------------------------
   //  Returns the current error count.
   //-----------------------------------------------------------------
   public static int getErrorCount()
   {
      return errorCount;
   }

   //-----------------------------------------------------------------
   //  Resets the current error count to zero.
   //-----------------------------------------------------------------
   public static void resetErrorCount (int count)
   {
      errorCount = 0;
   }

   //-----------------------------------------------------------------
   //  Returns a boolean indicating whether input errors are
   //  currently printed to standard output.
   //-----------------------------------------------------------------
   public static boolean getPrintErrors()
   {
      return printErrors;
   }

   //-----------------------------------------------------------------
   //  Sets a boolean indicating whether input errors are to be
   //  printed to standard output.
   //-----------------------------------------------------------------
   public static void setPrintErrors (boolean flag)
   {
      printErrors = flag;
   }

   //-----------------------------------------------------------------
   //  Increments the error count and prints the error message if
   //  appropriate.
   //-----------------------------------------------------------------
   private static void error (String str)
   {
      errorCount++;
      if (printErrors)
         System.out.println (str);
   }

   //*************  Tokenized Input Stream Section  ******************

   private static String current_token = null;
   private static StringTokenizer reader;

   private static BufferedReader in = new BufferedReader
      (new InputStreamReader(System.in));



   //-----------------------------------------------------------------
   //  Gets the next input token assuming it may be on subsequent
   //  input lines.
   //-----------------------------------------------------------------
   private static String getNextToken()
   {
      return getNextToken (true);
   }

   //-----------------------------------------------------------------
   //  Gets the next input token, which may already have been read.
   //-----------------------------------------------------------------
   private static String getNextToken (boolean skip) {return getNextToken(skip, false);}
   private static String getNextToken (boolean skip, boolean hide)
   {
      String token;

      if (current_token == null)
         token = getNextInputToken (skip, hide);
      else
      {
         token = current_token;
         current_token = null;
      }

      return token;
   }

   //-----------------------------------------------------------------
   //  Gets the next token from the input, which may come from the
   //  current input line or a subsequent one. The parameter
   //  determines if subsequent lines are used.
   //-----------------------------------------------------------------
   private static String getNextInputToken(boolean skip) { return getNextInputToken(skip, false);}
   private static String getNextInputToken (boolean skip, boolean hide)
   {
      final String delimiters = " \t\n\r\f";
      String token = null;
      //THIS REPLACES ANY THREAD INPUT WITH "*"
      Masker mask = new Masker();
      Thread mask_thread = new Thread(mask);
    //   //this starts the thread outside of the rest of the code, so the while loop doesnt stop the rest from running
    if (hide) {
      mask_thread.start();
      }
      try
      {
         if (reader == null)
            reader = new StringTokenizer
               (in.readLine(), delimiters, true);

         while (token == null ||
                ((delimiters.indexOf (token) >= 0) && skip))
         {
            while (!reader.hasMoreTokens())
               reader = new StringTokenizer
                  (in.readLine(), delimiters,true);

            token = reader.nextToken();
         }
      }
      catch (Exception exception)
      {
         token = null;
      }
      mask.stop();

      return token;
   }

   //-----------------------------------------------------------------
   //  Returns true if there are no more tokens to read on the
   //  current input line.
   //-----------------------------------------------------------------
   public static boolean endOfLine()
   {
      return !reader.hasMoreTokens();
   }

   //*************  Reading Section  *********************************

   //-----------------------------------------------------------------
   //  Returns a string read from standard input.
   //-----------------------------------------------------------------
   public static String readString()
   {
      String str;

      try
      {
         str = getNextToken(false);
         while (! endOfLine())
         {
            str = str + getNextToken(false);
         }
      }
      catch (Exception exception)
      {
         error ("Error reading String data, null value returned.");
         str = null;
      }
      return str;
   }

   //-----------------------------------------------------------------
   //  Returns a space-delimited substring (a word) read from
   //  standard input.
   //-----------------------------------------------------------------
   public static String readWord() {return readWord(false);}
   public static String readWord(boolean hide)
   {
      String token;
      try
      {
         token = getNextToken(true, hide);
      }
      catch (Exception exception)
      {
         error ("Error reading String data, null value returned.");
         token = null;
      }
      return token;
   }

   //-----------------------------------------------------------------
   //  Returns a boolean read from standard input.
   //-----------------------------------------------------------------
   public static boolean readBoolean()
   {
      String token = getNextToken();
      boolean bool;
      try
      {
         if (token.toLowerCase().equals("true"))
            bool = true;
         else if (token.toLowerCase().equals("false"))
            bool = false;
         else
         {
            error ("Error reading boolean data, false value returned.");
            bool = false;
         }
      }
      catch (Exception exception)
      {
         error ("Error reading boolean data, false value returned.");
         bool = false;
      }
      return bool;
   }

   //-----------------------------------------------------------------
   //  Returns a character read from standard input.
   //-----------------------------------------------------------------
   public static char readChar()
   {
      String token = getNextToken(false);
      char value;
      try
      {
         if (token.length() > 1)
         {
            current_token = token.substring (1, token.length());
         } else
            current_token = null;

         value = token.charAt (0);
      }
      catch (Exception exception)
      {
         error ("Error reading char data, MIN_VALUE value returned.");
         value = Character.MIN_VALUE;
      }

      return value;
   }

   //-----------------------------------------------------------------
   //  Returns an integer read from standard input.
   //-----------------------------------------------------------------
   public static int readInt()
   {
      String token = getNextToken();
      int value;
      try
      {
         value = Integer.parseInt (token);
      }
      catch (Exception exception)
      {
         error ("Error reading int data, MIN_VALUE value returned.");
         value = Integer.MIN_VALUE;
      }
      return value;
   }

   //-----------------------------------------------------------------
   //  Returns a long integer read from standard input.
   //-----------------------------------------------------------------
   public static long readLong()
   {
      String token = getNextToken();
      long value;
      try
      {
         value = Long.parseLong (token);
      }
      catch (Exception exception)
      {
         error ("Error reading long data, MIN_VALUE value returned.");
         value = Long.MIN_VALUE;
      }
      return value;
   }

   //-----------------------------------------------------------------
   //  Returns a float read from standard input.
   //-----------------------------------------------------------------
   public static float readFloat()
   {
      String token = getNextToken();
      float value;
      try
      {
         value = (new Float(token)).floatValue();
      }
      catch (Exception exception)
      {
         error ("Error reading float data, NaN value returned.");
         value = Float.NaN;
      }
      return value;
   }

   //-----------------------------------------------------------------
   //  Returns a double read from standard input.
   //-----------------------------------------------------------------
   public static double readDouble()
   {
      String token = getNextToken();
      double value;
      try
      {
         value = (new Double(token)).doubleValue();
      }
      catch (Exception exception)
      {
         error ("Error reading double data, NaN value returned.");
         value = Double.NaN;
      }
      return value;
   }
}











//this is a class that effectively masks characters as they are entered
//A Runnable is an interface that states
//this allows it to update the loop that masks without getting stuck in it and preventing the code from running further
//it's run on a special thread outside of the main one that executres seperately from the rest of the coded

//how it works:
//\010 is ascii for backspace, and so every milisecond it creates an * and then removes it
class Masker implements Runnable {
    private boolean isHide;
    //this method is run it's own thread
    public void run() {
        isHide = true; //this is changed outside the thread when user input is done being taken
        System.out.print(" ");
        while (isHide) {
            System.out.print("\010"+"*"); //this is a special escape character (simialr to unicode that java uses) this one is effectively a replacs
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
