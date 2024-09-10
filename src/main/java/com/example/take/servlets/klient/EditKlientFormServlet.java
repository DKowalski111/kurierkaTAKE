package com.example.take.servlets.klient;

import com.example.take.entities.Klient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/editKlientForm")
public class EditKlientFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idK = request.getParameter("id_K");
        if (idK != null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
            EntityManager em = emf.createEntityManager();
            Klient klient = em.find(Klient.class, Integer.parseInt(idK));
            em.close();

            if (klient != null) {
                request.setAttribute("klient", klient);
                request.getRequestDispatcher("editKlient.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Nie znaleziono klienta o podanym ID.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID klienta nie zostało podane.");
        }
    }
}
