package pis.lab4.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name", length = 45, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 45, nullable = false)
    private String lastName;
    @Column(name = "years_active")
    private int yearsActive;
    private String born;

    @ManyToMany(mappedBy = "actors")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Film> films = new HashSet<>();

    public Actor(String firstName, String lastName, int yearsActive, String born) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearsActive = yearsActive;
        this.born = born;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", yearsActive=" + yearsActive +
                ", born=" + born +
                '}';
    }
}
