import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "drugi")
public class drugi extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");
        PrintWriter out = response.getWriter();
        String l = request.getParameter("liczby");
        ArrayList<Float> sprawdzone = new ArrayList<>();
        String resp = "";

        try{
            String[] liczby = l.split(",");
            for(int i = 0; i < liczby.length; i++){
                try{
                    sprawdzone.add(Float.parseFloat(liczby[i]));
                } catch(NumberFormatException ex) {
                    resp = "Podaj dane w odpowiedniej formie.";
                    break;
                }
            }

        } catch (NumberFormatException e){
            resp = "Podaj dane w odpowiedniej formie.";
        }

        if(resp.isEmpty()) {
            Collections.sort(sprawdzone);
            resp = "Posortowana tablica: " + sprawdzone.toString();
        }

        out.println("<html>");
        out.println("<head><title>Sortowanie tablicy</title></head>");
        out.println("<body>");
        out.println("<p>" + resp + "</p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");
        PrintWriter out = response.getWriter();
        float mean = 0;
        for (int i=0; i<5; i++){
            mean += Integer.parseInt(request.getParameter("c"+(i+1)));
        }
        mean /= 5.0;
        out.println("<html>");
        out.println("<head><title>Srednia</title></head>");
        out.println("<body>");
        out.println("<p>Srednia wynosi " + mean + "</p>");
        out.println("</body>");
        out.println("</html>");
        out.close();

    }
}
