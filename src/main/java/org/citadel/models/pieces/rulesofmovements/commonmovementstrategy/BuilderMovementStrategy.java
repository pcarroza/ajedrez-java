package org.citadel.models.pieces.rulesofmovements.commonmovementstrategy;

import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class BuilderMovementStrategy {

    private BuilderMovementStrategy() {
    }

    public static List<Coordinate> buildRookMovements(Piece piece) {
        assert piece != null;
        List<MovementStrategy> strategies = new ArrayList<>();
        strategies.add(new VerticalMovementStrategy(piece));
        strategies.add(new HorizontalMovementStrategy(piece));
        return strategies.stream().flatMap(MovementStrategy::generate).toList();
    }

    public static List<Coordinate> buildBishopMovements(Piece piece) {
        assert piece != null;
        List<MovementStrategy> strategies = new ArrayList<>();
        strategies.add(new InverseMovementStrategy(piece));
        strategies.add(new DiagonalMovementStrategy(piece));
        return strategies.stream().flatMap(MovementStrategy::generate).toList();
    }

    public static List<Coordinate> buildQueenMovements(Piece piece) {
        assert piece != null;
        List<MovementStrategy> strategies = new ArrayList<>();
        strategies.add(new InverseMovementStrategy(piece));
        strategies.add(new DiagonalMovementStrategy(piece));
        strategies.add(new VerticalMovementStrategy(piece));
        strategies.add(new HorizontalMovementStrategy(piece));
        return strategies.stream().flatMap(MovementStrategy::generate).toList();
    }
}
