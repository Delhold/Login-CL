package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.LoginService;
import services.loginServiceImplement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

//CREAMOS EL PATH PARA LA CONEXION AL (SERVLET)
@WebServlet({"/Login", "/ServletLogin"})
public class ServletLogin extends HttpServlet {
    final static String USERNAME = "admin";
    final static String PASSWORD = "1234";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        LoginService auth = new loginServiceImplement();
        Optional<String> usernameOptional = auth.getUserName(request);
        if (usernameOptional.isPresent()) {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>ServletLogin</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Iniciado la sesion Correctamente" + usernameOptional.get() + "</h1>");
                out.println("<p><a href='" + request.getContextPath() + "/index.html'>volver</a></p>");
                out.println("<p><a href='" + request.getContextPath() + "/logout'>cerrar sesión</a></p>");
                out.println("</body>");
                out.println("</html>");
            }

        }else{
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
    //SOBRESCRIBIMOS EL METODO "DO POST"
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            HttpSession session = request.getSession();
            //Seteamos los datos
            session.setAttribute("username", username);
            //REDIRECCIONA AL HTML
            response.sendRedirect(request.getContextPath() + "/ServletLogin");
        }else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "no esta autorizado para ingresar al sistema0");
        }
    }
}
