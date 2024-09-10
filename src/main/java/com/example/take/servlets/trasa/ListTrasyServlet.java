package com.example.take.servlets.trasa;

import com.example.take.entities.Trasa;

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

@WebServlet("/listTrasy")
public class ListTrasyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        try {
            List<Trasa> trasy = em.createQuery("SELECT t FROM Trasa t", Trasa.class).getResultList();
            request.setAttribute("trasy", trasy);
            request.getRequestDispatcher("/listTrasy.jsp").forward(request, response);
        } finally {
            em.close();
        }
    }
}
