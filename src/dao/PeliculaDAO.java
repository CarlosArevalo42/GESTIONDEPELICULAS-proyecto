package dao;

import conexion.ConexionBD;
import model.Pelicula;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO {

    private Connection conn;

    public PeliculaDAO() {
        conn = ConexionBD.conectar();
    }

    public List<Pelicula> obtenerTodas() {
        List<Pelicula> lista = new ArrayList<>();
        String sql = "SELECT * FROM peliculas";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pelicula p = new Pelicula();
                p.setId(rs.getInt("id"));
                p.setTitulo(rs.getString("titulo"));
                p.setGenero(rs.getString("genero"));
                p.setDirector(rs.getString("director"));
                p.setAño(rs.getInt("año"));
                p.setDuracion(rs.getInt("duracion"));
                p.setClasificacion(rs.getString("clasificacion"));
                p.setIdioma(rs.getString("idioma"));
                p.setPlataforma(rs.getString("plataforma"));
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al obtener películas: " + e.getMessage());
        }

        return lista;
    }

    public void insertar(Pelicula p) {
        String sql = "INSERT INTO peliculas (titulo, genero, director, año, duracion, clasificacion, idioma, plataforma) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getTitulo());
            stmt.setString(2, p.getGenero());
            stmt.setString(3, p.getDirector());
            stmt.setInt(4, p.getAño());
            stmt.setInt(5, p.getDuracion());
            stmt.setString(6, p.getClasificacion());
            stmt.setString(7, p.getIdioma());
            stmt.setString(8, p.getPlataforma());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar película: " + e.getMessage());
        }
    }

    public void editar(Pelicula p) {
        String sql = "UPDATE peliculas SET titulo=?, genero=?, director=?, año=?, duracion=?, clasificacion=?, idioma=?, plataforma=? WHERE id=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getTitulo());
            stmt.setString(2, p.getGenero());
            stmt.setString(3, p.getDirector());
            stmt.setInt(4, p.getAño());
            stmt.setInt(5, p.getDuracion());
            stmt.setString(6, p.getClasificacion());
            stmt.setString(7, p.getIdioma());
            stmt.setString(8, p.getPlataforma());
            stmt.setInt(9, p.getId());

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Película actualizada correctamente.");
            } else {
                System.out.println("⚠️ No se encontró ninguna película con ese ID.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al editar película: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM peliculas WHERE id=?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Película eliminada correctamente.");
            } else {
                System.out.println("⚠️ No se encontró ninguna película con ese ID.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar película: " + e.getMessage());
        }
    }
}
