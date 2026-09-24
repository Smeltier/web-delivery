package br.com.delivery.domain.restaurant;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RestaurantIdTest {
    @Test
    void shouldCreateWithValidUUID() {
        var uuid = UUID.randomUUID();
        var id = new RestaurantId(uuid);
        assertEquals(uuid, id.value());
    }

    @Test
    void shouldThrowExceptionWhenUUIDIsNull() {
        assertThrows(NullPointerException.class, () -> new RestaurantId(null));
    }

    @Test
    void generateShouldReturnNonNullValue() {
        var id = RestaurantId.generate();
        assertNotNull(id);
        assertNotNull(id.value());
    }

    @Test
    void generateShouldCreateDifferentIds() {
        var id1 = RestaurantId.generate();
        var id2 = RestaurantId.generate();
        assertNotEquals(id1, id2);
    }

    @Test
    void shouldBeEqualWithSameUUIDValues() {
        var uuid = UUID.randomUUID();
        var id1 = new RestaurantId(uuid);
        var id2 = new RestaurantId(uuid);
        assertEquals(id1, id2);
    }
}
