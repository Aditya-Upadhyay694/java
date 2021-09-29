package P1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession();
	    int accno=(int)session.getAttribute("accno");
	
	try{
		Model m=new Model();
		m.setAccno(accno);
		boolean b=m.checkBalance();
		if(b==true){
			session.setAttribute("name", m.getName());
			session.setAttribute("balance",m.getBalance());
			response.sendRedirect("/BANK/Balance.jsp");
		}
		else{
			response.sendRedirect("/BANK/ErrorBalance.html");
		}	
	}
	
	catch(Exception e){
		e.printStackTrace();
	}
  }
}
