package seedu.dengue.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

import seedu.dengue.model.Model;
import seedu.dengue.model.person.Person;

/**
 * Clears all persons in the current displayed list of the Dengue Hotspot Tracker.
 */
public class ClearCommand extends Command {
    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "%1$s persons cleared!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();
        List<Person> referenceCopy = new ArrayList<>(lastShownList);
        int listSize = lastShownList.size();
        for (Person person : referenceCopy) {
            model.deletePerson(person);
        }
        return new CommandResult(String.format(MESSAGE_SUCCESS, listSize));
    }
}
