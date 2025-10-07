package org.citadel.views.console.menus;

import java.util.Stack;

public class MenuContext {

    private final Stack<Menu> menuStack = new Stack<>();
    
    private boolean exit = false;

    public MenuContext() {
    }

    public void start(Menu initialMenu) {
        this.menuStack.clear();
        this.menuStack.push(initialMenu);
    }

    public void execute() {
        if (!menuStack.isEmpty()) {
            getCurrentMenu().execute();
        }
    }

    public Menu getCurrentMenu() {
        if (menuStack.isEmpty()) {
            return null;
        }
        return menuStack.peek();
    }

    public void navigateTo(Menu menu) {
        this.menuStack.push(menu);
    }

    public void back() {
        if (menuStack.size() > 1) {
            this.menuStack.pop();
        }
    }

    public boolean isExited() {
        return exit;
    }

    public void exit() {
        this.exit = true;
    }
}
