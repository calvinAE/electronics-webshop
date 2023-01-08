package ehb.be.webapp.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.lang.reflect.Array;
import java.util.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    private Long id;

    private double price;

    private int amount;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER )
    private Set<CartItem> items = new HashSet<CartItem>();

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER )
    private User user;

}

