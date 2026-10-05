package tn.esprit.gestionzoo.entities;

public class Zoo {
    // instruction 18 : attributs prives
    private Animal[] animals;
    private String name;
    private String city;
    private final int nbrCages = 25;   // constante (max 25 animaux)
    private int nbrAnimals;            // compteur des animaux ajoutes

    // Constructeur paramétré
    public Zoo(String name, String city) {
        setName(name);   // on passe par le setter pour verifier le nom
        this.city = city;
        this.animals = new Animal[nbrCages];
        this.nbrAnimals = 0;
    }

    // ===== Getters =====
    public Animal[] getAnimals() {
        return animals;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getNbrCages() {
        return nbrCages;
    }

    public int getNbrAnimals() {
        return nbrAnimals;
    }

    // ===== Setters =====
    // le nom d'un zoo ne doit pas etre vide
    public void setName(String name) {
        if (name == null || name.isEmpty())
            System.out.println("Erreur : le nom du zoo ne doit pas etre vide");
        else
            this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // pas de setter pour nbrCages (constante)
    // pas de setter pour animals et nbrAnimals : ils changent seulement
    // avec addAnimal() et removeAnimal()

    public void displayZoo() {
        System.out.println("Nom du zoo : " + name);
        System.out.println("Ville : " + city);
        System.out.println("Nombre de cages : " + nbrCages);
    }

    // instruction 17 : on utilise isZooFull() avant d'ajouter
    public boolean addAnimal(Animal animal) {
        if (isZooFull()) {
            System.out.println("Le zoo est plein, impossible d'ajouter " + animal.getName());
            return false;
        }
        if (searchAnimal(animal) != -1) {
            System.out.println(animal.getName() + " existe deja dans le zoo");
            return false;
        }
        animals[nbrAnimals] = animal;
        nbrAnimals++;
        return true;
    }

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

    // recherche par nom, retourne l'indice ou -1
    public int searchAnimal(Animal animal) {
        for (int i = 0; i < nbrAnimals; i++) {
            // name est prive dans Animal -> on utilise getName()
            if (animals[i].getName().equals(animal.getName())) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        int index = searchAnimal(animal);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < nbrAnimals - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[nbrAnimals - 1] = null;
        nbrAnimals--;
        return true;
    }

    public boolean isZooFull() {
        return nbrAnimals >= nbrCages;
    }

    // retourne le zoo qui a le plus d'animaux
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