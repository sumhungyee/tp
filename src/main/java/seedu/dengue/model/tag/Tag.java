package seedu.dengue.model.tag;

import static java.util.Objects.requireNonNull;
import static seedu.dengue.commons.util.AppUtil.checkArgument;

/**
 * Represents a Tag in the Dengue Hotspot Tracker.
 * Guarantees: immutable; name is valid as declared in {@link #isValidTagName(String)}
 */
public class Tag {

    public static final String MESSAGE_CONSTRAINTS = "Tags should be one of the four dengue variants: "
            + "DENV1, DENV2, DENV3, or DENV4.";
    public final DengueVariant tagName;

    /**
     * Constructs a {@code Tag}.
     *
     * @param tagName A valid tag name.
     */
    public Tag(String tagName) {
        requireNonNull(tagName);
        checkArgument(isValidTagName(tagName), MESSAGE_CONSTRAINTS);
        this.tagName = DengueVariant.valueOf(tagName);
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidTagName(String test) {
        try {
            DengueVariant.valueOf(test);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Tag // instanceof handles nulls
                && tagName.equals(((Tag) other).tagName)); // state check
    }

    @Override
    public int hashCode() {
        return tagName.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + tagName.toString() + ']';
    }

}
