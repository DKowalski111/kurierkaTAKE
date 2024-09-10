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

@WebServlet("/editPaczka")
public class EditPaczkaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idP = Integer.parseInt(request.getParameter("id"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        Paczka paczka = em.find(Paczka.class, idP);

        em.close();
        emf.close();

        request.setAttribute("paczka", paczka);
        request.getRequestDispatcher("editPaczka.jsp").forward(request, response);
    }
}
