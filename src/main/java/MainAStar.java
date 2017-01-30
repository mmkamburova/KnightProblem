package main.java;

import main.java.model.BoardAStar;
import main.java.services.AStarSolver;

/**
 * Tests A* algorithm
 */
public class MainAStar {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Invalid number of args!");
            return;
        }

        if (IParsable.isParsable(args[0].trim())
                && IParsable.isParsable(args[1].trim())) {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);

            // Solve the Knight problem
            BoardAStar initial = new BoardAStar(x, y);
            AStarSolver solver = new AStarSolver(initial);
            solver.solve();
        }

    }
}
