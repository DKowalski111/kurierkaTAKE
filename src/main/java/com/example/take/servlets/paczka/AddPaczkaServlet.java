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

@WebServlet("/addPaczka")
public class AddPaczkaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String miejsceNadania = request.getParameter("miejsceNadania");
        String miejsceDostarczenia = request.getParameter("miejsceDostarczenia");
        String dataNadania = request.getParameter("dataNadania");
        String status = request.getParameter("status");
        String rozmiar = request.getParameter("rozmiar");
        double waga = Double.parseDouble(request.getParameter("waga"));

        Paczka paczka = new Paczka();
        paczka.setMiejsce_nad(miejsceNadania);
        paczka.setMiejsce_dost(miejsceDostarczenia);
        paczka.setData_nad(dataNadania);
        paczka.setStatus(status);
        paczka.setRozmiar(rozmiar);
        paczka.setWaga(waga);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(paczka);
        em.getTransaction().commit();

        em.close();
        emf.close();

        response.sendRedirect("success.jsp");
    }
}

