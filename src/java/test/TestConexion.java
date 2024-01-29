package test;

import java.sql.Connection;
import util.ConectaBD;

public class TestConexion {

    public static void main(String[] args) {

        ConectaBD cbd = new ConectaBD();
        try (Connection cn = cbd.getConexion()) {
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
