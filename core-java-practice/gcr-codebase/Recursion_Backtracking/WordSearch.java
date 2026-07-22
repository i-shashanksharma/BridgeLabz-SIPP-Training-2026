import java.util.*;

public class WordSearch{
public static boolean exists(char[][] grid,String word){
int rows=grid.length;
int cols=grid[0].length;
boolean[][] visited=new boolean[rows][cols];
for(int r=0;r<rows;r++){
for(int c=0;c<cols;c++){
if(backtrack(grid,word,0,r,c,visited)) return true;
}
}
return false;
}
private static boolean backtrack(char[][] grid,String word,int idx,int r,int c,boolean[][] visited){
if(idx==word.length()) return true;
if(r<0||r>=grid.length||c<0||c>=grid[0].length) return false;
if(visited[r][c]||grid[r][c]!=word.charAt(idx)) return false;
visited[r][c]=true;
boolean found=backtrack(grid,word,idx+1,r+1,c,visited)||backtrack(grid,word,idx+1,r-1,c,visited)||backtrack(grid,word,idx+1,r,c+1,visited)||backtrack(grid,word,idx+1,r,c-1,visited);
visited[r][c]=false;
return found;
}
public static void main(String[] args){
char[][] grid={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
System.out.println(exists(grid,"ABCCED"));
}
}