package com.srccodes.meteo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Random;

/**
 * Servlet implementation class ServletMeteo
 */
@WebServlet("/ServletMeteo")
public class ServletMeteo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    /*public ServletMeteo() {
        super();
        // TODO Auto-generated constructor stub
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("application/xml");
		
		//String stringa="";
		
		String[] days = new String[]{"lunedi","martedi","mercoledi","giovedi","venerdi","sabato","domenica"};
		String[] metei = new String[] {"pioggia","sole","tornado","apocalisse","nuvoloso"};
		
		
		String citta = req.getParameter("citta");
		
		StringBuffer buffer = new StringBuffer();
		
		
		buffer.append("<meteo>");
		buffer.append("<citta>" + citta + "</citta>");
		for(int i=0;i<days.length;i++)
		{
		
		buffer.append("<giorno>" + days[i] + "</giorno>");
		int rnd = new Random().nextInt(metei.length);
		buffer.append("<previsione>" + metei[rnd] + "</previsione>");
		}
		
		buffer.append("</meteo>");
		resp.getWriter().println(buffer.toString());
		resp.getWriter().close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
