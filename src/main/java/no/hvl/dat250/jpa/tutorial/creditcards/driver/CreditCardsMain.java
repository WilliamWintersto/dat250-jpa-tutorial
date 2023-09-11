package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.util.Set;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    //Initialize all objects
    Customer customer = new Customer();
    customer.setName("Max Mustermann");

    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);

    CreditCard creditCard1 = new CreditCard();
    creditCard1.setNumber(12345);
    creditCard1.setBalance(-5000);
    creditCard1.setCreditLimit(-10000);

    Pincode pincode = new Pincode();
    pincode.setCode("123");
    pincode.setCount(1);

    CreditCard creditCard2 = new CreditCard();
    creditCard2.setNumber(123);
    creditCard2.setBalance(1);
    creditCard2.setCreditLimit(2000);

    Bank bank = new Bank();
    bank.setName("Pengebank");

    //Initialize all relations
    customer.setAddresses(Set.of(address));
    customer.setCreditCards(Set.of(creditCard1, creditCard2));

    address.setOwners(Set.of(customer));

    creditCard1.setPincode(pincode);
    creditCard1.setOwningBank(bank);

    creditCard2.setPincode(pincode);
    creditCard2.setOwningBank(bank);

    bank.setOwnedCards(Set.of(creditCard1, creditCard2));

    //Persist all objects
    em.persist(customer);
    em.persist(address);
    em.persist(creditCard1);
    em.persist(creditCard2);
    em.persist(pincode);
    em.persist(bank);
  }
}
