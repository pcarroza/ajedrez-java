package org.citadel.views.console.commands;

public interface Command {
    void execute();

    default boolean isActive() {
        return true;
    }
}
