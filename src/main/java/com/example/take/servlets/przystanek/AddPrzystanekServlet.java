package com.example.take.servlets.przystanek;

import com.example.take.entities.Przystanek;

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
import java.time.LocalTime;

@WebServlet("/addPrzystanek")
public class AddPrzystanekServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dystans = Integer.parseInt(request.getParameter("dystans"));
        LocalTime czas = LocalTime.parse(request.getParameter("czas"));
        String adresPocz = request.getParameter("adres_pocz");
        String adresKon = request.getParameter("adres_kon");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Przystanek przystanek = new Przystanek();
            przystanek.setDystans(dystans);
            przystanek.setCzas(czas);
            przystanek.setAdres_pocz(adresPocz);
            przystanek.setAdres_kon(adresKon);
            em.persist(przystanek);
            transaction.commit();
            response.sendRedirect("listPrzystanki");
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Błąd podczas dodawania przystanku.");
        } finally {
            em.close();
        }
    }
}
