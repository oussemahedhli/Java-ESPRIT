public class Zoo {
    Animal[] animals;
    String name;
    String city;
    final int nbrCages = 25;   // instruction 14 : constante (max 25 animaux)
    int nbrAnimals;            // compteur des animaux ajoutes

    // Constructeur paramétré (nbrCages n'est plus passe en parametre car c'est une constante)
    public Zoo(String name, String city) {
        this.name = name;
        this.city = city;
        this.animals = new Animal[nbrCages];
        this.nbrAnimals = 0;
    }

    public void displayZoo() {
        System.out.println("Nom du zoo : " + name);
        System.out.println("Ville : " + city);
        System.out.println("Nombre de cages : " + nbrCages);
    }

    // instruction 10 + 12 : ajout d'un animal
    public boolean addAnimal(Animal animal) {
        // zoo plein
        if (isZooFull()) {
            System.out.println("Le zoo est plein, impossible d'ajouter " + animal.name);
            return false;
        }
        // animal deja present
        if (searchAnimal(animal) != -1) {
            System.out.println(animal.name + " existe deja dans le zoo");
            return false;
        }
        animals[nbrAnimals] = animal;
        nbrAnimals++;
        return true;
    }

    // instruction 11 : affichage des animaux
    public void displayAnimals() {
        if (nbrAnimals == 0) {
            System.out.println("Aucun animal dans le zoo");
            return;
        }
        System.out.println("Liste des animaux du zoo " + name + " :");
        for (int i = 0; i < nbrAnimals; i++) {
            System.out.println((i + 1) + ") " + animals[i]);
        }
    }

    // instruction 11 : recherche par nom, retourne l'indice ou -1
    public int searchAnimal(Animal animal) {
        for (int i = 0; i < nbrAnimals; i++) {
            if (animals[i].name.equals(animal.name)) {
                return i;
            }
        }
        return -1;
    }

    // instruction 13 : suppression d'un animal
    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            return false;
        }
        // on decale les animaux qui sont apres vers la gauche
        for (int i = index; i < nbrAnimals - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[nbrAnimals - 1] = null;
        nbrAnimals--;
        return true;
    }

    // instruction 15 : verifier si le zoo est plein
    public boolean isZooFull() {
        return nbrAnimals >= nbrCages;
    }

    // instruction 15 : retourne le zoo qui a le plus d'animaux
    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1.nbrAnimals >= z2.nbrAnimals) {
            return z1;
        }
        return z2;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", nbrCages=" + nbrCages +
                ", nbrAnimals=" + nbrAnimals +
                '}';
    }
}