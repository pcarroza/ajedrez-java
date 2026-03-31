package org.citadel.models.pieces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.citadel.models.pieces.enums.Player;

import static org.citadel.common.constants.BoardConstants.MAX_LIMIT;
import static org.citadel.models.pieces.enums.Player.BLACK;
import static org.citadel.models.pieces.enums.Player.WHITE;

public class PiecesMapBuilder {

    private PiecesMapBuilder() {
    }

    public static Map<Player, List<Piece>> createPiecesMap(BoardObserver boardObserver) {
        Map<Player, List<Piece>> piecesMap = Map.of(BLACK, createPiecesBlack(), WHITE, createPiecesWhite());
        for (List<Piece> pieces : piecesMap.values()) {
            pieces.forEach(piece -> piece.subscribe(boardObserver));
        }
        return piecesMap;
    }

    private static List<Piece> createPiecesWhite() {
        final int rowForWhitePawns = 2;
        final int rowOfWhitePieces = 1;
        return createPieces(rowForWhitePawns, rowOfWhitePieces, Player.WHITE);
    }

    private static List<Piece> createPiecesBlack() {
        final int rowForBlackPawns = 7;
        final int rowOfBlackPieces = 8;
        return createPieces(rowForBlackPawns, rowOfBlackPieces, Player.BLACK);
    }

    private static List<Piece> createPieces(int rowForPawnsByColor, int rowForPiecesByColor, Player player) {
        List<Piece> pieces = new ArrayList<>();
        for (int i = 1; i <= MAX_LIMIT; i++) {
            pieces.add(new Pawn(new Coordinate(rowForPawnsByColor, i), player));
        }
        pieces.add(new Rook(new Coordinate(rowForPiecesByColor, 1), player));
        pieces.add(new Knight(new Coordinate(rowForPiecesByColor, 2), player));
        pieces.add(new Bishop(new Coordinate(rowForPiecesByColor, 3), player));
        pieces.add(new King(new Coordinate(rowForPiecesByColor, 4), player));
        pieces.add(new Queen(new Coordinate(rowForPiecesByColor, 3), player));
        pieces.add(new Bishop(new Coordinate(rowForPiecesByColor, 6), player));
        pieces.add(new Knight(new Coordinate(rowForPiecesByColor, 7), player));
        pieces.add(new Rook(new Coordinate(rowForPiecesByColor, 8), player));
        return pieces;
    }
}
