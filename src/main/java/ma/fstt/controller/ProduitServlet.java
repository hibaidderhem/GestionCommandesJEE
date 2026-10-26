package ma.fstt.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.fstt.dao.ProduitDao;
import ma.fstt.entities.Produit;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ProduitServlet")
public class ProduitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProduitDao produitDao;

    public void init() {
        produitDao = new ProduitDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Produit p = new Produit();
                p.setIdProduit(id);
                produitDao.delete(p);
                response.sendRedirect("ProduitServlet");
            } else {
                List<Produit> produits = produitDao.findAll();
                request.setAttribute("produits", produits);
                request.getRequestDispatcher("produits.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        double prix = Double.parseDouble(request.getParameter("prix"));
        int quantiteStock = Integer.parseInt(request.getParameter("quantiteStock"));

        Produit produit = new Produit(nom, prix, quantiteStock);
        try {
            produitDao.save(produit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("ProduitServlet");
    }
}