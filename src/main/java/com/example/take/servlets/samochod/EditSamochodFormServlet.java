package com.example.take.servlets.samochod;

import com.example.take.entities.Samochod;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.IOException;

@WebServlet("/editSamochodForm")
public class EditSamochodFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_S = Integer.parseInt(request.getParameter("id_S"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        try {
            Samochod samochod = em.find(Samochod.class, id_S);
            request.setAttribute("samochod", samochod);
            request.getRequestDispatcher("editSamochodForm.jsp").forward(request, response);
        } finally {
            em.close();
        }
    }
}
