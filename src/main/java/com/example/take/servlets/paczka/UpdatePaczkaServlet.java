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

@WebServlet("/updatePaczka")
public class UpdatePaczkaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idP = Integer.parseInt(request.getParameter("idP"));
        String miejsceNadania = request.getParameter("miejsceNadania");
        String miejsceDostarczenia = request.getParameter("miejsceDostarczenia");
        String status = request.getParameter("status");
        String rozmiar = request.getParameter("rozmiar");
        double waga = Double.parseDouble(request.getParameter("waga"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Paczka paczka = em.find(Paczka.class, idP);
        paczka.setMiejsce_nad(miejsceNadania);
        paczka.setMiejsce_dost(miejsceDostarczenia);
        paczka.setStatus(status);
        paczka.setRozmiar(rozmiar);
        paczka.setWaga(waga);
        em.getTransaction().commit();

        em.close();
        emf.close();

        response.sendRedirect("listPaczki");
    }
}

