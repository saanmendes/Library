package com.library.controllers.dtos;

import jakarta.validation.constraints.NotNull;

public class AuthorDTO {

    private Long id;

    @NotNull(message = "O nome do autor é obrigatório.")
    private String name;

    @NotNull(message = "O sobrenome do autor é obrigatório.")
    private String lastName;

    private int yearOfBirth;
    private int yearOfDeath;


    public AuthorDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "O nome do autor é obrigatório.") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "O nome do autor é obrigatório.") String name) {
        this.name = name;
    }

    public @NotNull(message = "O sobrenome do autor é obrigatório.") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull(message = "O sobrenome do autor é obrigatório.") String lastName) {
        this.lastName = lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getYearOfDeath() {
        return yearOfDeath;
    }

    public void setYearOfDeath(int yearOfDeath) {
        this.yearOfDeath = yearOfDeath;
    }
}

