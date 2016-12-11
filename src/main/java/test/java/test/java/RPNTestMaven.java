package test.java.test.java;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.Assert;
// 2	3	+
// 2	3	4	+
// 2	+	3
// +	2	3
// +
// 2
// 2	*	3
// 2	/	3
// 2	4	5	+	*
// 2	4	5	+	/

public class RPNTestMaven {
  public static void main(String[] args) throws IOException {
	  try {
		  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		    for (;;) {
		      String s;
				s = in.readLine();
		      if (s==null) {
		    	  System.out.println("No Numbers & Operators - As Input");
		    	  break;
		      }
		      if (s.isEmpty()) {
		    	  System.out.println("No Numbers & Operators - As Input");
		    	  break; }
		      if (s.trim().length() == 0) {
		    	  System.out.println("No Numbers & Operators - As Input");
		    	  break;
		      }
		      String regEx = "[0-9]";
		      int flag = 0;
		      for (int j = 0; j < s.trim().length(); j++){
		    	  if (s.substring(j, j + 1).matches(regEx)){
		    		  flag = 2;
		    		  break;
		    	  }
		    	  else
		    		  flag = 1;
		      }
		      if (flag == 1){
		    	  System.out.println("No Numbers - As Input");
		    	  break;
		      }
		      
		      Stack<String> tks = new Stack<String>();
		      tks.addAll(Arrays.asList(s.trim().split("[ \t]+")));
		      if (tks.peek().equals("")) continue;
		      try {
		        double r = evalrpn(tks);
		        if (!tks.empty()) throw new Exception();
		        System.out.println(r);
		      }
		      catch (Exception e) {System.out.println("error");
		      System.out.println("");}
		    }
		  }catch (IOException e1) {
		  e1.printStackTrace();
	  }
  }

  private static double evalrpn(Stack<String> tks) throws Exception {
    String tk = tks.pop();
    double x,y;
    try {x = Double.parseDouble(tk);}
    catch (Exception e) {
      y = evalrpn(tks);  x = evalrpn(tks);
//      switch(tk.trim()) {
//      case "+":
//    	  x += y;
//      case "-":
//    	  x -= y;
//      case "*":
//    	  x *= y;
//      case "/":
//    	  x /= y;
//      case "!":
//    	  int fact = 1;
//    	  for(int i=1;i<=(int)x;i++){    
//    	      fact=fact * i;    
//    	  }   
//    	  x = fact;
//      default:
//    	  throw new Exception();
//      }
      
      
      if      (tk.equals("+"))  x += y;
      else if (tk.equals("-"))  x -= y;
      else if (tk.equals("*"))  x *= y;
      else if (tk.equals("/"))  x /= y;
      else if (tk.equals("!")) {
    	  int fact = 1;
    	  for(int i=1;i<=(int)x;i++){    
    	      fact=fact * i;    
    	  }   
    	  x = (int)fact;
      }
      else throw new Exception();
      
      
    }
    return x;
  }
}