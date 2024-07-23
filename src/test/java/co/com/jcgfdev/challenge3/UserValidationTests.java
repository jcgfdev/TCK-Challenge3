package co.com.jcgfdev.challenge3;

import co.com.jcgfdev.challenge3.model.User;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserValidationTests {

    private static Validator validator;

    @BeforeAll
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void whenNameIsNull_thenValidationFails() {
        User user = new User();
        user.setName(null);
        user.setEmail("pepito@correo.com");
        user.setAge(25);

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void whenNameIsEmpty_thenValidationFails() {
        User user = new User();
        user.setName("");
        user.setEmail("pepito@correo.com");
        user.setAge(25);

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void whenEmailIsNull_thenValidationFails() {
        User user = new User();
        user.setName("pepito");
        user.setEmail(null);
        user.setAge(25);

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void whenEmailIsEmpty_thenValidationFails() {
        User user = new User();
        user.setName("pepito");
        user.setEmail("");
        user.setAge(25);

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void whenEmailIsInvalid_thenValidationFails() {
        User user = new User();
        user.setName("pepito");
        user.setEmail("pepito-correo-com");
        user.setAge(25);

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void whenAgeIsLessThan18_thenValidationFails() {
        User user = new User();
        user.setName("pepito");
        user.setEmail("pepito@correo.com");
        user.setAge(17);

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void whenAgeIsGreaterThan99_thenValidationFails() {
        User user = new User();
        user.setName("pepito");
        user.setEmail("pepito@correo.com");
        user.setAge(100);

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());
    }

    @Test
    public void whenAllFieldsAreValid_thenValidationSucceeds() {
        User user = new User();
        user.setName("pepito");
        user.setEmail("pepito@correo.com");
        user.setAge(25);

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertTrue(violations.isEmpty());
    }
}

