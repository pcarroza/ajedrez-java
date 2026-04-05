package org.citadel.models.modules.game.pieces.enums;

import java.util.function.BiFunction;
import java.util.Arrays;

import org.citadel.models.modules.game.pieces.Bishop;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Knight;
import org.citadel.models.modules.game.pieces.Piece;
import org.citadel.models.modules.game.pieces.Queen;
import org.citadel.models.modules.game.pieces.Rook;

public enum PromotionType {
    T(Rook::new),
    C(Knight::new),
    B(Bishop::new),
    Q(Queen::new);

    private final BiFunction<Coordinate, Player, Piece> factory;

    PromotionType(BiFunction<Coordinate, Player, Piece> factory) {
        this.factory = factory;
    }

    public Piece createPromotedPiece(Coordinate coordinate, Player player) {
        return factory.apply(coordinate, player);
    }

    public static PromotionType fromString(String key) {
        return Arrays.stream(values())
                .filter(it -> it.name().equals(key.toUpperCase()))
                .findFirst()
                .orElse(Q);
    }
}