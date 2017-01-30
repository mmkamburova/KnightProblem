package src.main.java;

import src.main.java.model.BoardDFS;
import src.main.java.services.DFSSolver;

/**
 * Tests DFS algorithm
 */

public class MainDFS {

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
            BoardDFS initial = new BoardDFS(x, y);
            DFSSolver solver = new DFSSolver(initial);
            solver.solve();
        }

    }
}
