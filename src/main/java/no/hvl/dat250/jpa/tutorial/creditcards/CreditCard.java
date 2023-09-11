package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private Integer Number;

    @Getter
    @Setter
    private Integer Balance;

    @Getter
    @Setter
    private Integer CreditLimit;

    @Getter
    @Setter
    @ManyToOne
    private Pincode Pincode;

    @Getter
    @Setter
    @ManyToOne
    private Bank OwningBank;
}
