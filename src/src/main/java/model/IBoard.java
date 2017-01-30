package src.main.java.model;

public interface IBoard {

    /**
     * Board dimension
     */
    public static final int DIMENSION = 3;

    /**
     * Checks if coordinates are valid.
     * 
     * @param x
     *            x coordinate
     * @param y
     *            y coordinate
     * @return true if x and y are in the scope, and false otherwise
     */
    public static boolean isValid(int x, int y) {
        return !((x < 0 || x > DIMENSION - 1) || (y < 0 || y > DIMENSION - 1));
    }

    /**
     * Is this board the goal board.
     * 
     * @return true if is on the final position and false otherwise
     */
    public boolean isGoal();
}
