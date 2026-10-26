package ma.fstt.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.fstt.dao.ClientDao;
import ma.fstt.entities.Client;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClientDao clientDao;

    public void init() {
        clientDao = new ClientDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Client c = new Client();
                c.setIdClient(id);
                clientDao.delete(c);
                response.sendRedirect("ClientServlet");
            } else {
                List<Client> clients = clientDao.findAll();
                request.setAttribute("clients", clients);
                request.getRequestDispatcher("clients.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");

        Client client = new Client(nom, prenom, email, telephone);
        try {
            clientDao.save(client);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("ClientServlet");
    }
}