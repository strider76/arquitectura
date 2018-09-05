package data;


import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper<T> {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/applibros";
    private static String USER = "root";
    private static String PASS = "rivendel";

    public int modificarRegistro (String consultaSQL) {

        Connection conexion = null;
        Statement sentencia = null;
        int filas_afectadas = 0;

        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL,USER,PASS);
            sentencia = conexion.createStatement();
            filas_afectadas = sentencia.executeUpdate(consultaSQL);


        } catch (ClassNotFoundException e) {
            System.out.println("Error Driver no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException e) {}
            }

            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {}
            }
        }
        return filas_afectadas;
    }

    public List<T> seleccionarRegistros (String consultaSQL, Class clase) {

        Connection conexion = null;
        Statement sentencia = null;
        ResultSet filas = null;
        List<T> listObjetos = new ArrayList<T>();

        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL,USER,PASS);
            sentencia = conexion.createStatement();
            filas = sentencia.executeQuery(consultaSQL);
            while (filas.next()){

                    T objeto = (T) Class.forName(clase.getName()).newInstance();
                    Method[] metodos = objeto.getClass().getDeclaredMethods();
                    for (int i=0; i<metodos.length;i++) {
                        if (metodos[i].getName().startsWith("set")) {
                            metodos[i].invoke(objeto,filas.getString(metodos[i].getName().substring(3)));
                        }
                        if (objeto.getClass().getName().equals("java.lang.String")) {
                            objeto = (T) filas.getString(1);
                        }
                    }
                    listObjetos.add(objeto);
            }
        } catch (Exception e) {
            System.out.println("Error al seleccionar los registros: " + e.getMessage());
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException e) {}
            }

            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {}
            }
        }
        return listObjetos;
    }
}
