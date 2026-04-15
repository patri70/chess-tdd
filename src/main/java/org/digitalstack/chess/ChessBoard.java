package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if ( !isLegalBoardPosition(xCoordinate, yCoordinate)) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
            return;
        }
        if (pieces[xCoordinate][yCoordinate] != null) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
            return;
        }

        int colorPawn=0;
        for (int row = 0; row < BOARD_HEIGHT; row++)
            for (int col = 0; col < BOARD_WIDTH; col++)
                if (pieces[row][col] != null && pieceColor == pieces[row][col].getPieceColor())
                    colorPawn++;

        if (colorPawn >= 7) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
            return;
        }

        pieces[xCoordinate][yCoordinate] = pawn;
        pawn.setXCoordinate(xCoordinate);
        pawn.setYCoordinate(yCoordinate);

        pawn.setChessBoard(this);

            }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        if ( xCoordinate < 0 || xCoordinate > BOARD_WIDTH - 1 )
            return false;
        return yCoordinate >= 0 && yCoordinate <= BOARD_HEIGHT - 1;
    }
}
