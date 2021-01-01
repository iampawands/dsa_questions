package BacktrackingQuestions;

public class RatInAMazeProblem {
    private  static  int N = 4;
    private static int maze[][] = {{1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}};
    private static int sol[][] = {{0, 0, 0, 0},{0, 0, 0, 0},{0, 0, 0, 0},{0, 0, 0, 0}};

    public static void main(String[] args) {
        maze[0][0]=1;
        if(solveUtil(maze,0,0)){
            for (int i = 0; i < sol.length; i++){
                for (int j = 0; j < sol[0].length; j++)
                    System.out.print(sol[i][j]+" ");
                System.out.println();
            }
        }else{
            System.out.println("Solution Does not exist");
        }
    }

    private static boolean solveUtil(int[][] maze, int x, int y) {
        if(x==N-1 && y==N-1){
            sol[x][y]=1;
            return true;
        }
        if(isSafe(x,y)){
            sol[x][y]=1;
            if(solveUtil(maze,x+1,y)) return true;
            if(solveUtil(maze,x,y+1)) return true;
            sol[x][y]=0;
        }
        return false;
    }

    public static boolean isSafe(int xMove, int yMove){
        if(xMove>=0 && xMove<N && yMove>=0 && yMove<N && maze[xMove][yMove]==1) return true;
        return false;
    }
}
