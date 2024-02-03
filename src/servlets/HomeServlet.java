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
            pw.print("<label> FULL NAME:</label>");
            pw.print("<input name='name' type='text' style='margin-left:30px;'>");
            pw.print("<br>");
            pw.print("<label>AGE:</label>");
            pw.print("<input name='age' type='number' style='margin-left:30px;'>");
            pw.print("<br>");
            pw.print("<div style='display: flex'>");
            pw.print("<label>GENDER:</label>");
            pw.print("<div>");
            pw.print("<input type='radio' name='male'> male");
            pw.print("<br>");
            pw.print("<input type='radio' name='female'> female");
            pw.print("</div>");
            pw.print("</div>");
            pw.print("<br>");
            pw.print("<button>SEND</button>");
            pw.print("</form>");

            if(DBManager.user.getName()!=null) {

                if (DBManager.user.getAge() <= 15) {
                    User u = DBManager.user;
                    pw.print("<h>Hello Dude " + u.getName() + "!</h>");
                } else {
                    User u = DBManager.user;
                    pw.print("<h>Hello Dear " + u.getName() + "!</h>");
                }
            }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        int age = Integer.parseInt(req.getParameter("age"));
        DBManager.user.setName(name);
        DBManager.user.setGender(gender);
        DBManager.user.setAge(age);
        resp.sendRedirect("/home");
    }
}
