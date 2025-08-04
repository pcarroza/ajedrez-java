package org.citadel.models.pieces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.citadel.common.constants.BoardConstants.MAX_LIMIT;
import static org.citadel.models.pieces.Color.BLACK;
import static org.citadel.models.pieces.Color.WHITE;

public class PiecesMapBuilder {

    private PiecesMapBuilder() {
    }

    public static Map<Color, List<Piece>> createPiecesMap(BoardObserver boardObserver) {
        Map<Color, List<Piece>> piecesMap = Map.of(BLACK, createPiecesBlack(), WHITE, createPiecesWhite());
        for (List<Piece> pieces : piecesMap.values()) {
            pieces.forEach(piece -> piece.subscribe(boardObserver));
        }
        return piecesMap;
    }

    private static List<Piece> createPiecesWhite() {
        final int rowForWhitePawns = 2;
        final int rowOfWhitePieces = 1;
        return createPieces(rowForWhitePawns, rowOfWhitePieces, Color.WHITE);
    }

    private static List<Piece> createPiecesBlack() {
        final int rowForBlackPawns = 7;
        final int rowOfBlackPieces = 8;
        return createPieces(rowForBlackPawns, rowOfBlackPieces, Color.BLACK);
    }

    private static List<Piece> createPieces(int rowForPawnsByColor, int rowForPiecesByColor, Color color) {
        List<Piece> pieces = new ArrayList<>();
        for (int i = 1; i <= MAX_LIMIT; i++) {
            pieces.add(new Pawn(new Coordinate(rowForPawnsByColor, i), color));
        }
        pieces.add(new Rook(new Coordinate(rowForPiecesByColor, 1), color));
        pieces.add(new Knight(new Coordinate(rowForPiecesByColor, 2), color));
        pieces.add(new Bishop(new Coordinate(rowForPiecesByColor, 3), color));
        pieces.add(new King(new Coordinate(rowForPiecesByColor, 4), color));
        pieces.add(new Queen(new Coordinate(rowForPiecesByColor, 3), color));
        pieces.add(new Bishop(new Coordinate(rowForPiecesByColor, 6), color));
        pieces.add(new Knight(new Coordinate(rowForPiecesByColor, 7), color));
        pieces.add(new Rook(new Coordinate(rowForPiecesByColor, 8), color));
        return pieces;
    }
}
