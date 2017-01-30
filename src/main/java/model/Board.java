package src.main.java.model;

import java.util.Stack;

public abstract class Board<T> implements IBoard {

    private char[][] blocks;
    private String direction;
    private int xCoord;
    private int yCoord;

    /**
     * Class Constructor. Creates new board with specified dimension and
     * initializes it
     * 
     * @param x
     *            x coordinate
     * @param y
     *            y coordinate
     */
    public Board(int x, int y) {

        if (!IBoard.isValid(x, y)) {
            throw new IllegalArgumentException("Invalid args values!");
        }

        this.xCoord = x;
        this.yCoord = y;

        this.blocks = new char[DIMENSION][DIMENSION];
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                this.blocks[i][j] = 'E';
                if (i == DIMENSION - 1 && j == DIMENSION - 1) {
                    this.blocks[i][j] = 'F';
                }
                if (i == this.xCoord && j == this.yCoord) {
                    this.blocks[i][j] = 'K';
                }
            }
        }
    }

    public abstract T swap(int i, int j, int otherI, int otherJ);

    /**
     * Adds all neighboring boards
     * 
     * @param stack
     *            stack which to fill in with neighboring coordinates
     * @return stack with all valid moves to the current position
     */
    public Stack<T> addNeighbors(Stack<T> stack) {

        if (stack != null) {
            addToStack(stack, xCoord + 1, yCoord - 2);
            addToStack(stack, xCoord + 1, yCoord + 2);
            addToStack(stack, xCoord - 1, yCoord - 2);
            addToStack(stack, xCoord - 1, yCoord + 2);
            addToStack(stack, xCoord + 2, yCoord - 1);
            addToStack(stack, xCoord + 2, yCoord + 1);
            addToStack(stack, xCoord - 2, yCoord - 1);
            addToStack(stack, xCoord - 2, yCoord + 1);
        }

        return stack;
    }

    /**
     * Fills in stack with new board
     * 
     * @param stack
     *            stack to which to add new board
     * @param newX
     *            new x coordinate
     * @param newY
     *            new y coordinate
     */
    public void addToStack(Stack<T> stack, int newX, int newY) {
        if (IBoard.isValid(newX, newY)) {
            stack.push(swap(xCoord, yCoord, newX, newY));
        }
    }

    /**
     * Checks if this board is equal to the other board
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object y) {
        if (y == this)
            return true;
        if (y == null)
            return false;
        if (y.getClass() != this.getClass())
            return false;
        Board<T> that = (Board<T>) y;
        char[][] thisBlocks = getBlocks();
        char[][] otherBlocks = that.getBlocks();
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (thisBlocks[i][j] != otherBlocks[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * If knight moves to 3 x 3 corner.
     */
    @Override
    public boolean isGoal() {
        return this.blocks[DIMENSION - 1][DIMENSION - 1] == 'K';
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public char[][] getBlocks() {
        return blocks;
    }

    public void setBlocks(char[][] blocks) {
        this.blocks = blocks;
    }
}
