package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pet")
public class Pet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private Integer id;

    @Column(name = "breed")
    private String breed;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "is_vaccinated")
    private Boolean isVaccinated;

    @Column(name = "owner")
    private String owner;

    @ManyToMany
    @JoinTable(name="pet_veterinarian")
    private List<Veterinarian> veterinarians;

    @OneToOne(mappedBy = "pet")
    private Consult consult;

    public Pet(String breed, String birthDate, boolean isVaccinated, String owner) {
        this.breed = breed;
        this.birthDate = birthDate;
        this.isVaccinated = isVaccinated;
        this.owner = owner;
    }

    public Pet() {
    }

    public List<Veterinarian> getVeterinarians() {
        return veterinarians;
    }

    public void setVeterinarians(List<Veterinarian> veterinarians) {
        this.veterinarians = veterinarians;
    }

    public Consult getConsult() {
        return consult;
    }

    public void setConsult(Consult consult) {
        this.consult = consult;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", breed='" + breed + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", isVaccinated=" + isVaccinated +
                ", owner='" + owner + '\'' +
                '}';
    }
}
