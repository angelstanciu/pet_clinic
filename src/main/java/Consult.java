public class Consult {
    veterinarian Veterinarian = new Veterinarian;
    private String date;
    private String descripion;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    @Override
    public String toString() {
        return "Consult{" +
                "date='" + date + '\'' +
                ", descripion='" + descripion + '\'' +
                '}';
    }
}
