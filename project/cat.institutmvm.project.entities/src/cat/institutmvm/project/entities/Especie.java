package cat.institutmvm.project.entities;

public class Especie {
    private String especie, habitat, dirviento, cebo, sexo;

    private int profundidad;

    public Especie(String especie, String habitat, String dirviento, String cebo, String sexo,int profundidad){
        this.setEspecie(especie);
        this.setHabitat(habitat);
        this.setDirviento(dirviento);
        this.setCebo(cebo);
        this.setSexo(sexo);
        this.setProfundidad(profundidad);

    }
    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }


    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getCebo() {
        return cebo;
    }
    public void setCebo(String cebo) {
        this.cebo = cebo;
    }

    public String getDirviento() {
        return dirviento;
    }
    public void setDirviento(String dirviento) {
        this.dirviento = dirviento;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getHabitat() {
        return habitat;
    }
    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }


}
