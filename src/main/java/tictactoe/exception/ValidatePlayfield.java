package tictactoe.exception;

import tictactoe.exception.ConfigException;

public class ValidatePlayfield {

    private static final int MAX_PLAYFIELD_SIZE = 10;
    private static final int MIN_PLAYFIELD_SIZE = 3;


    public static void validatePlayfieldSize(int size) {
        if (size > MAX_PLAYFIELD_SIZE) {
            throw new ConfigException(String.format("Playfield size (%d) is greater than the limit (%d);", size, MAX_PLAYFIELD_SIZE));
        }

        if (size < MIN_PLAYFIELD_SIZE) {
            throw new ConfigException(String.format("Playfield size (%d) is lower than the limit (%d);", size, MIN_PLAYFIELD_SIZE));
        }
    }
}
