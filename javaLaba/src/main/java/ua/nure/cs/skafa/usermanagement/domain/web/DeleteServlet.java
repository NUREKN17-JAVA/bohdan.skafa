package ua.nure.cs.skafa.usermanagement.domain.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;

import ua.nure.cs.skafa.usermanagement.domain.User;
import ua.nure.cs.skafa.usermanagement.domain.db.DaoFactory;
import ua.nure.cs.skafa.usermanagement.domain.db.DatabaseException;

public class DeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1634909037211803672L;

    protected void doOk(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
           DaoFactory.getInstance().getUserDao().delete((User) req.getSession().getAttribute("user"));
       } catch (DatabaseException e) {
           req.setAttribute("error", "Error in the database: " + e.getMessage());
           req.getRequestDispatcher("/delete.jsp").forward(req, resp);
       }
       req.getRequestDispatcher("/browse").forward(req, resp);
   }

    protected void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("/delete.jsp").forward(req, resp);

    }
}
