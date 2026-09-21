import java.util.Scanner;

public class ZooManagement {

    int nbrCages = 20;
    String zooName = "my zoo";

    public static void main(String[] args) {

        // creation de l'objet zoo
        ZooManagement zoo = new ZooManagement();
        System.out.println("Le zoo " + zoo.zooName + " contient " + zoo.nbrCages + " cages.");

        // saisie utilisateur
        Scanner sc = new Scanner(System.in);

        System.out.print("Entrer le nom du zoo: ");
        String nom = sc.nextLine();

        // verification nom non vide
        if (nom.isEmpty()) {
            System.out.println("Erreur! Le nom ne peut pas etre vide.");
            System.out.print("Entrer le nom du zoo: ");
            nom = sc.nextLine();
        }
        zoo.zooName = nom;

        System.out.print("Entrer le nombre de cages: ");
        int cages = sc.nextInt();

        // verification nombre positif
        while (cages <= 0) {
            System.out.println("Erreur! Le nombre doit etre positif.");
            System.out.print("Entrer le nombre de cages: ");
            cages = sc.nextInt();
        }
        zoo.nbrCages = cages;

        // affichage apres modification
        System.out.println("Le zoo " + zoo.zooName + " contient " + zoo.nbrCages + " cages.");

        sc.close();
    }
}
