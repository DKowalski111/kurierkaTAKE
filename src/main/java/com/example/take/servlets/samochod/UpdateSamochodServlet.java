package com.example.take.servlets.samochod;

import com.example.take.entities.Samochod;

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

@WebServlet("/updateSamochod")
public class UpdateSamochodServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_S = Integer.parseInt(request.getParameter("id_S"));
        String marka = request.getParameter("marka");
        String model = request.getParameter("model");
        int rokProdukcji = Integer.parseInt(request.getParameter("rok_produkcji"));
        String numerRej = request.getParameter("numer_rej");
        int przebieg = Integer.parseInt(request.getParameter("przebieg"));
        int iloscPaczek = Integer.parseInt(request.getParameter("ilosc_paczek"));
        boolean dostepnosc = Boolean.parseBoolean(request.getParameter("dostepnosc"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Samochod samochod = em.find(Samochod.class, id_S);
            if (samochod != null) {
                samochod.setMarka(marka);
                samochod.setModel(model);
                samochod.setRok_produkcji(rokProdukcji);
                samochod.setNumer_rej(numerRej);
                samochod.setPrzebieg(przebieg);
                samochod.setIlosc_paczek(iloscPaczek);
                samochod.setDostepnosc(dostepnosc);
                em.merge(samochod);
                transaction.commit();
            }
            response.sendRedirect("listSamochody");
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Błąd podczas aktualizacji samochodu.");
        } finally {
            em.close();
        }
    }
}
