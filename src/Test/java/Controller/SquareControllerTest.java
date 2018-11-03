package Controller;

import Model.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareControllerTest {

    SquareController square = new SquareController();

    Player playerModel = new Player();
    DiceCupController diceCup = new DiceCupController(2,6);
    PlayerTurnController player = new PlayerTurnController(playerModel,square);

    @Test
    public void newSquare() {
        for (int roll = 1; roll <= 1000; roll++){
            int rollSum = diceCup.rollAndGetSum();
            player.newSquare(rollSum, player.getPosition());
            int newPlayerPosition = player.getPosition();
            assertTrue(1 <= newPlayerPosition && newPlayerPosition <= 12 );
        }
    }

    @Test
    public void squareImpact() {
        int[] position = {1,2,3,4,5,6,7,8,9,11,12};
        int[] fieldList = {0,250,-100,100,-20,180,0,-70,60,-50,650};

        for (int i = 0; i < position.length; i++) {
            int initialBalance = player.getBalance();
            player.setPosition(position[i]);
            square.squareImpact(player, diceCup);
            int balancePostImpact = player.getBalance();
            assertEquals(balancePostImpact, initialBalance+fieldList[i]);
        }

    }
}