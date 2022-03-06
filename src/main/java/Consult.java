public class Consult {
    private Veterinarian veterinarian;
    private Pet pet;
    private String date;
    private String description;

    public Consult(Veterinarian veterinarian, Pet pet, String date, String descripion) {
        this.veterinarian = veterinarian;
        this.pet = pet;
        this.date = date;
        this.description = descripion;
    }

    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Consult{" +
                "veterinarian=" + veterinarian +
                ", pet=" + pet +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}