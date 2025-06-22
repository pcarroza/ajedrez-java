package org.citadel.common.validators;

public record ClosedInterval<T extends Number & Comparable<T>>(T min, T max) {

    public ClosedInterval {
        assert min.compareTo(max) < 0;
    }

    public boolean isIncluded(T value) {
        return min.compareTo(value) <= 0 && value.compareTo(max) <= 0;
    }

    public boolean isEqualToMin(T value) {
        return min.compareTo(value) == 0;
    }

    public boolean isEqualToMax(T value) {
        return max.compareTo(value) == 0;
    }

    @Override
    public String toString() {
        return "[" + min() + ", " + max() + "]";
    }
}
