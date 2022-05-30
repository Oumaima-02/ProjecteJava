package cat.institutmvm.project.entities;

public class Posidonia extends Especie {

    private String tipo;
    public Posidonia(String especie, String habitat, String dirviento, String cebo, String sexo, int profundidad, String tipo) {
        super(especie, habitat, dirviento, cebo, sexo,profundidad);
        this.setTipo(tipo);
    }
    public Posidonia(String especie, String habitat, String tipo) {
        this(especie, habitat, null, null, null, 0, tipo);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
