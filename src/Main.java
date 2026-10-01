public class Main {
    public static void main(String[] args) {
        // Création d'animaux via constructeur paramétré
        Animal lion = new Animal("Felidae", "Lion", 8, true);
        Animal eagle = new Animal("Accipitridae", "Eagle", 5, false);
        Animal tiger = new Animal("Felidae", "Tiger", 6, true);
        Animal elephant = new Animal("Elephantidae", "Elephant", 20, true);

        // Création du zoo (plus besoin de donner le nombre de cages)
        Zoo myZoo = new Zoo("ESPRIT Zoo", "Tunis");

        myZoo.displayZoo();
        System.out.println("---");

        // ===== Instruction 10 : ajout =====
        System.out.println("Ajout Lion : " + myZoo.addAnimal(lion));
        System.out.println("Ajout Eagle : " + myZoo.addAnimal(eagle));
        System.out.println("Ajout Tiger : " + myZoo.addAnimal(tiger));
        System.out.println("Ajout Elephant : " + myZoo.addAnimal(elephant));

        // ===== Instruction 11 : affichage et recherche =====
        myZoo.displayAnimals();
        System.out.println("Indice de Lion : " + myZoo.searchAnimal(lion));

        // un autre lion avec les memes infos
        Animal lion2 = new Animal("Felidae", "Lion", 8, true);
        System.out.println("Indice de lion2 : " + myZoo.searchAnimal(lion2));
        // -> on trouve 0 aussi, car la recherche se fait par le nom
        //    meme si lion et lion2 sont deux objets differents en memoire

        // ===== Instruction 12 : unicite =====
        System.out.println("Ajout lion2 : " + myZoo.addAnimal(lion2));

        System.out.println("---");

        // ===== Instruction 13 : suppression =====
        System.out.println("Suppression Eagle : " + myZoo.removeAnimal(eagle));
        Animal zebra = new Animal("Equidae", "Zebra", 4, true);
        System.out.println("Suppression Zebra (pas dans le zoo) : " + myZoo.removeAnimal(zebra));
        myZoo.displayAnimals();

        System.out.println("---");

        // ===== Instruction 10 / 12 / 15 : depasser la capacite =====
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

        // ===== Instruction 15 : comparaison =====
        Zoo zooVide = new Zoo("Friguia", "Sousse");
        Zoo plusGrand = Zoo.comparerZoo(myZoo, petitZoo);
        System.out.println("Le zoo avec le plus d'animaux : " + plusGrand.name);
        System.out.println("Entre ESPRIT Zoo et Friguia : " + Zoo.comparerZoo(myZoo, zooVide).name);

        System.out.println("---");

        // toString()
        System.out.println(myZoo);
        System.out.println(lion);
    }
}