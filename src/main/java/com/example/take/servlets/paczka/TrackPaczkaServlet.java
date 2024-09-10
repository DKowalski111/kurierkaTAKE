package com.example.take.servlets.paczka;

import com.example.take.entities.Paczka;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/trackPaczka")
public class TrackPaczkaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPaczki = Integer.parseInt(request.getParameter("idPaczki"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        Paczka paczka = em.find(Paczka.class, idPaczki);
        em.close();
        emf.close();

        if (paczka != null) {
            request.setAttribute("paczka", paczka);
            request.getRequestDispatcher("trackResult.jsp").forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
