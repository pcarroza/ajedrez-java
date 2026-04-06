package org.citadel.models.support;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

public class Assertions {

    private final List<String> actual;

    Assertions(List<String> actual) {
        this.actual = actual;
    }

    public Assertions shouldReach(String... squares) {
        for (String expected : squares) {
            assertTrue("Expected move missing: " + expected, actual.contains(expected));
        }
        return this;
    }

    public Assertions shouldNotReach(String... squares) {
        for (String blocked : squares) {
            assertFalse("Move should be blocked but was found: " + blocked, actual.contains(blocked));
        }
        return this;
    }

    public Assertions shouldReachExactly(int expectedCount) {
        assertEquals(
                "Expected " + expectedCount + " moves but got " + actual.size() + ": " + actual,
                expectedCount,
                actual.size());
        return this;
    }
}
