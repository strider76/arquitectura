package data;


import java.util.List;

public class Libro {

    private String isbn;
    private String titulo;
    private String categoria;

    public Libro() {
        this.isbn = "";
        this.titulo = "";
        this.categoria = "" + "";
    }

    public Libro(String isbn, String titulo, String categoria) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.categoria = categoria;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public static List<String> buscarTodasLasCategorias(){
        String consultaSQL = "select distinct(categoria) from Libros";

        DatabaseHelper<String> helper = new DatabaseHelper<>();
        return helper.seleccionarRegistros(consultaSQL,String.class);


    }

    public static List<Libro> buscarTodos() {
        String consultaSQL = "select isbn, titulo, categoria from Libros";

        DatabaseHelper<Libro> helper = new DatabaseHelper<>();
        return helper.seleccionarRegistros(consultaSQL,Libro.class);

    }

    public  void insertar() {
        String consultaSQL = "insert into Libros (isbn, titulo, categoria) values ('" + isbn + "','"+ titulo +"','" + categoria +"')";
        DatabaseHelper db = new DatabaseHelper();
        db.modificarRegistro(consultaSQL);
    }



}
