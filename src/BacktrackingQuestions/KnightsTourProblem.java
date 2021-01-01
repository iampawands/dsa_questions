package BacktrackingQuestions;

import javax.xml.crypto.Data;
import java.util.Date;

public class KnightsTourProblem {
    private  static  int xMove[] = {2, 1,-1,-2,-2,-1, 1, 2};
    private  static  int yMove[] = {1, 2, 2, 1,-1,-2,-2,-1};
    private  static  int N = 8;
    private static int sol[][]=new int[8][8];
    public static boolean isSafe(int xMove, int yMove){
        if(xMove>=0 && xMove<N && yMove>=0 && yMove<N && sol[xMove][yMove]==-1) return true;
        return false;
    }
    public static void main(String[] args) {
        for (int i = 0; i < sol.length; i++)
            for (int j = 0; j < sol[0].length; j++)
                sol[i][j] = -1;
        sol[0][0]=0;
        if(!solveUtil(0,0,1,xMove,yMove)){
            System.out.println("Solution Does not exist" );
        }
        else {
            for (int i = 0; i < sol.length; i++){
                for (int j = 0; j < sol[0].length; j++)
                    System.out.print(sol[i][j]+" ");
                System.out.println();
            }

        }
    }

    private static boolean solveUtil(int x, int y, int movei, int[] xMove, int[] yMove) {
        if(movei==N*N) return true;
        for(int i=0;i<8;i++){
            int nextX = x+ xMove[i];
            int nextY = y+ yMove[i];
            if(isSafe(nextX,nextY)){
                sol[nextX][nextY]=movei;
                if(solveUtil(nextX,nextY,movei+1,xMove,yMove)) return true;
                else sol[nextX][nextY]=-1;
            }
        }
        return false;
    }
}
