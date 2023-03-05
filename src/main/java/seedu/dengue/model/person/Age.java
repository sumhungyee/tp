package seedu.dengue.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.dengue.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's age in the Dengue Hotspot Tracker.
 * Guarantees: immutable; is valid as declared in {@link #isValidAge(String)}
 */
public class Age {

    public static final String MESSAGE_CONSTRAINTS = "Ages must be a number not more than 3 digits long"
            + " and smaller than 200.";

    /*
     * The first character of the age must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    //TODO
    public static final String VALIDATION_REGEX = "^[01]?\\d{1,2}$";

    public final String value;

    /**
     * Constructs an {@code Age}.
     * @param age A valid age.
     */
    public Age(String age) {
        requireNonNull(age);
        checkArgument(isValidAge(age), MESSAGE_CONSTRAINTS);
        value = String.valueOf(Integer.valueOf(age));
    }

    /**
     * Returns true if a given string is a valid date.
     */
    public static boolean isValidAge(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Age // instanceof handles nulls
                && value.equals(((Age) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
