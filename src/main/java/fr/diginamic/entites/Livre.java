package fr.diginamic.entites;

import jakarta.persistence.*;

/**
 * Classe Livre
 */
@Entity
@Table(name = "LIVRE")
public class Livre {
    /**Attribut de classe**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Id du livre
     */
    private int id;

    @Column(name = "TITRE", nullable = false)
    /** Titre du livre**/
    private String titre;

    /** Auteur du Livre**/
    @Column(name = "AUTEUR", length = 50, nullable = false)
    private String auteur;



    /**Constructeur vide**/

    public Livre() {
    }

    /**
     * Constructeur avec Arguments
     * @param id
     * @param titre
     * @param auteur
     */
    public Livre(int id, String titre, String auteur) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
    }

    /**toString**/
    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Livre{");
        sb.append("id=").append(id);
        sb.append(", titre='").append(titre).append('\'');
        sb.append(", auteur='").append(auteur).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
