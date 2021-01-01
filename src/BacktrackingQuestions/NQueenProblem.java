package BacktrackingQuestions;

public class NQueenProblem {
    private static int sol[][] = {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
    private static int N = 8;
    public static boolean isSafe(int row, int col){
        for(int i=0;i<col;i++){
            if(sol[row][i]==1) return false;
        }
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(sol[i][j]==1) return false;
        }
        for(int i=row,j=col;i<N && j>=0;i++,j--){
            if(sol[i][j]==1) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        if(!solveUtil(0)){
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

    private static boolean solveUtil(int col) {
        if(col>=N) return true;
        for(int i=0;i<N;i++){
            if(isSafe(i,col)){
                sol[i][col]=1;
                if(solveUtil(col+1)) return true;
                sol[i][col]=0;
            }
        }
        return false;
    }
}
