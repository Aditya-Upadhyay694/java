package P1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Credential1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	session=	request.getSession();
	String email=(String)session.getAttribute("email");
	String npwd=request.getParameter("npwd");
	try{
		Model m=new Model();
		m.setEmail(email);
		m.setPwd(npwd);
        boolean b=m.forgotPwd();
if(b==true){
	response.sendRedirect("/BANK/Success.html");
}
else{
	response.sendRedirect("/BANK/ERROR.html");
}
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
		
	}

}
