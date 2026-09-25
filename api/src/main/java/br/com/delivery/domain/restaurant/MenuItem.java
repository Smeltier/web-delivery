package br.com.delivery.domain.restaurant;

// TODO: implementar classe monetária.

import java.util.Objects;

final class MenuItem {
    private final MenuItemId id;
    private String name;
    private String description;
    private MenuItemCategory category;
    private boolean active;

    MenuItem(MenuItemId id, String name, String description, MenuItemCategory category) {
        this.id = Objects.requireNonNull(id, "Menu Item id cannot be null");
        this.active = true;
        changeName(name);
        changeDescription(description);
        changeCategory(category);
    }

    MenuItemId getId() {
        return this.id;
    }

    String getName() {
        return this.name;
    }

    void changeName(String name) {
        this.name = Objects.requireNonNull(name, "Menu Item name cannot be null");

        if (name.isBlank()) {
            throw new IllegalArgumentException("Menu Item name cannot be blank");
        }
    }

    String getDescription() {
        return description;
    }

    void changeDescription(String description) {
        this.description = Objects.requireNonNull(description, "Menu Item description cannot be null");

        if (description.isBlank()) {
            throw new IllegalArgumentException("Menu Item description cannot be blank");
        }
    }

    MenuItemCategory getCategory() {
        return this.category;
    }

    void changeCategory(MenuItemCategory category) {
        this.category = Objects.requireNonNull(category, "MenuItem Category cannot be null");
    }

    boolean isActive() {
        return active;
    }

    void activate() {
        this.active = true;
    }

    void deactivate() {
        this.active = false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MenuItem)) return false;
        return id.equals(((MenuItem) obj).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
