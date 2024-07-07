package Wafacash.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "beneficiaire")
public class Beneficiaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_beneficiaire")
    private int idBeneficiaire;

    @Column(name = "fullname", nullable = false)
    private String fullname;

    @Column(name = "rib", nullable = false)
    private String rib;

    @Column(name = "banqueName", nullable = false)
    private String banqueName;

    @OneToMany(mappedBy = "beneficiaire", cascade = CascadeType.ALL)
    private List<Transfert> transferts;
}
