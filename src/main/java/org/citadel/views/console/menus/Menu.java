package org.citadel.views.console.menus;

import org.citadel.common.tools.Terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Menu extends MenuComponent {

    protected List<MenuComponent> components;

    public Menu(String title) {
        super(title);
        components = new ArrayList<>();
    }

    public void add(MenuComponent menuComponent) {
        components.add(menuComponent);
    }

    public void execute() {
        List<MenuComponent> activeComponents = getActiveComponents();
        if (activeComponents.isEmpty()) {
            Terminal.writeln("No hay opciones disponibles.");
            return;
        }
        write(activeComponents);
        int option = getOption(activeComponents.size());
        activeComponents.get(option).execute();
    }

    private List<MenuComponent> getActiveComponents() {
        return components.stream()
                .filter(MenuComponent::isActive)
                .collect(Collectors.toList());
    }

    private void write(List<MenuComponent> activeComponents) {
        Terminal.writeln("\n---------------------");
        Terminal.writeln(this.getTitle());
        Terminal.writeln("---------------------");
        for (int i = 0; i < activeComponents.size(); i++) {
            Terminal.writeln((i + 1) + ". " + activeComponents.get(i).getTitle());
        }
    }

    private int getOption(int max) {
        int option;
        do {
            option = Terminal.readInt("Opción");
        } while (option < 1 || option > max);
        return option - 1;
    }
}
