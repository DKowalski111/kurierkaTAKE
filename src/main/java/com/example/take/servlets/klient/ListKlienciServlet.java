package com.example.take.servlets.klient;

import com.example.take.entities.Klient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listKlienci")
public class ListKlienciServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Klient> query = em.createQuery("SELECT k FROM Klient k", Klient.class);
        List<Klient> klienci = query.getResultList();

        em.close();
        emf.close();

        request.setAttribute("klienci", klienci);
        request.getRequestDispatcher("listKlienci.jsp").forward(request, response);
    }
}
