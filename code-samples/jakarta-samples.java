import jakarta.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    // Costruttori, getter, setter e altre proprietà
}


import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        // Ottieni l'EntityManagerFactory dal nome della 
        // persistence unit definita in persistence.xml
        EntityManagerFactory entityManagerFactory = 
            Persistence.createEntityManagerFactory("example-unit");

        // Ottieni l'EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Inizia una transazione
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            // Crea una nuova istanza di Person
            Person person = new Person();
            person.setName("Mario Rossi");
            person.setAge(30);

            // Salva l'entità nel database
            entityManager.persist(person);

            // Concludi la transazione
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Chiudi l'EntityManager
            entityManager.close();

            // Chiudi l'EntityManagerFactory
            entityManagerFactory.close();
        }
    }
}


import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        // Ottieni l'EntityManagerFactory dal nome della persistence unit definita in persistence.xml
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        // Ottieni l'EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Inizia una transazione
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            // Trova l'entità "Person" da aggiornare utilizzando il suo ID
            Long personIdToUpdate = 1L;
            Person person = entityManager.find(Person.class, personIdToUpdate);

            // Effettua l'aggiornamento
            if (person != null) {
                person.setName("Nuovo Nome");
                person.setAge(35);
                // Non serve chiamare persist() perché l'entità è già gestita dall'EntityManager.
                // Le modifiche verranno propagate automaticamente al database.
            }

            // Concludi la transazione
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Chiudi l'EntityManager
            entityManager.close();

            // Chiudi l'EntityManagerFactory
            entityManagerFactory.close();
        }
    }
}


import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        // Ottieni l'EntityManagerFactory dal nome della persistence unit definita in persistence.xml
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        // Ottieni l'EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Inizia una transazione
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            // Crea una nuova istanza di Person o ottieni 
            // l'entità "Person" da una fonte esterna (ad esempio, tramite API REST)
            // Si suppone che esiste il record on ID=1
            Person personToUpdate = new Person();
            personToUpdate.setId(1L); // Imposta l'ID dell'entità da aggiornare
            personToUpdate.setName("Nuovo Nome");
            personToUpdate.setAge(35);

            // Usa merge() per aggiornare l'entità nel database
            Person updatedPerson = entityManager.merge(personToUpdate);

            // La chiamata a merge() restituirà una copia 
            // gestita dell'entità con lo stato aggiornato.
            // Puoi decidere di utilizzare questa copia gestita 
            // o continuare a utilizzare l'istanza "personToUpdate".

            // Concludi la transazione
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Chiudi l'EntityManager
            entityManager.close();

            // Chiudi l'EntityManagerFactory
            entityManagerFactory.close();
        }
    }
}


import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        // Ottieni l'EntityManagerFactory dal nome della persistence unit definita in persistence.xml
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        // Ottieni l'EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Utilizza find() per recuperare l'entità "Person" con ID specifico
            Long personIdToFind = 1L; // Imposta l'ID dell'entità da cercare
            Person foundPerson = entityManager
                   .find(Person.class, personIdToFind);

            // Verifica se l'entità è stata trovata e procedi con le operazioni
            if (foundPerson != null) {
                System.out.println("Person trovata: " + foundPerson.getName() + "
                        , " + foundPerson.getAge());
                // Puoi manipolare l'entità "foundPerson" qui se necessario
            } else {
                System.out.println("Person non trovata con l'ID: " + personIdToFind);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Chiudi l'EntityManager
            entityManager.close();

            // Chiudi l'EntityManagerFactory
            entityManagerFactory.close();
        }
    }
}


import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        // Ottieni l'EntityManagerFactory dal nome della persistence unit definita in persistence.xml
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        // Ottieni l'EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // Inizia una transazione
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            // Trova l'entità "Person" da eliminare utilizzando il suo ID
            Long personIdToDelete = 1L; // Imposta l'ID dell'entità da eliminare
            Person personToDelete = entityManager
                   .find(Person.class, personIdToDelete);

            // Effettua l'eliminazione
            if (personToDelete != null) {
                entityManager.remove(personToDelete);
                System.out.println("Person eliminata con successo.");
            } else {
                System.out.println("Person non trovata con l'ID: " 
                      + personIdToDelete);
            }

            // Concludi la transazione
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Chiudi l'EntityManager
            entityManager.close();

            // Chiudi l'EntityManagerFactory
            entityManagerFactory.close();
        }
    }
}


