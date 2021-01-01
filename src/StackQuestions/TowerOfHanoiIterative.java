package StackQuestions;

public class TowerOfHanoiIterative {
    public static void main(String[] args) {
        int noOfDisks = 2;
        towerOfHanoi('A','B','C',noOfDisks);
    }

    private static void towerOfHanoi(char fromTower, char auxTower, char toTower, int noOfDisks) {
        if(noOfDisks==1){
            System.out.println("Move disk from "+fromTower+" to "+toTower);
            return;
        }
        towerOfHanoi(fromTower,toTower,auxTower,noOfDisks-1);
        System.out.println("Move disk from "+fromTower+" to "+toTower);
        towerOfHanoi(auxTower,fromTower,toTower,noOfDisks-1);
    }
}
