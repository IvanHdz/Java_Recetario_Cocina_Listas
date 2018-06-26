public class Recetas {

    private String nombre;
//    private PasosdeRecetas nodoInicial;
    private PasosdeRecetas[] elementos;

    public Recetas(String nombre) {
        this.nombre = nombre;
//        this.nodoInicial = null;
        this.elementos = null;
    }

    public Recetas (String nombre, PasosdeRecetas nodoInicial, PasosdeRecetas[] estructura) {
        this.nombre = nombre;
//        this.nodoInicial = nodoInicial;
        this.elementos = estructura;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//    /**
//     * @return the nodoInicial
//     */
//    public PasosdeRecetas getNodoInicial() {
//        return nodoInicial;
//    }
//
//    /**
//     * @param nodoInicial the nodoInicial to set
//     */
//    public void setNodoInicial(PasosdeRecetas nodoInicial) {
//        this.nodoInicial = nodoInicial;
//    }

    /**
     * @return the nodoActual
     */
    public PasosdeRecetas[] getEstructura() {
        return elementos;
    }

    /**
     * @param nodoActual the nodoActual to set
     */
    public void setNodoEstructura(PasosdeRecetas [] estructura) {
        this.elementos = estructura;
    }
}