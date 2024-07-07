package Wafacash.model;


import Wafacash.enums.TransfertType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "transfert")
public class Transfert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transfert")
    private int idTransfert;

    @Column(name = "montant" , nullable = false)
    private double montant;

    @Column(name = "description", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    private TransfertType transfertType;

    @Column(name = "dateTransfert", nullable = false)
    private String dateTransfert;


    @ManyToOne
    @JoinColumn(name = "id_compteSource")
    private Compte compteSource;

    @ManyToOne
    @JoinColumn(name = "id_compteDestination")
    private Compte compteDestination;


    @ManyToOne
    @JoinColumn(name = "id_beneficiaire")
    private Beneficiaire beneficiaire;
}
