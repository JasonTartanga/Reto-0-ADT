package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import clases.Cesta_Compra;
import clases.Juguete;
import clases.Linea_De_Ropa;
import clases.Pelicula_Serie;
import clases.Persona;
import clases.Producto;
import clases.Realiza;
import clases.Tarjeta;
import clases.Usuario;

public class ControladorBdImplementacion implements DAO {

	private Connection con;
	private PreparedStatement stmt;

	// sentencia SQL
	private final String LOGEO = "SELECT * FROM persona WHERE email=? and contraseña=?";
	private final String ACTUALIZAR_LINEA_ROPA = "UPDATE linea_de_ropa SET talla=?, tejido=?, color=?, fabricante=? WHERE codigo_producto=?";
	private final String ACTUALIZAR_JUGUETE = "UPDATE juguete SET material=?, articulable=?, edad_minima=?, pilas=? WHERE codigo_producto=?";
	private final String ACTUALIZAR_PELICULA = "UPDATE pelicula_serie SET genero=?, fecha_de_lanzamiento=?, idioma=?, subtitulado=?, duracion=? WHERE codigo_producto=?";
	private final String ACTUALIZAR_PRODUCTO = "UPDATE producto SET nombre=?, precio=?, peso=?, num_existencias=?, dimensiones=? WHERE codigo_producto=?";
	private final String ALTA_PRODUCTO = "INSERT INTO PRODUCTO (codigo_producto, nombre, precio, peso, num_existencias, dimensiones) VALUES (?,?,?,?,?,?)";
	private final String ALTA_LINEA_ROPA = "INSERT INTO LINEA_DE_ROPA (codigo_producto, talla, tejido, color, fabricante) VALUES (?,?,?,?,?)";
	private final String ALTA_JUGUETE = "INSERT INTO JUGUETE (codigo_producto, material, articulable, edad_minima, pilas) VALUES (?,?,?,?,?)";
	private final String ALTA_PELIS_SERIES = "INSERT INTO PELICULA_SERIE (codigo_producto, genero, fecha_de_lanzamiento, idioma, subtitulado, duracion) VALUES (?,?,?,?,?,?)";
	private final String SELECT_PRODUCTOS = "SELECT * FROM PRODUCTO";
	private final String DELETE_PRODUCTO = "DELETE FROM PRODUCTO WHERE CODIGO_PRODUCTO = ?";
	private final String DELETE_CESTA = "DELETE FROM CESTA_COMPRA WHERE NUMREFERENCIA IN(SELECT NUMREFERENCIA FROM REALIZA WHERE CODIGO_PERSONA IN (SELECT CODIGO_PERSONA FROM PERSONA WHERE EMAIL= ?))";
	private final String DELETE_TARJETA = "DELETE FROM TARJETA WHERE NUMERO_TARJETA IN(SELECT NUMERO_TARJETA FROM USUARIO WHERE CODIGO_PERSONA_USUARIO IN (SELECT CODIGO_PERSONA FROM PERSONA WHERE EMAIL= ?))";
	private final String DELETE_REALIZA = "DELETE FROM REALIZA WHERE CODIGO_PERSONA IN (SELECT CODIGO_PERSONA FROM PERSONA WHERE EMAIL= ?)";
	private final String DELETE_CUENTA = "DELETE FROM PERSONA WHERE EMAIL=?";
	private final String SELECT_PRODUCTO_COD = "SELECT * FROM PRODUCTO WHERE codigo_producto=?";
	private final String SELECT_LINEA_ROPA = "SELECT * FROM LINEA_DE_ROPA WHERE codigo_producto=?";
	private final String SELECT_JUGUETE = "SELECT * FROM JUGUETE WHERE codigo_producto=?";
	private final String SELECT_PELICULA = "SELECT * FROM PELICULA_SERIE WHERE codigo_producto=?";
	private final String SELECT_COMPRA = "select * from realiza r join cesta_compra cc ON R.NUMREFERENCIA=CC.NUMREFERENCIA JOIN PERSONA P ON R.CODIGO_PERSONA=P.CODIGO_PERSONA WHERE P.CODIGO_PERSONA=?";
	private final String SELECT_PROD_LINEA = "SELECT * FROM PRODUCTO P JOIN LINEA_DE_ROPA L ON P.codigo_producto=L.codigo_producto";
	private final String SELECT_PROD_JUGUETE = "SELECT * FROM PRODUCTO P JOIN JUGUETE J ON P.codigo_producto=J.codigo_producto";
	private final String SELECT_PROD_PELI = "SELECT * FROM PRODUCTO P JOIN PELICULA_SERIE PS ON P.codigo_producto=PS.codigo_producto";
	private final String SUMA_PRECIO = "select sum(peso) from realiza r join usuario u on r.CODIGO_PERSONA=u.CODIGO_PERSONA JOIN producto P ON R.CODIGO_PRODUCTO=P.CODIGO_PRODUCTO WHERE U.CODIGO_PERSONA = P001";
	private final String INSERT_PERSONA = "INSERT INTO persona (codigo_persona, nombre, email, num_telefono, contraseña ) VALUES ( ?, ?, ?, ?,?)";
	private final String INSERT_USUARIO = "INSERT INTO usuario (codigo_persona_usuario, numero_tarjeta, nombre, apellido, fecha_nacimiento, direccion) VALUES ( ?, ?, ?, ?, ?,?)";
	private final String INSERT_TARJETA = "INSERT INTO tarjeta (numero_tarjeta, cvv) VALUES ( ?, ?)";
	private final String SELECT_EN_CESTA = "SELECT P.CODIGO_PRODUCTO,P.NOMBRE,PESO, PRECIO, CC.NUMREFERENCIA,  FECHA_INICIO, CANTIDAD FROM REALIZA R JOIN PRODUCTO P ON P.CODIGO_PRODUCTO=R.CODIGO_PRODUCTO JOIN USUARIO U ON R.CODIGO_PERSONA= U.CODIGO_PERSONA_USUARIO JOIN CESTA_COMPRA CC ON R.NUMREFERENCIA=CC.NUMREFERENCIA WHERE U.CODIGO_PERSONA_USUARIO=? AND CC.FECHA_FIN IS NULL AND R.NUMREFERENCIA=?";
	private final String INSERT_REALIZA = "REPLACE INTO REALIZA (NUMREFERENCIA, CODIGO_PRODUCTO, CODIGO_PERSONA,CANTIDAD) VALUES(?,?,?,?)";
	private final String INSERT_CESTA = "INSERT INTO CESTA_COMPRA (NUMREFERENCIA, FECHA_INICIO,FECHA_FIN, PESO_TOTAL ,PRECIO_TOTAL) VALUES(?,?,?,?,?)";
	private final String RECOGER_DATOS_EMAIL = "SELECT * FROM PERSONA WHERE EMAIL=?";
	private final String RECOGER_DATOS_USUARIO = "SELECT P.*, U.* FROM PERSONA P JOIN USUARIO U ON P.CODIGO_PERSONA=U.CODIGO_PERSONA_USUARIO WHERE EMAIL=?";
	private final String RECOGER_DATOS_TARJETA = "SELECT T.*, U.* FROM USUARIO U JOIN PERSONA P ON P.CODIGO_PERSONA=U.CODIGO_PERSONA_USUARIO JOIN TARJETA T ON U.NUMERO_TARJETA=T.NUMERO_TARJETA WHERE EMAIL=?";
	private final String ACTUALIZAR_DATOS_CESTA = "UPDATE CESTA_COMPRA SET FECHA_FIN=? WHERE NUMREFERENCIA IN (SELECT NUMREFERENCIA FROM REALIZA WHERE CODIGO_PERSONA IN (SELECT CODIGO_PERSONA FROM PERSONA WHERE EMAIL=?))";
	private final String ACTUALIZAR_DATOS_PRODUCTO = "UPDATE PRODUCTO SET NUM_EXISTENCIAS=? WHERE CODIGO_PRODUCTO=?";
	private final String SELECT_PROD_ID = "SELECT * FROM PRODUCTO P WHERE CODIGO_PRODUCTO IN (SELECT CODIGO_PRODUCTO FROM REALIZA WHERE CODIGO_PERSONA IN (SELECT CODIGO_PERSONA FROM PERSONA WHERE EMAIL=?))";
	private final String SELECT_CANTIDAD = "SELECT * FROM REALIZA WHERE CODIGO_PERSONA IN (SELECT CODIGO_PERSONA FROM PERSONA WHERE EMAIL=?)";
	private final String OFERTA = "CALL crear_oferta(?)";

