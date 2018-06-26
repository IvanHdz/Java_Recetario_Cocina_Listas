public class PasosdeRecetas {

    private String informacion;
    private PasosdeRecetas pasos;

    public PasosdeRecetas (String infor) {
        this.informacion = infor;
        pasos = null;
    }

    public PasosdeRecetas (String infor, PasosdeRecetas liga) {
        this.informacion = infor;
        this.pasos = liga;
    }

    /**
     * @return the informacion
     */
    public String getInfor() {
        return informacion;
    }

    /**
     * @param informacion the informacion to set
     */
    public void setInfor(String infor) {
        this.informacion = infor;
    }

    /**
     * @return the pasos
     */
    public PasosdeRecetas getLiga() {
        return pasos;
    }

    /**
     * @param pasos the pasos to set
     */
    public void setLiga(PasosdeRecetas liga) {
        this.pasos = liga;
    }
}
