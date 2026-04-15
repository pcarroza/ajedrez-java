package org.citadel.models.context.pieces.king.support.builders;

import org.citadel.models.context.pieces.king.stubs.BoardKingStub;

public class BoardKingStubBuilder {

    private final BoardKingStub stub = new BoardKingStub();

    public static BoardKingStubBuilder aBoard() {
        return new BoardKingStubBuilder();
    }

    public BoardKingStubBuilder withKingInCheck() {
        stub.withKingInCheck(true);
        return this;
    }

    public BoardKingStubBuilder withKingNotInCheck() {
        stub.withKingInCheck(false);
        return this;
    }

    public BoardKingStubBuilder withRookAt(String square) {
        stub.withRookAvailable(square, true);
        return this;
    }

    public BoardKingStubBuilder withoutRookAt(String square) {
        stub.withRookAvailable(square, false);
        return this;
    }

    public BoardKingStubBuilder withEmptySquare(String square) {
        stub.withSquareOccupied(square, false);
        return this;
    }

    public BoardKingStubBuilder withOccupiedSquare(String square) {
        stub.withSquareOccupied(square, true);
        return this;
    }

    public BoardKingStubBuilder withSafeSquare(String square) {
        stub.withSquareAttacked(square, false);
        return this;
    }

    public BoardKingStubBuilder withAttackedSquare(String square) {
        stub.withSquareAttacked(square, true);
        return this;
    }

    public BoardKingStub build() {
        return stub;
    }
}