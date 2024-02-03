package servlets;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();

            pw.print("<form action='/home' method='post'>");
            pw.print("<label>NAME:</label>");
            pw.print("<input name='name' type='text' style='margin-left:30px;'>");
            pw.print("<br>");
            pw.print("<label>SURNAME:</label>");
            pw.print("<input name='surname' type='text' style='margin-left:30px;'>");
            pw.print("<br>");
            pw.print("<label>FOOD:</label>");
            pw.print("<select name='food'>");
            pw.print("<option value='Manty-900 KZT'>Manty-900 KZT</option>");
            pw.print("<option value='Pelmen-600 KZT'>Pelmen-600 KZT</option>");
            pw.print("<option value='Lagman-800 KZT'>Lagman-800 KZT</option>");
            pw.print("</select>");
            pw.print("<br>");
            pw.print("<button>SEND</button>");
            pw.print("</form>");
            if(DBManager.user.getName()!=null){
                User u = DBManager.user;
                pw.print("<h>" + u.getName() +" "+ u.getSurname() +" is ordered " + u.getFood() + "</h>");
            }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String food = req.getParameter("food");
        DBManager.user.setName(name);
        DBManager.user.setSurname(surname);
        DBManager.user.setFood(food);
        resp.sendRedirect("/home");
    }
}