	private ResourceBundle configFichero;
	private String driverBD;
	private String urlBD;
	private String userBD;
	private String passwordBD;

	// Metodo para conectarnos a la base de datos
	public ControladorBdImplementacion() {
		this.configFichero = ResourceBundle.getBundle("modelo.configuracion");
		this.driverBD = this.configFichero.getString("Driver");
		this.urlBD = this.configFichero.getString("Conn");
		this.userBD = this.configFichero.getString("DBUser");
		this.passwordBD = this.configFichero.getString("DBPass");
	}

	private void openConnection() {
		try {
			// Class.forName(this.driverBD);
			con = DriverManager.getConnection(this.urlBD, this.userBD, this.passwordBD);
		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se ha abierto la base de datos");
			e.printStackTrace();
		}
	}

	private void closeConnection() throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
		if (con != null)
			con.close();
	}

	public Persona login(Persona pers) {

		ResultSet rs = null;
		this.openConnection();
		try {
			stmt = con.prepareStatement(LOGEO);
			stmt.setString(1, pers.getEmail());
			stmt.setString(2, pers.getContrasena());

			rs = stmt.executeQuery();

			if (rs.next()) {
				// RECOGEMOS LOS DATOS DE PERSONA
				pers = new Persona();
				pers.setCodigoPersona(rs.getString("codigo_persona"));
				pers.setNombre(rs.getString("nombre"));
				pers.setEmail(rs.getString("email"));
				pers.setNumTelefono(rs.getInt("num_telefono"));
				pers.setContrasena(rs.getString("contraseña"));

			}
		} catch (SQLException e) {

		}
		return pers;
	}

	public Persona recogerDatosPersonaEmail(String email) {
		ResultSet rs = null;
		Persona pers = null;
		this.openConnection();
		try {
			stmt = con.prepareStatement(RECOGER_DATOS_USUARIO);
			stmt.setString(1, email);

			rs = stmt.executeQuery();

			if (rs.next()) {
				// RECOGEMOS LOS DATOS DE PERSONA
				pers = new Usuario();
				pers.setCodigoPersona(rs.getString("codigo_persona_usuario"));
				pers.setNombre(rs.getString("nombre"));
				pers.setEmail(rs.getString("email"));
				((Usuario) pers).setNombrePersonal(rs.getString("nombre"));
				((Usuario) pers).setApellido(rs.getString("apellido"));
				pers.setNumTelefono(rs.getInt("num_telefono"));
				((Usuario) pers).setDireccion(rs.getString("direccion"));

			}
		} catch (SQLException e) {

		}
		return pers;
	}

	public Tarjeta recogerDatosTarjeta(String email) {
		ResultSet rs = null;
		Tarjeta tar = null;
		this.openConnection();
		try {
			stmt = con.prepareStatement(RECOGER_DATOS_TARJETA);
			stmt.setString(1, email);

			rs = stmt.executeQuery();

			if (rs.next()) {
				// RECOGEMOS LOS DATOS DE LA TARJETA
				tar = new Tarjeta();
				tar.setCVV(rs.getInt("CVV"));
				tar.setNumeroTarjeta(rs.getString("numero_tarjeta"));

			}
		} catch (SQLException e) {

		}
		return tar;
	}

	public Cesta_Compra crearOferta(String numReferencia) {
		ResultSet rs = null;
		Cesta_Compra cesta = null;
		this.openConnection();
		try {
			stmt = con.prepareStatement(OFERTA);
			stmt.setString(1, numReferencia);

			stmt.executeUpdate();

		} catch (SQLException e) {

		}
		return cesta;
	}

	public void insertarProducto(Producto prod) {

		this.openConnection();

		try {
			stmt = con.prepareStatement(ALTA_PRODUCTO); // Cargamos el insert de persona con el stmt
			// Posicionamos cada valor para insertarlo en la base de datos
			stmt.setString(1, prod.getCodigoProducto());
			stmt.setString(2, prod.getNombre());
			stmt.setFloat(3, prod.getPrecio());
			stmt.setFloat(4, prod.getPeso());
			stmt.setInt(5, prod.getNumExistencias());
			stmt.setString(6, prod.getDimensiones());

			if (stmt.executeUpdate() == 1) {
				if (prod instanceof Linea_De_Ropa) {
					stmt = con.prepareStatement(ALTA_LINEA_ROPA);

					stmt.setString(1, prod.getCodigoProducto());
					stmt.setString(2, ((Linea_De_Ropa) prod).getTalla());
					stmt.setString(3, ((Linea_De_Ropa) prod).getTejido());
					stmt.setString(4, ((Linea_De_Ropa) prod).getColor());
					stmt.setString(5, ((Linea_De_Ropa) prod).getFabricante());
					stmt.executeUpdate();

				} else if (prod instanceof Juguete) {

					stmt = con.prepareStatement(ALTA_JUGUETE);

					stmt.setString(1, prod.getCodigoProducto());
					stmt.setString(2, ((Juguete) prod).getMaterial());
					stmt.setString(3, ((Juguete) prod).getArticulable());
					stmt.setInt(4, ((Juguete) prod).getEdadMinima());
					stmt.setString(5, ((Juguete) prod).getPilas());
					stmt.executeUpdate();
				} else if (prod instanceof Pelicula_Serie) {
					stmt = con.prepareStatement(ALTA_PELIS_SERIES);

					stmt.setString(1, prod.getCodigoProducto());
					stmt.setString(2, ((Pelicula_Serie) prod).getGenero());
					stmt.setString(3, ((Pelicula_Serie) prod).getFechaLanzamiento());
					stmt.setString(4, ((Pelicula_Serie) prod).getIdioma());
					stmt.setString(5, ((Pelicula_Serie) prod).getSubtitulado());
					stmt.setString(6, ((Pelicula_Serie) prod).getDuracion());
					stmt.executeUpdate();
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public boolean validarFloat(String cadena) {
		Float num;
		try {
			// SI ES UN INT
			num = Float.parseFloat(cadena);
			return true;

		} catch (Exception e) {
			// SI ES UN STRING
			return false;
		}
	}

	public boolean validarInt(String cadena) {
		int num;
		try {
			// SI ES UN INT
			num = Integer.parseInt(cadena);
			return true;

		} catch (Exception e) {
			// SI ES UN STRING
			return false;
		}
	}

	public boolean validarLong(String cadena) {
		Long num;
		try {
			// SI ES UN INT
			num = Long.parseLong(cadena);
			return true;

		} catch (Exception e) {
			// SI ES UN STRING
			return false;
		}
	}

	public int numeroProducto(Producto prod) {
		ResultSet rs = null;
		String numJuguetes = "SELECT COUNT(codigo_producto)FROM producto";
		int n = 0;
		this.openConnection();

		try {
			stmt = con.prepareStatement(numJuguetes);
			rs = stmt.executeQuery();
			if (rs.next()) {
				// Si hay resultados obtengo el valor.
				n = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return n;

	}

	public int numeroReferencia(Cesta_Compra cesta) {
		ResultSet rs = null;
		String numJuguetes = "SELECT COUNT(numreferencia)FROM cesta_compra";
		int n = 0;
		this.openConnection();

		try {
			stmt = con.prepareStatement(numJuguetes);
			rs = stmt.executeQuery();
			if (rs.next()) {
				// Si hay resultados obtengo el valor.
				n = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return n;

	}

	public ArrayList<Producto> recogerProductos() {
		this.openConnection();
		Producto prod;
		ArrayList<Producto> codProd = new ArrayList<>();
		ResultSet rs;

		try {
			stmt = con.prepareStatement(SELECT_PRODUCTOS);
			rs = stmt.executeQuery();

			while (rs.next()) {
				prod = new Producto();
				prod.setCodigoProducto(rs.getString("codigo_producto"));
				prod.setNombre(rs.getString("nombre"));
				prod.setPrecio(rs.getFloat("precio"));
				prod.setPeso(rs.getFloat("peso"));
				prod.setPrecio(rs.getFloat("num_existencias"));
				prod.setDimensiones(rs.getString("dimensiones"));
				codProd.add(prod);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codProd;

	}

	public ArrayList<Producto> recogerProductosId(Persona pers) {
		this.openConnection();
		Producto prod;
		ArrayList<Producto> codProd = new ArrayList<>();
		ResultSet rs;

		try {
			stmt = con.prepareStatement(SELECT_PROD_ID);
			stmt.setString(1, pers.getEmail());
			rs = stmt.executeQuery();

			while (rs.next()) {
				prod = new Producto();
				prod.setCodigoProducto(rs.getString("codigo_producto"));
				prod.setNombre(rs.getString("nombre"));
				prod.setPrecio(rs.getFloat("precio"));
				prod.setPeso(rs.getFloat("peso"));
				prod.setNumExistencias(rs.getInt("num_existencias"));
				prod.setDimensiones(rs.getString("dimensiones"));
				codProd.add(prod);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codProd;

	}

	public ArrayList<Realiza> recogerCantidad(Persona pers) {
		this.openConnection();
		Realiza realiza;
		ArrayList<Realiza> realizas = new ArrayList<>();
		ResultSet rs;

		try {
			stmt = con.prepareStatement(SELECT_CANTIDAD);
			stmt.setString(1, pers.getEmail());
			rs = stmt.executeQuery();

			while (rs.next()) {
				realiza = new Realiza();
				realiza.setNumReferencia(rs.getString("numreferencia"));
				realiza.setCodigoProducto(rs.getString("codigo_producto"));
				realiza.setCodigoPersona(rs.getString("codigo_persona"));
				realiza.setCantidad(rs.getInt("cantidad"));
				realizas.add(realiza);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return realizas;
	}

	public Producto recogerProductoId(String codigo_producto) {
		this.openConnection();
		Producto prod = null;
		ResultSet rs;

		try {
			stmt = con.prepareStatement(SELECT_PRODUCTO_COD);
			stmt.setString(1, codigo_producto);
			rs = stmt.executeQuery();

			while (rs.next()) {
				prod = new Producto();
				prod.setCodigoProducto(rs.getString("codigo_producto"));
				prod.setNombre(rs.getString("nombre"));
				prod.setPrecio(rs.getFloat("precio"));
				prod.setPeso(rs.getFloat("peso"));
				prod.setNumExistencias(rs.getInt("num_existencias"));
				prod.setDimensiones(rs.getString("dimensiones"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prod;

	}

	public Producto recogerLineaRopaId(String codigo_producto) {
		this.openConnection();
		Producto prod = null;
		ResultSet rs;

		try {
			stmt = con.prepareStatement(SELECT_LINEA_ROPA);
			stmt.setString(1, codigo_producto);
			rs = stmt.executeQuery();

			while (rs.next()) {
				prod = new Linea_De_Ropa();
				((Linea_De_Ropa) prod).setTalla(rs.getString("talla"));
				((Linea_De_Ropa) prod).setTejido(rs.getString("tejido"));
				((Linea_De_Ropa) prod).setColor(rs.getString("color"));
				((Linea_De_Ropa) prod).setFabricante(rs.getString("fabricante"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prod;

	}

	public Producto recogerJugueteId(String codigo_producto) {
		this.openConnection();
		Producto prod = null;
		ResultSet rs;

		try {
			stmt = con.prepareStatement(SELECT_JUGUETE);
			stmt.setString(1, codigo_producto);
			rs = stmt.executeQuery();

			while (rs.next()) {
				prod = new Juguete();
				((Juguete) prod).setMaterial(rs.getString("material"));
				((Juguete) prod).setArticulable(rs.getString("articulable"));
				((Juguete) prod).setEdadMinima(rs.getInt("edad_minima"));
				((Juguete) prod).setPilas(rs.getString("pilas"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prod;

	}

	public Producto recogerPeliculaId(String codigo_producto) {
		this.openConnection();
		Producto prod = null;
		ResultSet rs;

		try {
			stmt = con.prepareStatement(SELECT_PELICULA);
			stmt.setString(1, codigo_producto);
			rs = stmt.executeQuery();

			while (rs.next()) {
				prod = new Pelicula_Serie();
				((Pelicula_Serie) prod).setGenero(rs.getString("genero"));
				((Pelicula_Serie) prod).setFechaLanzamiento(rs.getString("fecha_de_lanzamiento"));
				((Pelicula_Serie) prod).setIdioma(rs.getString("idioma"));
				((Pelicula_Serie) prod).setSubtitulado(rs.getString("subtitulado"));
				((Pelicula_Serie) prod).setDuracion(rs.getString("duracion"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prod;

	}

	public void eliminarProducto(Producto prod) {

		this.openConnection();

		try {

			stmt = con.prepareStatement(DELETE_PRODUCTO);
			stmt.setString(1, prod.getCodigoProducto());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet

			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}

		}

	}

	public void eliminarCesta(Persona pers) {

		this.openConnection();

		try {

			stmt = con.prepareStatement(DELETE_CESTA);
			stmt.setString(1, pers.getEmail());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet

			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}

		}

	}

	public void eliminarTarjeta(Persona pers) {

		this.openConnection();

		try {

			stmt = con.prepareStatement(DELETE_TARJETA);
			stmt.setString(1, pers.getEmail());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet

			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}

		}

	}

	public void eliminarRealiza(Persona pers) {

		this.openConnection();

		try {

			stmt = con.prepareStatement(DELETE_REALIZA);
			stmt.setString(1, pers.getEmail());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet

			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}

		}

	}

	public void eliminarCuenta(Persona per) {

		this.openConnection();

		try {

			stmt = con.prepareStatement(DELETE_CUENTA);
			stmt.setString(1, per.getEmail());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet

			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}

		}

	}

	public void modificarProducto(Producto prod) {

		ResultSet rs = null;

		// Abrimos la conexion con la base de datos
		this.openConnection();

		try {

			stmt = con.prepareStatement(ACTUALIZAR_PRODUCTO);

			stmt.setString(1, prod.getNombre());
			stmt.setFloat(2, prod.getPrecio());
			stmt.setFloat(3, prod.getPeso());
			stmt.setInt(4, prod.getNumExistencias());
			stmt.setFloat(5, Float.parseFloat(prod.getDimensiones()));

			stmt.setString(6, prod.getCodigoProducto());

			if (stmt.executeUpdate() == 1) {
				if (prod instanceof Linea_De_Ropa) {

					stmt = con.prepareStatement(ACTUALIZAR_LINEA_ROPA);
					stmt.setString(1, prod.getCodigoProducto());
					stmt.setString(2, ((Linea_De_Ropa) prod).getTalla());
					stmt.setString(3, ((Linea_De_Ropa) prod).getTejido());
					stmt.setString(4, ((Linea_De_Ropa) prod).getColor());
					stmt.setString(5, ((Linea_De_Ropa) prod).getFabricante());

					stmt.executeUpdate();
				} else if (prod instanceof Juguete) {
					stmt = con.prepareStatement(ACTUALIZAR_JUGUETE);
					stmt.setString(1, prod.getCodigoProducto());
					stmt.setString(2, ((Juguete) prod).getMaterial());
					stmt.setString(3, ((Juguete) prod).getArticulable());
					stmt.setInt(4, ((Juguete) prod).getEdadMinima());
					stmt.setString(5, ((Juguete) prod).getPilas());

					stmt.executeUpdate();
				} else if (prod instanceof Pelicula_Serie) {
					stmt = con.prepareStatement(ACTUALIZAR_PELICULA);
					stmt.setString(1, prod.getCodigoProducto());
					stmt.setString(2, ((Pelicula_Serie) prod).getGenero());
					stmt.setString(3, ((Pelicula_Serie) prod).getFechaLanzamiento());
					stmt.setString(4, ((Pelicula_Serie) prod).getIdioma());
					stmt.setString(5, ((Pelicula_Serie) prod).getSubtitulado());
					stmt.setString(6, ((Pelicula_Serie) prod).getDuracion());

					stmt.executeUpdate();
				}

			}
		} catch (SQLException e1) {
			System.out.println("Error en la modificación SQL");
			e1.printStackTrace();

		} finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void modificarCesta(Cesta_Compra cesta, Persona pers) {
		ResultSet rs = null;

		// Abrimos la conexion con la base de datos
		this.openConnection();

		try {

			stmt = con.prepareStatement(ACTUALIZAR_DATOS_CESTA);

			stmt.setDate(1, cesta.getFecha_fin());
			stmt.setString(2, pers.getEmail());

			stmt.executeUpdate();

		} catch (SQLException e1) {
			System.out.println("Error en la modificación SQL");
			e1.printStackTrace();

		} finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void añadirStockProducto(Producto prod, Persona pers) {
		ResultSet rs = null;

		// Abrimos la conexion con la base de datos
		this.openConnection();

		try {

			stmt = con.prepareStatement(ACTUALIZAR_DATOS_PRODUCTO);

			stmt.setInt(1, prod.getNumExistencias());
			stmt.setString(2, prod.getCodigoProducto());

			stmt.executeUpdate();

		} catch (SQLException e1) {
			System.out.println("Error en la modificación SQL");
			e1.printStackTrace();

		} finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Map<String, Cesta_Compra> listarCompra(Persona per) {
		ResultSet rs = null;
		Cesta_Compra compra;
		Map<String, Cesta_Compra> listaCompra = new HashMap<>();

		this.openConnection();

		try {
			stmt = con.prepareStatement(SELECT_COMPRA);
			stmt.setString(1, per.getCodigoPersona());
			rs = stmt.executeQuery();

			while (rs.next()) {
				compra = new Cesta_Compra();
				compra.setNumReferencia(rs.getString("numreferencia"));
				compra.setFecha_Inicio(rs.getDate("fecha_inicio"));
				compra.setFecha_fin(rs.getDate("fecha_fin"));
				compra.setPeso_total(rs.getFloat("peso_total"));
				compra.setPrecio_total(rs.getFloat("precio_total"));
				listaCompra.put(compra.getNumReferencia(), compra);
			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println("Error en cierre del ResultSet");
				}
			}
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}
		return listaCompra;
	}

	public void insertarCompra_Cesta(Cesta_Compra cesta) {
		this.openConnection();

		try {
			stmt = con.prepareStatement(INSERT_CESTA); // Cargamos el insert de persona con el stmt
			// Posicionamos cada valor para insertarlo en la base de datos
			stmt.setString(1, cesta.getNumReferencia());
			stmt.setDate(2, Date.valueOf(cesta.getFecha_Inicio().toLocalDate()));
			stmt.setDate(3, null);
			stmt.setFloat(4, cesta.getPeso_total());
			stmt.setFloat(5, cesta.getPrecio_total());
			stmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void insertarRealiza(Realiza realiza) {
		this.openConnection();

		try {
			stmt = con.prepareStatement(INSERT_REALIZA); // Cargamos el insert de persona con el stmt
			// Posicionamos cada valor para insertarlo en la base de datos
			stmt.setString(1, realiza.getNumReferencia());
			stmt.setString(2, realiza.getCodigoProducto());
			stmt.setString(3, realiza.getCodigoPersona());
			stmt.setInt(4, realiza.getCantidad());

			stmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public Producto recogerCesta(String codigo_persona, String numreferencia) {
		this.openConnection();
		Persona per = null;
		Producto prod = null;
		Cesta_Compra cesta = null;
		ResultSet rs;

		try {
			stmt = con.prepareStatement(SELECT_EN_CESTA);
			stmt.setString(1, codigo_persona);
			stmt.setString(2, numreferencia);
			rs = stmt.executeQuery();

			while (rs.next()) {
				prod = new Producto();
				prod.setCodigoProducto(rs.getString("codigo_producto"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			this.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prod;

	}

	public Map<String, Producto> listarProdRopa() {
		ResultSet rs = null;
		Producto prod;
		Map<String, Producto> listaProd = new HashMap<>();

		this.openConnection();

		try {
			stmt = con.prepareStatement(SELECT_PROD_LINEA);

			rs = stmt.executeQuery();

			while (rs.next()) {
				prod = new Linea_De_Ropa();
				prod.setCodigoProducto(rs.getString("codigo_producto"));
				prod.setNombre(rs.getString("nombre"));
				prod.setPrecio(rs.getFloat("precio"));
				prod.setPeso(rs.getFloat("peso"));
				prod.setNumExistencias(rs.getInt("num_existencias"));
				prod.setDimensiones(rs.getString("dimensiones"));
				((Linea_De_Ropa) prod).setTalla(rs.getString("talla"));
				((Linea_De_Ropa) prod).setTejido(rs.getString("tejido"));
				((Linea_De_Ropa) prod).setColor(rs.getString("color"));
				((Linea_De_Ropa) prod).setFabricante(rs.getString("fabricante"));
				listaProd.put(prod.getCodigoProducto(), prod);

			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println("Error en cierre del ResultSet");
				}
			}
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}
		return listaProd;
	}

	public Map<String, Producto> listarProdJuguete() {
		ResultSet rs = null;
		Producto prod;
		Map<String, Producto> listaProd = new HashMap<>();

		this.openConnection();

		try {
			stmt = con.prepareStatement(SELECT_PROD_JUGUETE);

			rs = stmt.executeQuery();

			while (rs.next()) {
				prod = new Juguete();
				prod.setCodigoProducto(rs.getString("codigo_producto"));
				prod.setNombre(rs.getString("nombre"));
				prod.setPrecio(rs.getFloat("precio"));
				prod.setPeso(rs.getFloat("peso"));
				prod.setNumExistencias(rs.getInt("num_existencias"));
				prod.setDimensiones(rs.getString("dimensiones"));
				((Juguete) prod).setMaterial(rs.getString("material"));
				((Juguete) prod).setArticulable(rs.getString("articulable"));
				((Juguete) prod).setEdadMinima(rs.getInt("edad_minima"));
				((Juguete) prod).setPilas(rs.getString("pilas"));
				listaProd.put(prod.getCodigoProducto(), prod);

			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println("Error en cierre del ResultSet");
				}
			}
			try {
				this.closeConnection();
			} catch (SQLException e) {

				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}
		return listaProd;
	}

	public Map<String, Producto> listarProdPeli() {
		ResultSet rs = null;
		Producto prod;
		Map<String, Producto> listaProd = new HashMap<>();

		this.openConnection();

		try {
			stmt = con.prepareStatement(SELECT_PROD_PELI);

			rs = stmt.executeQuery();

			while (rs.next()) {
				prod = new Pelicula_Serie();
				prod.setCodigoProducto(rs.getString("codigo_producto"));
				prod.setNombre(rs.getString("nombre"));
				prod.setPrecio(rs.getFloat("precio"));
				prod.setPeso(rs.getFloat("peso"));
				prod.setNumExistencias(rs.getInt("num_existencias"));
				prod.setDimensiones(rs.getString("dimensiones"));
				((Pelicula_Serie) prod).setGenero(rs.getString("genero"));
				((Pelicula_Serie) prod).setFechaLanzamiento(rs.getString("fecha_de_lanzamiento"));
				((Pelicula_Serie) prod).setIdioma(rs.getString("idioma"));
				((Pelicula_Serie) prod).setSubtitulado(rs.getString("subtitulado"));
				((Pelicula_Serie) prod).setDuracion(rs.getString("duracion"));
				listaProd.put(prod.getCodigoProducto(), prod);

			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			// Cerramos ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println("Error en cierre del ResultSet");
				}
			}
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}
		return listaProd;
	}

	public void insertarPersona(Persona pers) {
		this.openConnection();

		try {
			stmt = con.prepareStatement(INSERT_PERSONA);

			stmt.setString(1, pers.getCodigoPersona());
			stmt.setString(2, pers.getNombre());
			stmt.setString(3, pers.getEmail());
			stmt.setInt(4, pers.getNumTelefono());
			stmt.setString(5, pers.getContrasena());
			if (stmt.executeUpdate() == 1) {
				if (pers instanceof Usuario) {
					stmt = con.prepareStatement(INSERT_USUARIO);

					stmt.setString(1, pers.getCodigoPersona());
					stmt.setLong(2, ((Usuario) pers).getNumeroTarjeta());
					stmt.setString(3, ((Usuario) pers).getNombrePersonal());
					stmt.setString(4, ((Usuario) pers).getApellido());
					stmt.setString(5, (((Usuario) pers).getFecha_nacimiento()));
					stmt.setString(6, ((Usuario) pers).getDireccion());

					stmt.executeUpdate();
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.closeConnection();
		} catch (SQLException e) {
			// TODO Auto- generated catch block
			e.printStackTrace();
		}

	}

	public void insertarTarjeta(Tarjeta tar) {
		this.openConnection();

		try {
			stmt = con.prepareStatement(INSERT_TARJETA);

			stmt.setString(1, tar.getNumeroTarjeta());
			stmt.setInt(2, tar.getCVV());

			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.closeConnection();
		} catch (SQLException e) {
			// TODO Auto- generated catch block
			e.printStackTrace();
		}

	}

	public int numeroPersona(Persona pers) {
		ResultSet rs = null;
		String numPersona = "SELECT COUNT(codigo_persona)FROM persona";
		int n = 0;
		this.openConnection();

		try {
			stmt = con.prepareStatement(numPersona);
			rs = stmt.executeQuery();
			if (rs.next()) {
				// Si hay resultados obtengo el valor.
				n = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return n;

	}

	public int existePersona(String persona) {

		ResultSet rs = null;
		String registrar = "SELECT COUNT(codigo_persona)FROM PERSONA WHERE NOMBRE=?";
		this.openConnection();

		try {
			stmt = con.prepareStatement(registrar);
			stmt.setString(1, persona);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return rs.getInt(1);
			}
			return 1;

		} catch (SQLException e) {
			e.printStackTrace();

			return 1;

		}

	}

	public int existeNumeroTarjeta(long numeroTarjeta) {

		ResultSet rs = null;
		String registrar = "SELECT count(numero_tarjeta) FROM TARJETA WHERE numero_tarjeta=?";
		this.openConnection();

		try {
			stmt = con.prepareStatement(registrar);
			stmt.setLong(1, numeroTarjeta);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return rs.getInt(1);
			}
			return 1;

		} catch (SQLException e) {
			e.printStackTrace();

			return 1;

		}

	}

	public boolean esEmail(String email) {
		// Patr�n para validar el email
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		// El email a validar

		Matcher mather = pattern.matcher(email);

		return mather.find();
	}

	public int existeTelefono(int numTelefono) {

		ResultSet rs = null;

		String registrar = "SELECT count(codigo_persona) FROM PERSONA WHERE num_telefono=?";

		this.openConnection();

		try {

			stmt = con.prepareStatement(registrar);

			stmt.setInt(1, numTelefono);

			rs = stmt.executeQuery();

			if (rs.next()) {

				return rs.getInt(1);

			}

			return 1;

		} catch (SQLException e) {

			e.printStackTrace();

			return 1;

		}

	}

	public int existeEmail(String email) {

		ResultSet rs = null;

		String registrar = "SELECT COUNT(codigo_persona)FROM PERSONA WHERE EMAIL=?";

		this.openConnection();

		try {

			stmt = con.prepareStatement(registrar);

			stmt.setString(1, email);

			rs = stmt.executeQuery();

			if (rs.next()) {

				return rs.getInt(1);

			}

			return 1;

		} catch (SQLException e) {

			e.printStackTrace();

			return 1;

		}

	}

}