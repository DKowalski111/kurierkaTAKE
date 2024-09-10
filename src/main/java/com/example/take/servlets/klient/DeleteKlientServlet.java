package com.example.take.servlets.klient;

import com.example.take.entities.Klient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deleteKlient")
public class DeleteKlientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idK = request.getParameter("id_K");
        if (idK != null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
            EntityManager em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            try {
                transaction.begin();
                Klient klient = em.find(Klient.class, Integer.parseInt(idK));
                if (klient != null) {
                    em.remove(klient);
                    transaction.commit();
                } else {
                    transaction.rollback();
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Nie znaleziono klienta o podanym ID.");
                    return;
                }
                response.sendRedirect("listKlienci");
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Błąd podczas usuwania klienta.");
            } finally {
                em.close();
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID klienta nie zostało podane.");
        }
    }
}
