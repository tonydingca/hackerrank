import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //http://www.kylen314.com/archives/5761
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n+1];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        // Tricky: set a very small value to make loop easy
        a[n] = 0;
        Stack <Integer> s = new Stack<Integer>();
        int maxArea = 0;
        
        for(int i = 0; i <= n; i++){
            // always push index if left lower than right, top increase
            if(s.isEmpty() || a[i] > a[s.peek()]) {
                s.push(i);
            }else{
                // if left higher than right, pop and calculate one by one until left lower than right or empty stack
                while(!s.isEmpty() && a[i] < a[s.peek()]){
                    int top = s.pop();
                    
                    int j1, j2;
                    if(s.isEmpty()){
                        j1 = 0;
                    }else{
                        j1 = s.peek() + 1;
                    }
                    j2 = i - 1;
                    int area = a[top] * (j2 - j1 + 1);
                    maxArea = Math.max(area, maxArea);
                }
                // push new right in stack
                s.push(i);
            }
        }
        System.out.println(maxArea);
    }
}