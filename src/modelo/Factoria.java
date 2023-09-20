package modelo;

/**
 * Esta clase es una factoria de implementaciones de la logica del negocio.
 *
 * @author Jason.
 */
public class Factoria {

    /**
     * Genera una nueva implementacion de la logica del negocio orientada a la
     * base de datos.
     *
     * @return la implementacion orientada a la base de datos.
     */
    public static DAO getImplementacionBD() {
        return new ImplementacionBD();
    }

    /**
     * Genera una nueva implementacion de la logica del negocio orientada a los
     * ficheros.
     *
     * @return la implementacion orientada a los ficheros.
     */
    public static DAO getImplementacionFich() {
        return new ImplementacionFich();
    }

}
