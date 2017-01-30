package src.test.java;

import src.main.java.model.BoardDFS;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BoardDFSTest {

    @Test
    public void testSwap1() {

        BoardDFS board1 = new BoardDFS(0, 1);
        BoardDFS board2 = new BoardDFS(1, 2, board1);
        board2.setDirection("From (0 , 1) to (1 , 2)!");

        testSwap(board1, 1, 2, board2, "From (0 , 1) to (1 , 2)!");
    }

    private void testSwap(BoardDFS oldBoard, int otherI, int otherJ,
            BoardDFS expectedBoard, String expectedDirection) {
        BoardDFS swappedBoard = oldBoard.swap(oldBoard.getxCoord(),
                oldBoard.getyCoord(), otherI, otherJ);
        assertEquals(swappedBoard, expectedBoard);
        assertEquals(swappedBoard.getDirection(), expectedDirection);
    }

}
