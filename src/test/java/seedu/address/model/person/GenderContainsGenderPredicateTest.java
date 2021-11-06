package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GENDER_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GENDER_BOB;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.TutorBuilder;

public class GenderContainsGenderPredicateTest {
    @Test
    public void equals() {
        List<Gender> firstGenderList = Collections.singletonList(new Gender(VALID_GENDER_AMY));
        List<Gender> secondGenderList = List.of(new Gender(VALID_GENDER_BOB));

        GenderContainsGenderPredicate firstPredicate = new GenderContainsGenderPredicate(firstGenderList);
        GenderContainsGenderPredicate secondPredicate = new GenderContainsGenderPredicate(secondGenderList);

        // same object -> returns true
        assertEquals(firstPredicate, firstPredicate);

        // same values -> returns true
        GenderContainsGenderPredicate firstPredicateCopy = new GenderContainsGenderPredicate(firstGenderList);
        assertEquals(firstPredicate, firstPredicateCopy);

        // different types -> returns false
        assertNotEquals(1, firstPredicate);

        // null -> returns false
        assertNotEquals(null, firstPredicate);

        // different person -> returns false
        assertNotEquals(firstPredicate, secondPredicate);
    }

    @Test
    public void test_tutorGenderContainsGender_returnsTrue() {
        // One Tag
        GenderContainsGenderPredicate predicate =
                new GenderContainsGenderPredicate(Collections.singletonList(new Gender(VALID_GENDER_AMY)));
        assertTrue(predicate.test(new TutorBuilder().withGender(VALID_GENDER_AMY).build()));
    }

    @Test
    public void test_tutorGenderDoesNotContainsGender_returnsFalse() {
        GenderContainsGenderPredicate predicate = new GenderContainsGenderPredicate(Collections.emptyList());
        assertFalse(predicate.test(new TutorBuilder().withGender(VALID_GENDER_AMY).build()));

        // Non-matching keyword
        predicate = new GenderContainsGenderPredicate(List.of(new Gender(VALID_GENDER_AMY)));
        assertFalse(predicate.test(new TutorBuilder().withGender(VALID_GENDER_BOB).build()));
    }
}
