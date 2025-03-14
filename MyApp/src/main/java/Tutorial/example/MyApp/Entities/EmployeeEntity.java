package Tutorial.example.MyApp.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name= "employees")
public class EmployeeEntity {

    public long getId() {
        return id;
    }
    public EmployeeEntity()
    {

    }

    public EmployeeEntity(long id, String name, LocalDate dateOfJoining, boolean isActive) {
        this.id = id;
        this.name = name;
        this.dateOfJoining = dateOfJoining;
        this.isActive = isActive;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private LocalDate dateOfJoining;
    private boolean isActive;
}
