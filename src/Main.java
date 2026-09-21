public class Main {
    public static void main(String[] args) {
        // Création d'animaux via constructeur paramétré
        Animal lion = new Animal("Felidae", "Lion", 8, true);
        Animal eagle = new Animal("Accipitridae", "Eagle", 5, false);


        // Création du zoo
        Zoo myZoo = new Zoo("ESPRIT Zoo", "Tunis", 30);
        myZoo.animals[0] = lion;
        myZoo.animals[1] = eagle;


        // displayZoo()
        myZoo.displayZoo();

        System.out.println("---");

        // toString() — affiche les infos directement
        System.out.println(myZoo);
        System.out.println(lion);
        System.out.println(eagle);

    }
}