package ma.fstt.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.fstt.dao.CommandeDao;
import ma.fstt.entities.Commande;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/CommandeServlet")
public class CommandeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CommandeDao commandeDao;

    public void init() {
        commandeDao = new CommandeDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Commande c = new Commande();
                c.setIdCommande(id);
                commandeDao.delete(c);
                response.sendRedirect("CommandeServlet");
            } else {
                List<Commande> commandes = commandeDao.findAll();
                request.setAttribute("commandes", commandes);
                request.getRequestDispatcher("commandes.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idClient = Integer.parseInt(request.getParameter("idClient"));

        Commande commande = new Commande();
        commande.setIdClient(idClient);
        try {
            commandeDao.save(commande);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("CommandeServlet");
    }
}