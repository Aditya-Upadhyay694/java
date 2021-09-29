package P1;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = { "/ChangeNpwdFilter" }, servletNames = { "Credential1" })
public class ChangeNpwdFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {String npwd=request.getParameter("npwd");
	String npwd1=request.getParameter("npwd1");
	String cpwd=request.getParameter("cpwd");
	if(npwd1.equals(cpwd)==true){
		chain.doFilter(request,response);
	}
	else{
		((HttpServletResponse)response).sendRedirect("/Bank/ERROR1.html");
	}
	
	}

}
