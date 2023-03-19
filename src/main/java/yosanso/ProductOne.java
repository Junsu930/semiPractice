package yosanso;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductOne
 */
@WebServlet("/productOne")
public class ProductOne extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}


	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		int proNo = Integer.parseInt(request.getParameter("proNo"));
		
		Template tp = new Template();
		
		Product pd = tp.buyOne(proNo);
		
		String json = "{\"productNo\" : \"" + pd.getProductNo() + "\", \"productName\" : \"" + pd.getProductName()
		+ "\", \"category\" : \"" + pd.getCategory() + "\", \"price\" : \"" + pd.getPrice() + "\"}";
		

		
		pw.write(json);
			
	}


}
