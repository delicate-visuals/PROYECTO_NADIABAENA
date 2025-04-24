package com.trueconnect.trueconnectrecom.controllers;

import com.trueconnect.trueconnectrecom.BBDD.DAO.RecomendacionDAO;
import com.trueconnect.trueconnectrecom.models.Recomendacion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "RecomendacionServlet", urlPatterns = {"/recomendacion"})
public class InventoryController extends HttpServlet {

    private RecomendacionDAO recomendacionDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        recomendacionDAO = new RecomendacionDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "edit":
                editRecomendacion(request, response);
                break;
            case "delete":
                deleteRecomendacion(request, response);
                break;
            case "list":
            default:
                listRecomendaciones(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "save";

        if ("save".equals(action)) {
            saveRecomendacion(request, response);
        }
    }

    private void listRecomendaciones(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Recomendacion> recomendaciones = null;
        try {
            recomendaciones = recomendacionDAO.GetAllRecomendaciones();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("listaRecomendaciones", recomendaciones);

        RequestDispatcher dispatcher = request.getRequestDispatcher("list-recomendaciones.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("recomendacion-form.jsp");
        dispatcher.forward(request, response);
    }

    private void editRecomendacion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idRecomendacion = Integer.parseInt(request.getParameter("id"));
        Recomendacion recomendacion = null;
        try {
            recomendacion = recomendacionDAO.GetRecomendacionById(idRecomendacion);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("recomendacion", recomendacion);
        RequestDispatcher dispatcher = request.getRequestDispatcher("recomendacion-form.jsp");
        dispatcher.forward(request, response);
    }

    private void saveRecomendacion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("idRecomendacion");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");

        int idInv = (idParam == null || idParam.isEmpty()) ? 0 : Integer.parseInt(idParam);

        Recomendacion inv = new Recomendacion();
        inv.setNombre(nombre);
        inv.setDescripcion(descripcion);

        try{
            if (idInv == 0) {
                recomendacionDAO.AddRecomendacion(inv);
            } else {
                inv.setIdRecomendacion(idInv);
                recomendacionDAO.UpdateRecomendacion(inv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("recomendacion?action=list");
    }

    private void deleteRecomendacion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idRecomendacion = Integer.parseInt(request.getParameter("id"));
        try {
            recomendacionDAO.DeleteRecomendacion(idRecomendacion);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("recomendacion?action=list");
    }
}