package P1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetStatement extends HttpServlet {
	private HttpSession session;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession();
		int accno=(int)session.getAttribute("accno");
		try{
			Model m=new Model();
			m.setAccno(accno);
			ArrayList al=m.getStatemnet();
			if(al.isEmpty()!=true){
				session.setAttribute("al1", m.al1);
				session.setAttribute("al2", m.al2);
				response.sendRedirect("/BANK/Statement.jsp");
			}
			else{
				response.sendRedirect("/BANK/StatementFail.html");
			}
}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
