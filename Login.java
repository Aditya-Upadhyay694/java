package P1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	private HttpSession session;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession(true);
		String custid=request.getParameter("custid");
		String pwd=request.getParameter("pwd");
		System.out.println("I am in login");
		
		
		try{
			Model m=new Model();
			m.setCustid(custid);
			m.setPwd(pwd);
			boolean b=m.login();
			
			if(b==true){
				session.setAttribute("accno", m.getAccno());
				session.setAttribute("name", m.getName());
				//session.setAttribute("Balance",m.getBalance());
				//session.setAttribute("email",m.getEmail());
				response.sendRedirect("/BANK/Home.html");
			}
			else{
				response.sendRedirect("/BANK/Error.html");
			}
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
