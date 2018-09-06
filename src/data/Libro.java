package data;


import java.util.List;

public class Libro {

    private String isbn;
    private String titulo;
    private String categoria;

    public Libro() {
        this.isbn = "";
        this.titulo = "";
        this.categoria = "";
    }

    public Libro(String isbn) {
        this.isbn = isbn;
        this.titulo = "";
        this.categoria = "";

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
        DatabaseHelper<Libro> db = new DatabaseHelper();
        db.modificarRegistro(consultaSQL);
    }

    public void borrar() {
        String consultaSQL = "delete from Libros where isbn='" + this.isbn + "'";
        DatabaseHelper<Libro> db = new DatabaseHelper<>();
        db.modificarRegistro(consultaSQL);
    }

    public static Libro buscarPorClave(String isbn) {
        String consulaSQL = "select isbn, titulo, categoria from Libros where isbn='" + isbn + "'";
        DatabaseHelper<Libro> db = new DatabaseHelper<>();
        List<Libro> listaLibros = db.seleccionarRegistros(consulaSQL,Libro.class);
        return listaLibros.get(0);

    }

    public static List<Libro> buscarPorCategoria(String categoria) {
        String consultaSQL = "select isbn, nombre, categoria from Libros where categoria='" + categoria + "'";
        DatabaseHelper<Libro> db = new DatabaseHelper<>();
        return db.seleccionarRegistros(consultaSQL,Libro.class);
    }

    public void salvar() {
        String consultaSQL = "update Libros set titulo='"+ this.titulo + "', categoria='" + this.categoria + "' where isbn='" + this.isbn + "'";
        DatabaseHelper<Libro> db = new DatabaseHelper<>();
        db.modificarRegistro(consultaSQL);
    }

}
