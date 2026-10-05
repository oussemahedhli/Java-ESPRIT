package tn.esprit.gestionzoo.entities;

public class Animal {
    // instruction 18 : attributs prives
    private String family;
    private String name;
    private int age;
    private boolean isMammal;

    // Constructeur paramétré
    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        setAge(age);   // on passe par le setter pour verifier l'age
        this.isMammal = isMammal;
    }

    // ===== Getters =====
    public String getFamily() {
        return family;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // pour un boolean on utilise "is" au lieu de "get"
    public boolean isMammal() {
        return isMammal;
    }

    // ===== Setters =====
    public void setFamily(String family) {
        this.family = family;
    }

    public void setName(String name) {
        this.name = name;
    }

    // un animal ne peut pas avoir un age negatif
    public void setAge(int age) {
        if (age < 0)
            System.out.println("Erreur : l'age ne peut pas etre negatif");
        else
            this.age = age;
    }

    public void setMammal(boolean isMammal) {
        this.isMammal = isMammal;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "family='" + family + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isMammal=" + isMammal +
                '}';
    }
}