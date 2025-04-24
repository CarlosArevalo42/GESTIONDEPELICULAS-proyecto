package model;

public class Pelicula {
    private int id;
    private String titulo;
    private String genero;
    private String director;
    private int año;
    private int duracion;
    private String clasificacion;
    private String idioma;
    private String plataforma;

    public Pelicula() {}

    public Pelicula(int id, String titulo, String genero, String director, int año,
                    int duracion, String clasificacion, String idioma, String plataforma) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.director = director;
        this.año = año;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.idioma = idioma;
        this.plataforma = plataforma;
    }

    // Getters y Setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public int getAño() { return año; }
    public void setAño(int año) { this.año = año; }

    public int getDuracion() { return duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }

    public String getClasificacion() { return clasificacion; }
    public void setClasificacion(String clasificacion) { this.clasificacion = clasificacion; }

    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }

    public String getPlataforma() { return plataforma; }
    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }
}
