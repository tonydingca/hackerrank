import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            
            Stack stack = new Stack();
            boolean nobalance = false;
            for(int i = 0; i <s.length(); i++){
                String ch = String.valueOf(s.charAt(i));
                if ("{[(".indexOf(ch)>=0){
                    stack.push(ch);
                }else{
                    if (stack.isEmpty()){
                        nobalance = true;
                        break;
                    }
                    String temp = (String)stack.pop();
                    switch(ch){
                    case "}":
                        if(!temp.equals("{")){
                            nobalance = true;                        
                        }
                        break;
                    case "]":
                        if(!temp.equals("[")){
                            nobalance = true;                        
                        }
                        break;
                    case ")":
                        if(!temp.equals("(")){
                            nobalance = true;                        
                        }
                        break;
                    }
                }
                if(nobalance){
                    break;
                }                
            }
            if(!stack.isEmpty()){
                nobalance = true;
            }
            System.out.println(nobalance?"NO":"YES");
        }
        in.close();
        
    }
}