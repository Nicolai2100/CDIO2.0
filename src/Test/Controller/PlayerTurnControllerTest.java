package Controller;

import Controller.DiceCupController;
import Controller.PlayerTurnController;
import Controller.SquareController;
import Model.Player;

import static org.junit.Assert.*;

public class PlayerTurnControllerTest {

    DiceCupController dicecup = new DiceCupController(2, 6);
    SquareController square = new SquareController();
    Player model = new Player();
    PlayerTurnController player1 = new PlayerTurnController(model, square);

    @org.junit.Test
    public void roll() {
        int nuværendePosition = player1.getPosition();
        assertEquals(nuværendePosition, 1);
        player1.roll(dicecup, model);
        int sum = dicecup.getSum();
        player1.setPosition(sum);
        System.out.println(player1.getPosition());
        //assertEquals(player1.getPosition(), (sum % 12) + nuværendePosition);

    }
}