package org.citadel.views.console.menus;

public class MenuContext {

    private Menu currentMenu;

    public MenuContext(Menu initialMenu) {
        this.currentMenu = initialMenu;
    }

    public void execute() {
        this.currentMenu.execute();
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void showCurrentMenu() {
        if (currentMenu != null) {
            currentMenu.write();
        }
    }
}
