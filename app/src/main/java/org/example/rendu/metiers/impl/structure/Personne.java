package org.example.rendu.metiers.impl.structure;

public class Personne {
    private final String nom;
    private final int age;
    private final double salaire;

    public Personne(String nom, int age, double salaire) {
        this.nom = nom;
        this.age = age;
        this.salaire = salaire;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public double getSalaire() {
        return salaire;
    }

    @Override
    public String toString() {
        return String.format("(%s , %d, %.2f)", nom, age, salaire);
    }
}
