package src.main.java.model;

import java.util.Stack;

public class BoardAStar extends Board<BoardAStar> {

    /**
     * Class constructor
     * 
     * @param x
     *            x coordinate
     * @param y
     *            y coordinate
     */
    public BoardAStar(int x, int y) {
        super(x, y);
    }

    /**
     * Sum of Manhattan distances between blocks and goal
     * 
     * @return distance
     */
    public int manhattan() {
        int man = 0;
        char[][] blocks = getBlocks();

        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (blocks[i][j] == 'K') {
                    man += Math.abs(DIMENSION - 1 - i)
                            + Math.abs(DIMENSION - 1 - j);
                }
            }
        }
        return man % 3 == 0 ? 0 : 3 - (man % 3);
    }

    /**
     * Returns stack with all neighbors
     * 
     * @return stack with all neighbors
     */
    public Iterable<BoardAStar> neighbors() {
        Stack<BoardAStar> stack = new Stack<BoardAStar>();
        addNeighbors(stack);
        return stack;
    }

    /**
     * Swaps 2 elements of the board and returns new one
     * 
     * @param i
     *            current x
     * @param j
     *            current y
     * @param otherI
     *            other x
     * @param otherJ
     *            other y
     * @return swapped board
     */
    @Override
    public BoardAStar swap(int i, int j, int otherI, int otherJ) {
        BoardAStar b = new BoardAStar(otherI, otherJ);
        b.setDirection(String.format("From (%d , %d) to (%d , %d)!", i, j,
                otherI, otherJ));
        return b;
    }

    @Override
    public String toString() {
        return getxCoord() + " : " + getyCoord();
    }

}
