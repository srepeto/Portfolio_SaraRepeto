
package vo;


public class Trabajo {
    private Integer idtrabajo;
    private Integer idoperario;
    private String tipotrabajo;
    private String descripcion;
    private Integer numhoras;
    private float preciomaterial;
    private float precio;
    private String estado;
    private String fechacomienzo;
    private String fechafin;

    public Integer getIdtrabajo() {
        return idtrabajo;
    }

    public void setIdtrabajo(Integer idtrabajo) {
        this.idtrabajo = idtrabajo;
    }

    public Integer getIdoperario() {
        return idoperario;
    }

    public void setIdoperario(Integer idoperario) {
        this.idoperario = idoperario;
    }

    public String getTipotrabajo() {
        return tipotrabajo;
    }

    public void setTipotrabajo(String tipotrabajo) {
        this.tipotrabajo = tipotrabajo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNumhoras() {
        return numhoras;
    }

    public void setNumhoras(Integer numhoras) {
        this.numhoras = numhoras;
    }

    public float getPreciomaterial() {
        return preciomaterial;
    }

    public void setPreciomaterial(float preciomaterial) {
        this.preciomaterial = preciomaterial;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechacomienzo() {
        return fechacomienzo;
    }

    public void setFechacomienzo(String fechacomienzo) {
        this.fechacomienzo = fechacomienzo;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }


    
    
    
    
}
