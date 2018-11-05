package Controller;

import Model.Player;
import View.Gui_Handler;

public class GameEngine {
    private Gui_Handler guiHandler;
    private PlayerTurnController playerTC1;
    private PlayerTurnController playerTC2;
    private Player player1;
    private Player player2;
    private SquareController square;

    public GameEngine() {
        guiHandler = new Gui_Handler();
        player1 = new Player();
        player2 = new Player();
        square = new SquareController();
        playerTC1 = new PlayerTurnController(player1, square);
        playerTC2 = new PlayerTurnController(player2, square);
    }

    public void start() {
        setUpGame();
        playGame();
    }

    private void setUpGame() {
        //int noPlayers = guiHandler.askForNoPlayers();
        //LOOP and make players
        //guiHandler.askForPlayerNames();
        // ask for dice max value
        guiHandler.setGameUpGui(playerTC1, playerTC2);
    }

    public void playAgain() {
        String svar = guiHandler.playAgainGui();
        if (svar.equals("ja")) {
            guiHandler.removePlayer1Car(playerTC1);
            guiHandler.removePlayer2Car(playerTC2);
            start();
        } else {
            System.exit(1);
        }
//        Taget fra discord serveren
//        if (gui.getUserLeftButtonPressed("Spil igen?", "Nej", "Jo")){
//            System.exit(1);
//        }
    }

    public void playGame() {
        //Controller
        DiceCupController diceCup = new DiceCupController(2, 6);
        MessageController message = new MessageController();

        guiHandler.startGameGui(message);
        //Set player names
        guiHandler.enterNamePlayer(message, playerTC1, playerTC2);
        //diceCup = guiHandler.setDieFaces();
        //Start the main game
        do {
            guiHandler.playerTurnGui(message, playerTC1);
            guiHandler.removePlayer1Car(playerTC1);
            guiHandler.setPlayerCar(playerTC2, guiHandler.getGuiPlayer2(playerTC2));
            playerTC1.roll(message, guiHandler, diceCup, playerTC1);
            //guiHandler.playerUpdateGUI(playerTC1, guiHandler.getGuiPlayer1(playerTC1), diceCup.getRef(0), diceCup.getRef(1));
            guiHandler.showScore(message, playerTC1);
            if (player1.getWon()) {
                break;
            }

            guiHandler.playerTurnGui(message, playerTC2);
            guiHandler.removePlayer2Car(playerTC2);
            guiHandler.setPlayerCar(playerTC1, guiHandler.getGuiPlayer1(playerTC1));
            playerTC2.roll(message, guiHandler, diceCup, playerTC2);
            //guiHandler.playerUpdateGUI(playerTC2, guiHandler.getGuiPlayer2(playerTC2), diceCup.getRef(0), diceCup.getRef(1));
            guiHandler.showScore(message, playerTC2);
            if (player2.getWon()) {
                break;
            }
        }
        //End the game when one of the players get 40 and a double - or to double 6.
        while (!playerTC1.getWon() || !playerTC2.getWon());

        guiHandler.playerWonGui(message, playerTC1, playerTC2);

        //playAgain();

    }

}

