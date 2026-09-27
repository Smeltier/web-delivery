package br.com.delivery.domain.restaurant;

import java.util.ArrayList;
import java.util.List;

import br.com.delivery.domain.exception.InvalidRestaurantException;

public final class Restaurant {
    private final RestaurantId id;
    private final List<MenuItem> menuItems;
    private String name;
    private String description;
    private BusinessHours businessHours;
    private RestaurantStatus status;

    public Restaurant(RestaurantId id, String name, String description, BusinessHours businessHours) {
        if (id == null) {
            throw new InvalidRestaurantException("Restaurant id cannot be null");
        }
        this.id = id;

        this.menuItems = new ArrayList<>();
        this.status = RestaurantStatus.CLOSED;

        changeName(name);
        changeDescription(description);
        changeBusinessHours(businessHours);
    }

    public MenuItemId addMenuItem(String name, String description, MenuItemCategory category) {
        if (status == RestaurantStatus.OPEN) {
            throw new InvalidRestaurantException("Cannot add new Menu Item while open");
        }

        MenuItem item = new MenuItem(MenuItemId.generate(), name, description, category);
        this.menuItems.add(item);
        return item.getId();
    }

    public void deactivateMenuItem(MenuItemId menuItemId) {
        if (menuItemId == null) {
            throw new InvalidRestaurantException("Menu item ID cannot be null");
        }

        MenuItem menuItem = this.menuItems.stream()
                .filter(item -> item.getId().equals(menuItemId))
                .findFirst()
                .orElseThrow(() -> new InvalidRestaurantException("Menu item not found"));

        menuItem.deactivate();
    }

    public void removeMenuItem(MenuItemId menuItemId) {
        if (menuItemId == null) {
            throw new InvalidRestaurantException("Menu item id cannot be null");
        }

        if (status == RestaurantStatus.OPEN) {
            throw new InvalidRestaurantException("Cannot remove new Menu Item while open");
        }

        this.menuItems.removeIf(item -> item.getId().equals(menuItemId));
    }

    public void changeDescription(String description) {
        if (description == null || description.isBlank()) {
            throw new InvalidRestaurantException("Restaurant description cannot be null or blank");
        }
        this.description = description;
    }

    public void changeBusinessHours(BusinessHours businessHours) {
        if (businessHours == null) {
            throw new InvalidRestaurantException("Business Hours cannot be null");
        }
        this.businessHours = businessHours;
    }

    public void changeName(String name) {
        if (name == null || name.isBlank()) {
            throw new InvalidRestaurantException("Restaurant name cannot be null or blank");
        }
        this.name = name;
    }

    public void open() {
    }

    public boolean isOpen() {
        return this.status == RestaurantStatus.OPEN;
    }

    public boolean isClosed() {
        return !this.isOpen();
    }

    public RestaurantId getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public BusinessHours getBusinessHours() {
        return this.businessHours;
    }
}
