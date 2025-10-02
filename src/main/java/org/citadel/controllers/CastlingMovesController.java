package org.citadel.controllers;

import org.citadel.models.pieces.Coordinate;

import java.util.List;

public interface CastlingMovesController extends SpecialMovementsController {

    List<Coordinate> getAvailableRooks();

    void castle(Coordinate rookCoordinate);
}

