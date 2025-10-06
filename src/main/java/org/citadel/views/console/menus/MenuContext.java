package org.citadel.views.console.menus;

public class MenuContext {

    private Menu currentMenu;

    public void execute() {
        currentMenu.execute();
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }
}
