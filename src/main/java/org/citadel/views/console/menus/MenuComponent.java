package org.citadel.views.console.menus;

public abstract class MenuComponent {

    protected String title;

    public MenuComponent(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract void execute();

    public boolean isActive() {
        return true;
    }
}
