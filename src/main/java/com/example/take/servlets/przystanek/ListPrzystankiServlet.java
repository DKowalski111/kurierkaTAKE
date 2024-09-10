package com.example.take.servlets.przystanek;

import com.example.take.entities.Przystanek;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.IOException;
import java.util.List;

@WebServlet("/listPrzystanki")
public class ListPrzystankiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        try {
            List<Przystanek> przystanki = em.createQuery("SELECT p FROM Przystanek p", Przystanek.class).getResultList();
            request.setAttribute("przystanki", przystanki);
            request.getRequestDispatcher("/listPrzystanki.jsp").forward(request, response);
        } finally {
            em.close();
        }
    }
}
