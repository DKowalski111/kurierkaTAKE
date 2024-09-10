package com.example.take.servlets.trasa;

import com.example.take.entities.Trasa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.io.IOException;

@WebServlet("/deleteTrasa")
public class DeleteTrasaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_T = Integer.parseInt(request.getParameter("id"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Trasa trasa = em.find(Trasa.class, id_T);
            if (trasa != null) {
                em.remove(trasa);
                transaction.commit();
            }
            response.sendRedirect("listTrasy");
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Błąd podczas usuwania trasy.");
        } finally {
            em.close();
        }
    }
}
