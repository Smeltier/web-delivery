package br.com.delivery.domain.restaurant;

import br.com.delivery.domain.exception.InvalidMenuItemException;

final class MenuItem {
    private final MenuItemId id;
    private String name;
    private String description;
    private MenuItemCategory category;
    private boolean active;

    MenuItem(MenuItemId id, String name, String description, MenuItemCategory category) {
        if (id == null) {
            throw new InvalidMenuItemException("Menu Item ID cannot be null");
        }
        this.id = id;

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
        if (name == null || name.isBlank()) {
            throw new InvalidMenuItemException("Menu Item name cannot be null or blank");
        }
        this.name = name;
    }

    String getDescription() {
        return description;
    }

    void changeDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new InvalidMenuItemException("Menu Item description cannot be null or blank");
        }
        this.description = description;
    }

    MenuItemCategory getCategory() {
        return this.category;
    }

    void changeCategory(MenuItemCategory category) {
        if (category == null) {
            throw new InvalidMenuItemException("Menu item category cannot be null");
        }
        this.category = category;
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
