package no.steras;

import java.io.IOException;
import java.io.Writer;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/print")
public class PrinterServlet extends HttpServlet {

	@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("test att", "test att");
		req.getSession().setAttribute("test sess", "test sess");
		
		
		Writer w = resp.getWriter();
		resp.setContentType("text/html");
		w.append("<html>" + "<head></head>" + "<body>");

		// Print all cookies with properties
		w.append("<b>Cookies</b>");
		for (Cookie cookie : req.getCookies()) {
			w.append("<br>");
			w.append("Name: " + cookie.getName());
			w.append("<br>");
			w.append("Comment: " + cookie.getComment());
			w.append("<br>");
			w.append("Domain: " + cookie.getDomain());
			w.append("<br>");
			w.append("MaxAge: " + cookie.getMaxAge());
			w.append("<br>");
			w.append("Path: " + cookie.getPath());
			w.append("<br>");
			w.append("Value: " + cookie.getValue());
			w.append("<br>");
			w.append("Version: " + cookie.getVersion());
			w.append("<br>");
			w.append("Secure: " + cookie.getSecure());
			w.append("<br>");
		}
		w.append("<br>");
		
		// Print all session attriutes
		w.append("<b>Session attributes</b>");

		for (String attributeName : Collections.list(req.getSession().getAttributeNames())) {
			w.append("<br>");
			w.append("Name: " + attributeName);
			w.append("<br>");
			w.append("Value: " + req.getSession().getAttribute(attributeName));
			w.append("<br>");
		}
		w.append("<br>");

		// Print all headers
		w.append("<b>Headers</b>");

		for (String headerName : Collections.list(req.getHeaderNames())) {
			w.append("<br>");
			w.append("Name: " + headerName);
			w.append("<br>");
			w.append("Value: " + req.getHeader(headerName));
			w.append("<br>");
		}
		w.append("<br>");
		// Print all headers
		w.append("<b>Request attributes</b>");

		for (String attributeName : Collections.list(req.getAttributeNames())) {
			w.append("<br>");
			w.append("Name: " + attributeName);
			w.append("<br>");
			w.append("Value: " + req.getAttribute(attributeName));
			w.append("<br>");
		}

		w.append("</body><html>");
	}
}
