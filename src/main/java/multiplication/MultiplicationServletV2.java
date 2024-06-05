package multiplication;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MultiplicationServletV2
 */
public class MultiplicationServletV2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiplicationServletV2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<style>");
		out.println("table, th, td {");
		out.println("margin-left:auto; margin-right:auto;");
		out.println("}");
		out.println("table, th, td {");
		out.println("border: 1px solid black;");
		out.println("}");
		out.println("th {");
		out.println("width: 50px; height: 40px; background-color : gray; text-align: center;");
		out.println("}");
		out.println("td {");
		out.println("width: 50px; height: 40px; text-align: center;");
		out.println("}");
		out.println("tr {");
		out.println("\"width: 50px; height: 40px;\"");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		int dan = Integer.parseInt(request.getParameter("number"));
		out.println();
		out.println("<th>");
		out.println(dan);
		out.println("</th>");
		for(int i=2; i<=9; i++) {
			out.println("<tr>");
			out.println("<td>");
			out.println(i*dan);
			out.println("</td>");
			out.println("</tr>");			
		}

		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("<script>");
		out.println("let number = document.getElementsByName(\"number\")[0]");
		out.println("function viewMultiplication() {");
		out.println("if(!number.value || isNaN(number.value)) {");
		out.println("alert(\"숫자를 입력하십시요\");");
		out.println("return false;");
		out.println("}");
		out.println("}");
		out.println("</script>");
		out.println("</html>");
		
	}    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
