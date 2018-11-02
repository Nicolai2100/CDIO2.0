package Controller;

public class DiceCupController {
    private final DieController[] dice;

    //Constructor
    public DiceCupController(int noDice, int noFaces){
        dice = new DieController[noDice];
        for (int i = 0; i<noDice;i++){
            dice[i] = new DieController(noFaces);
        }
    }
    //The method rolls two dice and returns their value as an integer.
    public void rollAllDice(){
        for (DieController diceController : dice){
            diceController.roll();
        }
    }
    public int getSum(){
        int sum = 0;
        for (DieController dieController : dice){
            sum+= dieController.getFaceValue();
        }
        return sum;
    }
    public int rollAndGetSum(){
        rollAllDice();
        return getSum();
    }


}
