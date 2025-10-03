package org.citadel.views.console.commands;

public abstract class Command {

    private final String title;

    protected Command(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract void execute();

}
