package com.example.take.servlets.trasa;

import com.example.take.entities.Przystanek;
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
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addTrasa")
public class AddTrasaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dystans = Integer.parseInt(request.getParameter("dystans"));
        LocalTime czas = LocalTime.parse(request.getParameter("czas"));
        String przystankiStr = request.getParameter("przystanki");

        List<Przystanek> listaPrzystankow = new ArrayList<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Trasa trasa = new Trasa();
            trasa.setDystans(dystans);
            trasa.setCzas(czas);

            if (przystankiStr != null && !przystankiStr.isEmpty()) {
                String[] ids = przystankiStr.split(",");
                for (String id : ids) {
                    Przystanek przystanek = em.find(Przystanek.class, Integer.parseInt(id.trim()));
                    if (przystanek != null) {
                        listaPrzystankow.add(przystanek);
                    }
                }
            }
            trasa.setLista_przystankow(listaPrzystankow);
            em.persist(trasa);
            transaction.commit();
            response.sendRedirect("listTrasy");
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Błąd podczas dodawania trasy.");
        } finally {
            em.close();
        }
    }
}
