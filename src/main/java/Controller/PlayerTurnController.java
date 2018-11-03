package Controller;

import Model.Player;

public class PlayerTurnController {

    private Player model;
    private SquareController square;
    private AccountController accountC;

    public PlayerTurnController(Player model, SquareController square){
        this.model = model;
        this.square = square;
        accountC = new AccountController();
    }

    public void roll(DiceCupController diceCup, PlayerTurnController player){
        int currentSum = diceCup.rollAndGetSum();
        newSquare(currentSum, getPosition());
        square.squareImpact(player, diceCup);
    }

    public void newSquare(int rollsum, int getSqaure){
        if (rollsum + getSqaure == 24){
            setPosition(12);
        }
        else if (rollsum + getSqaure > 12) {
            setPosition((rollsum + getSqaure) % 12);
        }
        else{
            setPosition(rollsum + getSqaure);
        }
    }

    public void won(){
       if (accountC.getBalance() >= 3000) setWon(true);
    }

    public int getPosition() {
        return model.getPosition();
    }

    public void setPosition(int position) {
        model.setPosition(position);
    }

    public String getName() {
        return model.getName();
    }

    public void setName(String name) {
        model.setName(name);
    }

    public void setAccountBalance(int accountUpdate)
    {   //The balance should not be able to go into minus
        int x = (accountC.getBalance()+accountUpdate);
        if (x < 0){
            accountC.setBalance(0);
        }
        accountC.setBalance(x);
    }
    public int getBalance() {
        return accountC.getBalance();
    }
    public void setWon(boolean bool) {
        model.setWon(bool);
    }
    public boolean getWon() {
        return model.getWon();
    }



}
