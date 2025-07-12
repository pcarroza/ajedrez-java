package org.citadel.models.pieces.rulesofmovements.commonmovementstrategy.utils;

public class ControlFlag {

    private boolean shouldStop;

    public ControlFlag() {
        this.shouldStop = false;
    }

    public void stop() {
        this.shouldStop = true;
    }

    public boolean shouldContinue() {
        return !shouldStop;
    }

    public void reset() {
        this.shouldStop = false;
    }
}