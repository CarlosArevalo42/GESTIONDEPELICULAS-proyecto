package main;

import dao.PeliculaDAO;
import model.Pelicula;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    static Scanner scanner = new Scanner(System.in);
    static PeliculaDAO peliculaDAO = new PeliculaDAO();

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> listarPeliculas();
                case 2 -> agregarPelicula();
                case 3 -> editarPelicula();
                case 4 -> eliminarPelicula();
                case 5 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 5);
    }

    public static void mostrarMenu() {
        System.out.println("\n🎬 GESTIÓN DE PELÍCULAS 🎬");
        System.out.println("1. Ver todas las películas");
        System.out.println("2. Agregar nueva película");
        System.out.println("3. Editar una película");
        System.out.println("4. Eliminar una película");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");
    }

    public static void listarPeliculas() {
        List<Pelicula> peliculas = peliculaDAO.obtenerTodas();
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas registradas.");
        } else {
            System.out.println("\n📋 LISTA DE PELÍCULAS:");
            for (Pelicula p : peliculas) {
                System.out.printf("- [%d] %s (%d) - %s - %s\n", p.getId(), p.getTitulo(), p.getAño(), p.getGenero(), p.getPlataforma());
            }
        }
    }

    public static void agregarPelicula() {
        Pelicula p = new Pelicula();

        System.out.print("Título: ");
        p.setTitulo(scanner.nextLine());

        System.out.print("Género: ");
        p.setGenero(scanner.nextLine());

        System.out.print("Director: ");
        p.setDirector(scanner.nextLine());

        System.out.print("Año: ");
        p.setAño(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Duración (min): ");
        p.setDuracion(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Clasificación: ");
        p.setClasificacion(scanner.nextLine());

        System.out.print("Idioma: ");
        p.setIdioma(scanner.nextLine());

        System.out.print("Plataforma: ");
        p.setPlataforma(scanner.nextLine());

        peliculaDAO.insertar(p);
        System.out.println("✅ Película agregada con éxito.");
    }

    public static void editarPelicula() {
        System.out.print("ID de la película a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Pelicula p = new Pelicula();
        p.setId(id);

        System.out.print("Nuevo título: ");
        p.setTitulo(scanner.nextLine());

        System.out.print("Nuevo género: ");
        p.setGenero(scanner.nextLine());

        System.out.print("Nuevo director: ");
        p.setDirector(scanner.nextLine());

        System.out.print("Nuevo año: ");
        p.setAño(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Nueva duración (min): ");
        p.setDuracion(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Nueva clasificación: ");
        p.setClasificacion(scanner.nextLine());

        System.out.print("Nuevo idioma: ");
        p.setIdioma(scanner.nextLine());

        System.out.print("Nueva plataforma: ");
        p.setPlataforma(scanner.nextLine());

        peliculaDAO.editar(p);
    }

    public static void eliminarPelicula() {
        System.out.print("ID de la película a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        peliculaDAO.eliminar(id);
    }
}

