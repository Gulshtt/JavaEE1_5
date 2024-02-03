package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Developer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();

            pw.print("<form action=\"/home\" method=\"post\">");
            pw.print("<label>NAME:</label>");
            pw.print("<input name=\"name\" type=\"text\" style=\"margin-left:30px;\">");
            pw.print("<br>");
            pw.print("<label>SURNAME:</label>");
            pw.print("<input name=\"surname\" type=\"text\" style=\"margin-left:30px;\">");
            pw.print("<br>");
            pw.print("<button>SEND</button>");
            pw.print("</form>");

       /* for(int i; i=0; i<10){
            pw.println("<h1>Salem alem!</h1>");
        }
        */
/*
        List<Developer> developers = new ArrayList<>();
        developers.add(new Developer("Даулет", "Д", "IT", 500000));
        developers.add(new Developer("Тили", "Т", "IT", 500000));
        developers.add(new Developer("Амир", "А", "IT", 500000));
        developers.add(new Developer("Абылай", "А", "IT", 500000));
        developers.add(new Developer("Дарын", "Д", "IT", 500000));
        developers.add(new Developer("Жансая", "Ж", "IT", 500000));
        developers.add(new Developer("Дина", "Д", "IT", 500000));
        developers.add(new Developer("Гульшат", "Г", "IT", 500000));
        developers.add(new Developer("Баглан", "Б", "IT", 500000));
        developers.add(new Developer("Райхан", "Р", "IT", 500000));
        developers.add(new Developer("Асыл", "А", "IT", 500000));
        developers.add(new Developer("Альбина", "А", "IT", 500000));
        developers.add(new Developer("Куляш", "К", "IT", 500000));
        developers.add(new Developer("Ажара", "А", "IT", 500000));
        developers.add(new Developer("Арман", "А", "IT", 500000));
        developers.add(new Developer("Ерасыл", "Е", "IT", 500000));
        developers.add(new Developer("Асель", "А", "IT", 500000));

        request.setAttribute("razraby",developers);
        //request.getRequestDispatcher("home.jsp").forward(request, response);
*/
    }
}
