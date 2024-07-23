package co.com.jcgfdev.challenge3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "nombre no puede ir vacio")
    private String name;

    @Email(message = "el email debe ser valido")
    @NotBlank(message = "email no puede ser vacio")
    private String email;

    @Min(value = 18, message = "no puede ser menor de 18")
    @Max(value = 99, message = "no puede ser mayor de 99")
    private int age;

    public Long id() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String name() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String email() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public int age() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }
}
