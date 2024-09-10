package com.example.take.servlets.paczka;

import com.example.take.entities.Paczka;
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

@WebServlet("/listPaczki")
public class ListPaczkiServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Paczka> query = em.createQuery("SELECT p FROM Paczka p", Paczka.class);
        List<Paczka> paczki = query.getResultList();

        em.close();
        emf.close();

        request.setAttribute("paczki", paczki);
        request.getRequestDispatcher("listPaczki.jsp").forward(request, response);
    }
}
