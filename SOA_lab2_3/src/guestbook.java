import notDefault.GuestData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

@WebServlet(name = "guestbook")
public class guestbook extends HttpServlet {
    Vector<GuestData> guests = new Vector<>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");
        PrintWriter out = response.getWriter();
        GuestData guest = new GuestData();
        guest.name = request.getParameter("name");
        guest.email = request.getParameter("email");
        guest.feedback = request.getParameter("feedback");

        guests.add(guest);

        request.setAttribute("guests", guests);

        request.getRequestDispatcher("/guestbook.jsp").forward(request, response);
    }
}
