package fr.diginamic.entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe des clients
 * Mapping effectué sur la table éponyme de la bdd bibliotheque
 */
@Entity
@Table(name ="client")
public class Client implements Serializable {

    /**Id du client**/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    /** Nom du client**/
    @Column(name="NOM", length =50, nullable = false)
    private String nom;

    /** Prénom du client**/
    @Column(name="PRENOM", length =50, nullable = false)
    private String prenom;

    /**Liste d'emprunt réalisé par un client**/
    @OneToMany(mappedBy = "client")
    private Set<Emprunt> emprunt;

    /**
     * Constructeur Vide de paramètres
     * qui charge la liste des emprunts d'un client
     */
    public Client() {
        emprunt = new HashSet<Emprunt>();
    }

    /**
     * Getter
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter
     *
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter
     *
     * @return prenom
     */
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", emprunt=").append(emprunt);
        sb.append('}');
        return sb.toString();
    }
}
