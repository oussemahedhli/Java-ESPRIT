package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;

public class Main {
    public static void main(String[] args) {
        Animal lion = new Animal("Felidae", "Lion", 8, true);
        Animal eagle = new Animal("Accipitridae", "Eagle", 5, false);
        Animal tiger = new Animal("Felidae", "Tiger", 6, true);
        Animal elephant = new Animal("Elephantidae", "Elephant", 20, true);

        Zoo myZoo = new Zoo("ESPRIT Zoo", "Tunis");
        myZoo.displayZoo();
        System.out.println("---");

        // ajout
        System.out.println("Ajout Lion : " + myZoo.addAnimal(lion));
        System.out.println("Ajout Eagle : " + myZoo.addAnimal(eagle));
        System.out.println("Ajout Tiger : " + myZoo.addAnimal(tiger));
        System.out.println("Ajout Elephant : " + myZoo.addAnimal(elephant));

        // affichage et recherche
        myZoo.displayAnimals();
        System.out.println("Indice de Lion : " + myZoo.searchAnimal(lion));
        Animal lion2 = new Animal("Felidae", "Lion", 8, true);
        System.out.println("Indice de lion2 : " + myZoo.searchAnimal(lion2));

        // unicite
        System.out.println("Ajout lion2 : " + myZoo.addAnimal(lion2));
        System.out.println("---");

        // suppression
        System.out.println("Suppression Eagle : " + myZoo.removeAnimal(eagle));
        Animal zebra = new Animal("Equidae", "Zebra", 4, true);
        System.out.println("Suppression Zebra (pas dans le zoo) : " + myZoo.removeAnimal(zebra));
        myZoo.displayAnimals();
        System.out.println("---");

        // ===== Instruction 17 : depasser la capacite =====
        Zoo petitZoo = new Zoo("Belvedere", "Tunis");
        for (int i = 1; i <= 27; i++) {
            Animal a = new Animal("Famille" + i, "Animal" + i, i, true);
            boolean ok = petitZoo.addAnimal(a);
            if (!ok) {
                System.out.println("Ajout de Animal" + i + " echoue");
            }
        }
        System.out.println("Belvedere plein ? " + petitZoo.isZooFull());
        System.out.println("ESPRIT Zoo plein ? " + myZoo.isZooFull());
        System.out.println("---");

        // comparaison
        Zoo zooVide = new Zoo("Friguia", "Sousse");
        Zoo plusGrand = Zoo.comparerZoo(myZoo, petitZoo);
        // plusGrand.name -> erreur car name est prive -> on utilise getName()
        System.out.println("Le zoo avec le plus d'animaux : " + plusGrand.getName());
        System.out.println("Entre ESPRIT Zoo et Friguia : " + Zoo.comparerZoo(myZoo, zooVide).getName());
        System.out.println("---");

        // ===== Instruction 18 : tests de l'encapsulation =====
        // lion.age = -3;  -> erreur de compilation : age est private

        // age negatif dans le constructeur
        Animal chat = new Animal("Felidae", "Chat", -2, true);
        System.out.println(chat);   // age reste 0

        // age negatif avec le setter
        lion.setAge(-5);
        System.out.println("Age du lion : " + lion.getAge());   // reste 8

        // nom de zoo vide
        Zoo zooSansNom = new Zoo("", "Bizerte");
        myZoo.setName("");
        System.out.println("Nom de myZoo : " + myZoo.getName());   // reste "ESPRIT Zoo"
        System.out.println("---");

        System.out.println(myZoo);
        System.out.println(lion);
    }
}