import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.awt.Point;

public class Solution {
static void nextMove(int r, int c, int pacman_r, int pacman_c, int food_r, int food_c, String [] grid){
    // keep all the traval path
    Queue <Point> bq = new LinkedList<Point>();
    ArrayList <Point> path = new ArrayList<Point>();
    // save prev point for current point
    HashMap<Point, Point> pathMap = new HashMap<Point, Point>();
    // For all the travel path make sure not repeat 
    ArrayList <Point> pathAll = new ArrayList<Point>();
    bq.offer(new Point(pacman_r, pacman_c));
    pathMap.put(new Point(pacman_r, pacman_c), null);
    
    Point food = new Point(food_r, food_c);
    while(!bq.isEmpty()){

        Point cur = bq.poll();
        Point temp;
        path.add(cur);
        pathAll.add(cur);
        
        if(food.equals(cur)){
            printPath(path, pathMap);
        }else{
           //UP
            if(validPath(cur.x -1, cur.y, grid, pathAll)){
                temp = new Point(cur.x -1, cur.y);
                bq.offer(temp);
                pathMap.put(temp, cur);
                pathAll.add(temp);
            }
            // left
            if(validPath(cur.x, cur.y -1, grid, pathAll)){
                temp = new Point(cur.x, cur.y -1);
                bq.offer(temp);
                pathMap.put(temp, cur);
                pathAll.add(temp);
            }
            // right
            if(validPath(cur.x, cur.y + 1, grid, pathAll)){
                temp = new Point(cur.x, cur.y + 1);
                bq.offer(temp);
                pathMap.put(temp, cur);
                pathAll.add(temp);
            }
            //Down
            if(validPath(cur.x +1, cur.y, grid, pathAll)){
                temp = new Point(cur.x +1, cur.y);
                bq.offer(temp);
                pathMap.put(temp, cur);
                pathAll.add(temp);
            }
            

        }
    }
}
static boolean validPath(int x, int y, String[] grid, ArrayList <Point> pathAll){
    if ((x < 0) || (x > (grid.length -1)))
        return false;
    if ((y < 0 || (y > (grid[x].length() - 1))))
        return false;
    if('%' == grid[x].charAt(y)){
        return false;
    }
    if(pathAll.contains(new Point(x, y))){
        return false;
    }
     return true;
}    
    
static void printPath(ArrayList<Point> path , HashMap<Point, Point> pathMap){
    
    System.out.println(path.size());
    for(Point p : path){
        System.out.println(p.x + " " + p.y);
    }
    ArrayList<Point> sp = new ArrayList<Point> ();
    Point p = path.get(path.size()-1);
    Point prev = pathMap.get(p);
    sp.add(p);
    while (prev != null){ 
    	sp.add(prev);
    	prev = pathMap.get(prev);
    }
    System.out.println(sp.size() -1);
    for(int i = sp.size() -1 ; i >= 0 ; i--){
    	Point t = sp.get(i);
    	System.out.println(t.x + " " + t.y);
    }
}
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int pacman_r = in.nextInt();
        int pacman_c = in.nextInt();

        int food_r = in.nextInt();
        int food_c = in.nextInt();

       int r = in.nextInt();
        int c = in.nextInt();
    
        String grid[] = new String[r];

        for(int i = 0; i < r; i++) {
            grid[i] = in.next();
        }

        nextMove( r, c, pacman_r, pacman_c, food_r, food_c, grid);
    }
}