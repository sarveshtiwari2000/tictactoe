package tictactoe.view;

import tictactoe.controller.PlayersController;
import tictactoe.controller.levels.SelectLevel;
import tictactoe.controller.levels.Level;
import tictactoe.model.GameConfig;
import tictactoe.view.OutputValue;
import tictactoe.model.Player;
import tictactoe.model.Playfield;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PlayGame {

    private final PlayersController PlayersController = new PlayersController();

    private final SelectLevel aiMode = Level.HIGH.getInstance();

    public static void main(String args[]) {
        new PlayGame().play(args);
    }

    public void play(String args[]) {
        try {
            OutputValue.info("Let's Play the Game ➤➤➤➤");

            GameConfig config = getConfig(args);

            List<Player> players = PlayersController.load(config);
            Collections.shuffle(players);

            Playfield playfield = new Playfield(config.getPlayfieldSize(), config.getPlayfieldSize());

            print(playfield);

            Scanner userControl = new Scanner(System.in);
            while (!playfield.isOver()) {
                for (Player player : players) {
                    if (player.isHuman()) {
                        boolean isValidInput = false;
                        InputValue inputValue = null;
                        while (!isValidInput) {
                            OutputValue.info(String.format("Player %s, please select your field <row, column>...", player.getCharacter()));

                            String userOption = userControl.nextLine();
                            inputValue = new InputValue(userOption);
                            if (!inputValue.isValid()) {
                                OutputValue.err("Please enter valid input. Format: <row, column>. Example 0,1 ");
                                isValidInput = false;
                                continue;
                            }
                            if (!playfield.hasField(inputValue.getLineValue(), inputValue.getColumnValue())) {
                                OutputValue.err("Please enter valid input. Format: <row, column>. Example 0,1 ");
                                isValidInput = false;
                                continue;
                            }

                            if (!playfield.isFieldAvailable(inputValue.getLineValue(), inputValue.getColumnValue())) {
                                OutputValue.err("Please enter valid input. Selected field is in use.");
                                isValidInput = false;
                                continue;
                            }

                            isValidInput = true;
                        }
                        playfield.select(player, inputValue.getLineValue(), inputValue.getColumnValue());

                    } else {
                        OutputValue.info(String.format("Computer %s selected field...", player.getCharacter()));
                        aiMode.select(player, playfield);
                    }

                    print(playfield);
                    if (playfield.isOver()) {
                        if (playfield.hasWinner()) {
                            OutputValue.info(String.format("You Win ! Congratulations player %s ! \\o/", playfield.getWinner().getCharacter()));
                        } else {
                            OutputValue.info("Game is Draw. Please Restart the Game !");
                        }
                        break;
                    }
                }
            }

        } catch (Exception e) {
            OutputValue.err(e.getMessage());
            e.printStackTrace();
        }
    }

    private GameConfig getConfig(String[] args) throws IOException {
        GameConfig config = GameConfig.defaultConfiguration();
        OutputValue.debug(String.format("Game Configuration: Play Field Size=%d, First Player=%s, Second Player=%s and Computer=%s", config.getPlayfieldSize(), config.getFirstPlayerChar(), config.getSecondPlayerChar(), config.getComputerPlayerChar()));
        return config;
    }

    private void print(Playfield playfield) {
        for (int i = 0; i < playfield.getRows(); i++) {
            for (int j = 0; j < playfield.getColumns(); j++) {
                System.out.print(String.format("[%s]", playfield.getFields()[i][j].isAssigned() ? playfield.getFields()[i][j].getAssigned().getCharacter() : "-"));
            }
            System.out.println();
        }
    }
}
