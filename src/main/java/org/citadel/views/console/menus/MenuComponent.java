package org.citadel.views.console.menus;

public interface MenuComponent {
    String getTitle();

    void execute();

    boolean isActive();
}
