package sapozhnikov.example.TestAlvionEurope.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private Integer idRecordBook;
    private Float averagePerformance;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", idRecordBook='" + idRecordBook + '\'' +
                ", averagePerformance=" + averagePerformance +
                '}';
    }
}
