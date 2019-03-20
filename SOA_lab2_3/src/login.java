import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

@WebServlet(name = "login")
public class login extends HttpServlet {
    Vector<DaneOsobowe> users = new Vector<>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1250");
        PrintWriter out = response.getWriter();

        String login = request.getParameter("login");
        String password = request.getParameter("haslo");
        String error = "";
        if (login.equals("")){
            error += "Podano pusty login. ";
            if (password.equals("")){
                error += "Podano puste hasło.";
            }
            ServletContext context = this.getServletContext();
            RequestDispatcher disp = context.getRequestDispatcher("/index.jsp?error=" + error);
            disp.forward(request, response);
        }
        else if (password.equals("")){
            error += "Podano puste hasło.";
            ServletContext context = this.getServletContext();
            RequestDispatcher disp = context.getRequestDispatcher("/index.jsp?error=" + error);
            disp.forward(request, response);
        }
        else if (!checkLogin(login, password)){
            error = "Nie ma takiego użytkownika/takiej użytkowniczki.";
            ServletContext context = this.getServletContext();
            RequestDispatcher disp = context.getRequestDispatcher("/index.jsp?error=" + error);
            disp.forward(request, response);
        }

        else{
            ServletContext context = this.getServletContext();
            RequestDispatcher disp = context.getRequestDispatcher("/guestbook.jsp");
            disp.forward(request, response);
        }


    }

    private boolean checkLogin(String login, String password) {
        if(users.isEmpty()){
            users.add(new DaneOsobowe("login", "haslo", "Anna", "Krzaczek"));
            users.add(new DaneOsobowe("login2", "haslo2", "Marian", "Lama"));
        }
        for(DaneOsobowe d:users){
            if(d.login.equals(login)){
                return d.haslo.equals(password);
            }
        }
        return false;
    }


}
