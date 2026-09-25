package br.com.delivery.domain.restaurant;

import br.com.delivery.domain.exception.InvalidMenuItemException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuItemTest {
    private final MenuItemId ID = MenuItemId.generate();
    private final String NAME = "name";
    private final String DESCRIPTION = "description";
    private final MenuItemCategory CATEGORY = MenuItemCategory.DESSERT;

    @Test
    void shouldCreateValidMenuItem() {
        var item = new MenuItem(ID, NAME, DESCRIPTION, CATEGORY);
        assertEquals(ID, item.getId());
        assertEquals(NAME, item.getName());
        assertEquals(DESCRIPTION, item.getDescription());
        assertEquals(CATEGORY, item.getCategory());
    }

    @Test
    void shouldThrowWhenIdIsNull() {
        assertThrows(InvalidMenuItemException.class,
                () -> new MenuItem(null, NAME, DESCRIPTION, CATEGORY));
    }

    @Test
    void shouldThrowWhenNameIsNull() {
        assertThrows(InvalidMenuItemException.class,
                () -> new MenuItem(ID, null, DESCRIPTION, CATEGORY));
    }

    @Test
    void shouldThrowWhenNameIsBlank() {
        assertThrows(InvalidMenuItemException.class,
                () -> new MenuItem(ID, "", DESCRIPTION, CATEGORY));
    }

    @Test
    void shouldThrowWhenDescriptionIsNull() {
        assertThrows(InvalidMenuItemException.class,
                () -> new MenuItem(ID, NAME, null, CATEGORY));
    }

    @Test
    void shouldThrowWhenDescriptionIsBlank() {
        assertThrows(InvalidMenuItemException.class,
                () -> new MenuItem(ID, NAME, "", CATEGORY));
    }

    @Test
    void shouldThrowWhenCategoryIsNull() {
        assertThrows(InvalidMenuItemException.class,
                () -> new MenuItem(ID, NAME, DESCRIPTION, null));
    }

    @Test
    void shouldBeSameMenuItemWhenIdIsEqual() {
        var firstMenuItem = new MenuItem(ID, NAME, DESCRIPTION, CATEGORY);
        var secondMenuItem = new MenuItem(ID, NAME, DESCRIPTION, CATEGORY);
        assertEquals(firstMenuItem, secondMenuItem);
    }
}
