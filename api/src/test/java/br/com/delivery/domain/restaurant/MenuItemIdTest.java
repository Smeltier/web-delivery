package br.com.delivery.domain.restaurant;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuItemIdTest {
    @Test
    void shouldCreateWithValidUUID() {
        var uuid = UUID.randomUUID();
        var id = new MenuItemId(uuid);
        assertEquals(uuid, id.value());
    }

    @Test
    void shouldThrowExceptionWhenUUIDIsNull() {
        assertThrows(NullPointerException.class, () -> new MenuItemId(null));
    }

    @Test
    void generateShouldReturnNonNullValue() {
        var id = MenuItemId.generate();
        assertNotNull(id);
        assertNotNull(id.value());
    }

    @Test
    void generateShouldCreateDifferentIds() {
        var id1 = MenuItemId.generate();
        var id2 = MenuItemId.generate();
        assertNotEquals(id1, id2);
    }

    @Test
    void shouldBeEqualWithSameUUIDValues() {
        var uuid = UUID.randomUUID();
        var id1 = new MenuItemId(uuid);
        var id2 = new MenuItemId(uuid);
        assertEquals(id1, id2);
    }
}