import jakarta.persistence.*;
import java.util.List;

public class ProdottoDao {

    private EntityManager entityManager;

    public ProdottoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Prodotto> trovaProdottiConPrezzoSuperiore
            (float prezzoMinimo) {
        // Creazione della query JPQL
        String jpql = "SELECT p FROM Prodotto p WHERE p.prezzo > :prezzo";

        // Creazione della query JPQL tramite l'EntityManager
        TypedQuery<Prodotto> query = entityManager
                .createQuery(jpql, Prodotto.class);

        // Impostazione del parametro "prezzo" nella query
        query.setParameter("prezzo", prezzoMinimo);

        // Esecuzione della query e recupero dei risultati
        List<Prodotto> prodotti = query.getResultList();

        return prodotti;
    }
}


import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

public class ProdottoDao {

    private EntityManager entityManager;
    private JPAQueryFactory queryFactory;

    public ProdottoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    public List<Prodotto> trovaProdottiConPrezzoSuperiore(float prezzoMinimo) {
        // Importa le classi QueryDSL
        import com.querydsl.jpa.impl.JPAQuery;
        import com.querydsl.jpa.impl.JPAQueryFactory;

        // Crea un oggetto JPAQuery utilizzando la factory
        JPAQuery<Prodotto> query = queryFactory.selectFrom(QProdotto.prodotto)
            .where(QProdotto.prodotto.prezzo.gt(prezzoMinimo));

        // Esegui la query e restituisci i risultati
        return query.fetch();
    }
}


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ProdottoDao {

    private EntityManager entityManager;

    public ProdottoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Prodotto> trovaProdottiConPrezzoSuperiore(float prezzoMinimo) {
        // Otteniamo il CriteriaBuilder dall'EntityManager
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        // Creiamo una query Criteria per Prodotto
        CriteriaQuery<Prodotto> criteriaQuery = criteriaBuilder.createQuery(Prodotto.class);

        // Definiamo la radice (root) dell'entità Prodotto
        Root<Prodotto> prodottoRoot = criteriaQuery.from(Prodotto.class);

        // Creiamo un predicato per la condizione "prezzo > prezzoMinimo"
        Predicate condition = criteriaBuilder.gt(prodottoRoot.get("prezzo"), prezzoMinimo);

        // Aggiungiamo il predicato alla query
        criteriaQuery.where(condition);

        // Eseguiamo la query e restituisci i risultati
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import java.io.Serializable;

@Entity
@NamedQuery(
    name = "Prodotto.trovaProdottiConPrezzoSuperiore",
    query = "SELECT p FROM Prodotto p WHERE p.prezzo > :prezzo"
)
public class Prodotto implements Serializable {
    @Id
    private Long id;
    private String nome;
    private float prezzo;

    // Altro codice di entità...
}


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ProdottoDao {

    private EntityManager entityManager;

    public ProdottoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Prodotto> trovaProdottiConPrezzoSuperiore(float prezzoMinimo) {
        // Creiamo una TypedQuery utilizzando la Named Query
        TypedQuery<Prodotto> query = entityManager.createNamedQuery(
            "Prodotto.trovaProdottiConPrezzoSuperiore", Prodotto.class
        );

        // Impostiamo il parametro "prezzo" nella query
        query.setParameter("prezzo", prezzoMinimo);

        // Eseguiamo la query e restituisci i risultati
        return query.getResultList();
    }
}


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class ProdottoDao {

    private EntityManager entityManager;

    public ProdottoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Prodotto> trovaProdottiConPrezzoSuperiore(float prezzoMinimo) {
        // Creazione della query SQL nativa
        String sql = "SELECT * FROM prodotto WHERE prezzo > :prezzo";

        // Creazione della query SQL nativa tramite l'EntityManager
        Query query = entityManager.createNativeQuery(sql, Prodotto.class);

        // Impostazione del parametro "prezzo" nella query
        query.setParameter("prezzo", prezzoMinimo);

        // Esecuzione della query e restituzione dei risultati
        return query.getResultList();
    }
}
