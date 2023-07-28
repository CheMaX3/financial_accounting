package org.chemax.spring_core_project.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "Поле имя не может быть пустым")
    @Size(min = 2, max = 30, message = "Имя должно быть не короче 2 и не длиннее 30 символов")
    @Column(name = "name")
    private String name;

    @Min(value = 0, message = "Возраст должен быть больше 0")
    @Column(name = "age")
    private int age;

    @NotEmpty(message = "Поле электронная почта не может быть пустым")
    @Email(message = "Электронная почта должна иметь формат: example@example.com")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Поле адрес не может быть пустым")
    @Pattern(regexp = "[А-Яа-я]+, [А-Яа-я]+, \\d{6}",
            message = "Адрес должен иметь следующий формат: Страна, Город, Почтовый индекс (6 цифр)")
    @Column(name = "address")
    private String address;

    public Person() {
    }

    public Person(String name, int age, String email, String address) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
