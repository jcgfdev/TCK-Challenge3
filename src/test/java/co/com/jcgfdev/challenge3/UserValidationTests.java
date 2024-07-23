package co.com.jcgfdev.challenge3;

import co.com.jcgfdev.challenge3.model.User;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserValidationTests {

    private final Validator validator;

    public UserValidationTests() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    @Test
    public void whenNameIsNull_thenValidationFails() {
        User user = new User();
        user.setName(null);
        user.setEmail("test@example.com");
        user.setAge(25);

        var violations = validator.validate(user);
        assertFalse(violations.isEmpty());
    }
}
