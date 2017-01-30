package main.java.services;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Queue;

import edu.princeton.cs.algs4.MinPQ;
import main.java.model.BoardAStar;

/**
 * Find a solution to the initial board (using the A* algorithm)
 */

public final class AStarSolver implements ISolver {

    private int moves;
    private MinPQ<BoardAStar> queue;
    private Queue<BoardAStar> previous = new ArrayDeque<>();

    /**
     * Class constructor.
     * 
     * @param initial
     *            The initial chess board
     */
    public AStarSolver(BoardAStar initial) {
        moves = 0;
        queue = new MinPQ<>(new BoardComparator());
        queue.insert(initial);
    }

    /**
     * Finds the shortest way to the final position (3x3)
     */
    @Override
    public int solve() {
        while (true) {
            if (queue.isEmpty()) {
                System.out
                        .println("Knight cannot move to the end of the board!");
                return -1;
            }
            BoardAStar min = queue.delMin();
            while (!queue.isEmpty()) {
                queue.delMin();
            }
            BoardAStar prev = null;
            if (previous.size() >= 1)
                prev = previous.peek();
            previous.add(min);
            if (min.isGoal()) {
                printGoal();
                break;
            }
            moves++;
            Iterable<BoardAStar> b = min.neighbors();
            for (BoardAStar item : b) {
                if (prev == null
                        || (!prev.equals(item) && !previous.contains(item))) {
                    queue.insert(item);
                }
            }
        }
        return moves;
    }

    /**
     * Prints all steps
     */
    private void printGoal() {
        System.out.println(moves);
        while (!previous.isEmpty()) {
            BoardAStar h = previous.remove();
            if (h.getDirection() != null) {
                System.out.println(h.getDirection());
            }
        }
    }

    private class BoardComparator implements Comparator<BoardAStar> {
        @Override
        public int compare(BoardAStar o1, BoardAStar o2) {
            return o1.manhattan() - o2.manhattan();
        }
    }
}
