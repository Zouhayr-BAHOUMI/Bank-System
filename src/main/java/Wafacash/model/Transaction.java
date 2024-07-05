package Wafacash.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private int idTransaction;

    @Column(name = "dateTransaction", nullable = false)
    private  String dateTransaction;

    @Column(name = "montant", nullable = false)
    private double montant;

    @Column(name = "typeTransaction", nullable = false)
    private String typeTransaction;

    @Column(name = "description", nullable = false)
    private String description;


    @ManyToOne
    @JoinColumn(name = "id_compte")
    private Compte compte;
}
