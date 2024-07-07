package Wafacash.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "compte")
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_compte")
    private int idCompte;

    @Column(name = "typeCompte", nullable = false)
    private String typeCompte;

    @Column(name = "soldeInitial", nullable = false)
    private double soldeInitial;

    @Column(name = "dateCreation", nullable = false)
    private String dateCreation;

    @Column(name = "isClosed")
    private boolean isClosed = false;


    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonIgnoreProperties("comptes")
    private User user;

    @OneToMany(mappedBy = "compte", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "compte", cascade = CascadeType.ALL)
    private List<Carte> cartes;
}
