package ejemplos.servlet.curso;

import ejemplos.clases.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/myServlet2")
public class MyServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Usuario usuario = GetUser(request);
		request.setAttribute("usuario", usuario);
		request.setAttribute("emoji", "&#128546; &#128546; &#128546; &#128546;");

		RequestDispatcher _redirect = request.getRequestDispatcher("views/users/WelcomeUsuario.jsp");
		_redirect.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
		//super.doPost(httpServletRequest, httpServletResponse);

		Usuario usuario = GetUser(httpServletRequest);
		httpServletRequest.setAttribute("usuario", usuario);
		httpServletRequest.setAttribute("emoji", "&#128526; &#128526; &#128526;");

		RequestDispatcher _redirect = httpServletRequest.getRequestDispatcher("views/users/WelcomeUsuario.jsp");
		_redirect.forward(httpServletRequest, httpServletResponse);
	}

	private Usuario GetUser(HttpServletRequest eRequest) {
		String nameIn = eRequest.getParameter("fname") != null ? eRequest.getParameter("fname") : "";
		String lastNameIn = eRequest.getParameter("lname") != null ? eRequest.getParameter("lname") : "";

		if (nameIn.isEmpty()) nameIn = "xxx";
		if (lastNameIn.isEmpty()) lastNameIn = "xxx";

		return new Usuario(nameIn, lastNameIn);
	}

}