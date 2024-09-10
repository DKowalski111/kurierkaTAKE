package com.example.take.servlets.samochod;

import com.example.take.entities.Samochod;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listSamochody")
public class ListSamochodyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Samochod> query = em.createQuery("SELECT s FROM Samochod s", Samochod.class);
        List<Samochod> samochody = query.getResultList();

        em.close();
        emf.close();

        request.setAttribute("samochody", samochody);
        request.getRequestDispatcher("listSamochody.jsp").forward(request, response);
    }
}
