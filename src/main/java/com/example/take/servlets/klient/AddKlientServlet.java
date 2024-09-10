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
import java.time.LocalDate;

@WebServlet("/addKlient")
public class AddKlientServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imie = request.getParameter("imie");
        String nazwisko = request.getParameter("nazwisko");
        LocalDate dataUr = LocalDate.parse(request.getParameter("data_ur"));
        String nrTel = request.getParameter("nr_tel");
        String adres = request.getParameter("adres");

        Klient klient = new Klient();
        klient.setImie(imie);
        klient.setNazwisko(nazwisko);
        klient.setData_ur(dataUr);
        klient.setNr_tel(nrTel);
        klient.setAdres(adres);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(klient);
            transaction.commit();
            response.sendRedirect("listKlienci");
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Błąd podczas dodawania klienta.");
        } finally {
            em.close();
        }
    }
}
