package fr.diginamic.entites;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Classe des emprunts
 * Mappée avec la table EMPRUNT de la BDD bibliothèque
 */
@Entity
@Table(name = "EMPRUNT")
public class Emprunt implements Serializable {

    /**Attribut de classe**/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    /** Id du l'emprunt **/
    private Integer id;

    /**timeStamp du début d'emprunt**/
    @Column(name = "DATE_DEBUT", nullable = false)
    private LocalDateTime dateDebut;

    /**Durée de l'emprunt**/
    @Column(name = "DELAI", nullable = false)
    private Integer delai;

    /**timeStamp du fin d'emprunt**/
    @Column(name = "DATE_FIN", nullable = false)
    private LocalDateTime dateFin;


    /** lien avec le client**/
    @ManyToOne
            @JoinColumn(name = "ID_CLIENT")
    private Client client;

    /** lien vers livre pour alimenter la compo**/
    @ManyToMany
    @JoinTable(name="compo",
        joinColumns = @JoinColumn(name="ID_LIV", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID")
    )
    private Set<Livre> livres;

    /**
     * Getter
     *
     * @return livres
     */
    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }

    /**Constructeur**/

    public Emprunt() {
    }

    //Getters et Setters

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
     * @return dateDebut
     */
    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * Getter
     *
     * @return delai
     */
    public Integer getDelai() {
        return delai;
    }

    public void setDelai(Integer delai) {
        this.delai = delai;
    }

    /**
     * Getter
     *
     * @return dateFin
     */
    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * Getter
     *
     * @return client
     */
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override public String toString() {
        final StringBuilder sb = new StringBuilder("Emprunt{");
        sb.append("id=").append(id);
        sb.append(", dateDebut=").append(dateDebut);
        sb.append(", delai=").append(delai);
        sb.append(", dateFin=").append(dateFin);
        sb.append('}');
        return sb.toString();
    }
}
