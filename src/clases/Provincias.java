package clases;

import java.util.HashMap;

public class Provincias {
    private static HashMap<Integer, String> provincias = null;

    /**
     * Creamos un Hashmap con los codigos de cada provincia
     */
    private static HashMap<Integer, String> getProvincias() {
        if (provincias == null) {
            provincias = new HashMap<Integer, String>();
            provincias.put(1, "Alava");
            provincias.put(2, "Albacete");
            provincias.put(3, "Alicante");
            provincias.put(4, "Almer�a");
            provincias.put(33, "Asturias");
            provincias.put(5, "Avila");
            provincias.put(6, "Badajoz");
            provincias.put(7, "Baleares");
            provincias.put(8, "Barcelona");
            provincias.put(9, "Burgos");
            provincias.put(10, "C�ceres");
            provincias.put(11, "C�diz");
            provincias.put(39, "Cantabria");
            provincias.put(12, "Castell�n");
            provincias.put(51, "Ceuta");
            provincias.put(13, "Ciudad Real");
            provincias.put(14, "C�rdoba");
            provincias.put(15, "A Coru�a");
            provincias.put(16, "Cuenca");
            provincias.put(17, "Girona");
            provincias.put(18, "Granada");
            provincias.put(19, "Guadalajara");
            provincias.put(20, "Guipuzcoa");
            provincias.put(21, "Huelva");
            provincias.put(22, "Huesca");
            provincias.put(23, "Jaen");
            provincias.put(24, "Le�n");
            provincias.put(25, "L�rida");
            provincias.put(27, "Lugo");
            provincias.put(28, "Madrid");
            provincias.put(29, "M�laga");
            provincias.put(52, "Melilla");
            provincias.put(30, "Murcia");
            provincias.put(31, "Navarra");
            provincias.put(32, "Ourense");
            provincias.put(34, "Palencia");
            provincias.put(35, "Las Palmas");
            provincias.put(36, "Pontevedra");
            provincias.put(26, "La Rioja");
            provincias.put(37, "Salamanca");
            provincias.put(38, "S.C.Tenerife");
            provincias.put(40, "Segovia");
            provincias.put(41, "Sevilla");
            provincias.put(42, "Soria");
            provincias.put(43, "Tarragona");
            provincias.put(44, "Teruel");
            provincias.put(45, "Toledo");
            provincias.put(46, "Valencia");
            provincias.put(47, "Valladolid");
            provincias.put(48, "Vizcaya");
            provincias.put(49, "Zamora");
            provincias.put(50, "Zaragoza");
        }
        return provincias;
    }
    /**
     * Recupera el nombre de una provincia seg�n el c�digo de esta.
     * @param cod int con el c�digo de la provincia
     * @return String con el nombre de la provincia
     */
    public static String getProvincia(int cod) {
        return getProvincias().get(cod);
    }
}
