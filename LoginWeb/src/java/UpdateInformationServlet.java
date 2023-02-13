import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateInformationServlet")
public class UpdateInformationServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Get the updated information from the request parameters
    String firstname = request.getParameter("firstname");
    String lastname = request.getParameter("lastname");
    String email = request.getParameter("email");

    // Connect to the database
    Connection conn = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/admission", "root", ""
      );
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }

    // Update the information in the database
    try {
      PreparedStatement stmt = conn.prepareStatement("UPDATE student SET Email=?, lastName=? WHERE firstName=?");
      stmt.setString(1, email);
      stmt.setString(2, lastname);
      stmt.setString(3, firstname);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    // Redirect to the information page
   System.out.println("information updated");
  }
}
