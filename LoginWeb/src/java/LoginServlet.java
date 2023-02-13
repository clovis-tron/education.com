import com.sms.model.Student;
import com.sms.model.login;
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String email = request.getParameter("email");
    String password = request.getParameter("password");
 
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
 
    Student user = (Student) session.createQuery("FROM Student where Email = :Email and Password = :Password")
        .setParameter("Email", email)
        .setParameter("Password", password)
        .uniqueResult();
     System.out.println(user.getEmail()); 
         
    if (user != null) {
      request.getSession().setAttribute("email", email);
      response.sendRedirect("Continue.html");
    } else {
      response.sendRedirect("login.html?error=Invalid username or password.");
    }
    session.close();
  }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
