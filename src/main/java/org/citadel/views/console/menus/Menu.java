package org.citadel.views.console.menus;

import org.citadel.common.tools.Terminal;
import java.util.ArrayList;
import java.util.List;

public class Menu implements MenuComponent {

    private final String title;

    private final List<MenuComponent> components = new ArrayList<>();

    private List<MenuComponent> activeComponents = null;

    private Menu parent;

    public Menu(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void add(MenuComponent menuComponent) {
        components.add(menuComponent);
    }

    @Override
    public void execute() {
        activeComponents = getActiveComponents();
        if (!activeComponents.isEmpty()) {
            write();
            int option = getOption(activeComponents.size());
            activeComponents.get(option).execute();
        }
    }

    @Override
    public boolean isActive() {
        return !getActiveComponents().isEmpty();
    }

    private List<MenuComponent> getActiveComponents() {
        return components.stream().filter(MenuComponent::isActive).toList();
    }

    public void write() {
        Terminal.writeln("\n---------------------");
        Terminal.writeln(this.getTitle());
        Terminal.writeln("---------------------");
        for (int i = 0; i < activeComponents.size(); i++) {
            Terminal.writeln("[" + (i + 1) + "]" + activeComponents.get(i).getTitle());
        }
    }

    private int getOption(int max) {
        int option;
        do {
            option = Terminal.readInt("Opción: ");
        } while (option < 1 || option > max);
        return option - 1;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }
}
