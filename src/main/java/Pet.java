

public class Pet {
    private String rase;
    private String birthDate;
    private boolean isVaccinated;
    private String  owner;

    public String getRase() {
        return rase;
    }

    public void setRase(String rase) {
        this.rase = rase;
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
                "rase='" + rase + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", isVaccinated=" + isVaccinated +
                ", owner='" + owner + '\'' +
                '}';
    }
}
