package Controller;

import View.Gui_Handler;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiceCupControllerTest {
    Gui_Handler gui = new Gui_Handler();

    @Test
    public void rollAllDice() {
        DiceCupController diceCup = new DiceCupController(2,gui);

        int die1 = diceCup.getRef(0).getFaceValue();
        int die2 = diceCup.getRef(1).getFaceValue();
        assertEquals(0, die1);
        assertEquals(0, die2);
        diceCup.rollAllDice();
        die1 = diceCup.getRef(0).getFaceValue();
        die2 = diceCup.getRef(1).getFaceValue();
        assertTrue(1 <= die1 && die1 <= 6);
        assertTrue(1 <= die2 && die2 <= 6);
    }

    @Test
    public void getSum() {
        DiceCupController diceCup = new DiceCupController(2,gui);

        assertEquals(diceCup.getSum(), 0);
        rollAllDice();
        DieController die1 = diceCup.getRef(0);
        DieController die2 = diceCup.getRef(1);
        assertEquals(diceCup.getSum(),die1.getFaceValue() + die2.getFaceValue());
    }

    @Test
    public void rollAndGetSum() {
        DiceCupController diceCup = new DiceCupController(2,gui);

        assertEquals(diceCup.getSum(), 0);
        int metodeSum = diceCup.rollAndGetSum();
        int sum = diceCup.getRef(0).getFaceValue() + diceCup.getRef(1).getFaceValue();
        assertEquals(metodeSum, sum);
        assertTrue(2 <= metodeSum && metodeSum <= 12);

    }

    @Test
    public void setDieFaces() {
        DiceCupController diceCup = new DiceCupController(2, gui);
        int x = gui.setDieFaces();
        assertTrue(1 <= x && x <= 6);
    }
}