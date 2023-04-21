package sapozhnikov.example.TestAlvionEurope.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Table(name = "professors")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String address;
    private String phoneNumber;
    private float payment;

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", payment=" + payment +
                '}';
    }
}
