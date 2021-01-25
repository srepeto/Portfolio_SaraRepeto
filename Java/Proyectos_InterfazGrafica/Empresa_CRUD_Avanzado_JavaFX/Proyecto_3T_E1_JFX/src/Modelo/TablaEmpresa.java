package Modelo;
/**
 *
 * @author Sara
 */

//AQUÍ 7
public class TablaEmpresa {
    int codEmp, CP, telfTutor;
    String nombre, cif, direccion, localidad, tipoJornada, dniResp, nomResp, apeResp, dniTutor, nomTL, apeTutor, mailTutor;

    public TablaEmpresa(int codEmp, String nombre, String cif, String direccion, int CP, String localidad, String tipoJornada, String dniResp, String nomResp, String apeResp, String dniTutor, String nomTL, String apeTutor, String mailTutor, int telfTutor) {
        this.codEmp = codEmp;
        this.nombre = nombre;
        this.cif = cif;
        this.direccion = direccion;
        this.CP = CP;
        this.localidad = localidad;
        this.tipoJornada = tipoJornada;
        this.dniResp = dniResp;
        this.nomResp = nomResp;
        this.apeResp = apeResp;
        this.dniTutor = dniTutor;
        this.nomTL = nomTL;
        this.apeTutor = apeTutor;
        this.mailTutor = mailTutor;
        this.telfTutor = telfTutor;
    }

    public int getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(int codEmp) {
        this.codEmp = codEmp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public int getCP() {
        return CP;
    }

    public void setCP(int CP) {
        this.CP = CP;
    }
    
    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTipoJornada() {
        return tipoJornada;
    }

    public void setTipoJornada(String tipoJornada) {
        this.tipoJornada = tipoJornada;
    }
    
    public String getDniResp() {
        return dniResp;
    }

    public void setDniResp(String dniResp) {
        this.dniResp = dniResp;
    }

    public String getNomResp() {
        return nomResp;
    }

    public void setNomResp(String nomResp) {
        this.nomResp = nomResp;
    }
    
    public String getApeResp() {
        return apeResp;
    }

    public void setApeResp(String apeResp) {
        this.apeResp = apeResp;
    }

    public String getDniTutor() {
        return dniTutor;
    }

    public void setDniTutor(String dniTutor) {
        this.dniTutor = dniTutor;
    }

    public String getNomTL() {
        return nomTL;
    }

    public void setNomTL(String nomTL) {
        this.nomTL = nomTL;
    }    
    
    public int getTelfTutor() {
        return telfTutor;
    }

    public void setTelfTutor(int telfTutor) {
        this.telfTutor = telfTutor;
    }

    public String getApeTutor() {
        return apeTutor;
    }

    public void setApeTutor(String apeTutor) {
        this.apeTutor = apeTutor;
    }

    public String getMailTutor() {
        return mailTutor;
    }

    public void setMailTutor(String mailTutor) {
        this.mailTutor = mailTutor;
    }
    
}
