import org.citadel.common.tools.Terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Menu implements MenuComponent {

    private final String title;

    private final List<MenuComponent> components = new ArrayList<>();

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
        List<MenuComponent> activeComponents = getActiveComponents();
        if (!activeComponents.isEmpty()) {
            write(activeComponents);
            int option = getOption(activeComponents.size());
        }
    }

    @Override
    public boolean isActive() {
        return !getActiveComponents().isEmpty();
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
            Terminal.writeln("[" + (i + 1) + "]" + activeComponents.get(i).getTitle());
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
