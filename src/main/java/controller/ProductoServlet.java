package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Producto;
import services.LoginService;
import services.ProductoService;
import services.ProductoServiceImplement;
import services.loginServiceImplement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

//Creamos nuestros path
@WebServlet({"/productoServlet", "/productos"})
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImplement();
        List<Producto> productos = service.listar();
        LoginService auth = new loginServiceImplement();
        Optional<String> usernameOptional = auth.getUserName(req);

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Carrito</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Listado de productos</h2>");
            if (usernameOptional.isPresent()) {
                out.println("<div style='color:blue;'>Hola" + usernameOptional.get() + "Bienvenido!</div>");
            }
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>id</th>");
            out.println("<th>Nombre</th>");
            out.println("<th>Categoria</th>");
            out.println("<th>Descripcion</th>");
            if (usernameOptional.isPresent()) {
                out.println("<th>Precio</th>");
            }
            out.println("</tr>");
            productos.forEach(producto -> {
                out.println("<tr>");
                out.println("<td>" + producto.getId() + "</td>");
                out.println("<td>" + producto.getNombre() + "</td>");
                out.println("<td>" + producto.getCategoria() + "</td>");
                out.println("<td>" + producto.getDescripcion() + "</td>");
                if (usernameOptional.isPresent()) {
                    out.println("<td>" + producto.getPrecio() + "</td>");
                }
                out.println("</tr>");

            });
            out.println("</table>");
            out.println("<br>");
            out.println("<ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}