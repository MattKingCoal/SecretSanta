package com.match.games.ss.model;

public class User {

    private String name;
    private String email;
    private User secretSantaFor;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String toString() {
        return String.format("User [name=%s, email=%s, secretSantaFor: %s]", name, email,
                (secretSantaFor == null) ? "not assigned" : secretSantaFor.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getSecretSanta() {
        return secretSantaFor;
    }

    public void setSecretSanta(User secretSantaFor) {
        this.secretSantaFor = secretSantaFor;
    }
}
