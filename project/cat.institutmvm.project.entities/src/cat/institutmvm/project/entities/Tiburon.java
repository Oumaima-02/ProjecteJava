package cat.institutmvm.project.entities;

public class Tiburon extends Especie {
    private boolean parasito, anzuelos, temp;
    private int numanzuelos,  numemb;


    public Tiburon(String especie, String habitat, String dirviento, String cebo, String sexo,int profundidad, boolean parasito, boolean anzuelos,int numanzuelos, String  temp, int numemb) {
        super(especie, habitat, dirviento, cebo, sexo, profundidad);
        this.setParasito(parasito);
        this.setAnzuelos(anzuelos);
        this.setNumanzuelos(numanzuelos);
        this.setTemp(temp);
        this.setNumemb(numemb);
    }

    public Tiburon(String especie, String habitat) {
        this(especie, habitat, null, null, null, 0, false, false, 0,null,0);
    }


    public boolean isParasito() {
        return parasito;
    }

    public void setParasito(boolean parasito) {
        this.parasito = parasito;
    }

    public boolean isAnzuelos() {
        return anzuelos;
    }

    public void setAnzuelos(boolean anzuelos) {
        this.anzuelos = anzuelos;
    }

    public int getNumanzuelos() {
        return numanzuelos;
    }

    public void setNumanzuelos(int numanzuelos) {
        this.numanzuelos = numanzuelos;
    }

    public boolean getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = Boolean.parseBoolean(temp);
    }

    public int getNumemb() {
        return numemb;
    }

    public void setNumemb(int numemb) {
        this.numemb = numemb;
    }


}
