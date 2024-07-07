package Wafacash.model;

import Wafacash.enums.CarteStatus;
import Wafacash.enums.CarteType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "carte")
public class Carte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carte")
    private int idCarte;

    @Column(name = "numeroCarte", nullable = false)
    private String numeroCarte;

    @Column(name = "dateExpiration", nullable = false)
    private String dateExpiration;

    @Enumerated(EnumType.STRING)
    private CarteType carteType;

    @Enumerated(EnumType.STRING)
    private CarteStatus carteStatus;

    @ManyToOne
    @JoinColumn(name = "id_compte")
    private Compte compte;
}
