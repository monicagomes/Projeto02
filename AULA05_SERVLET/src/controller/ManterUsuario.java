package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;

/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterUsuario.do")
public class ManterUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pId = Integer.parseInt(request.getParameter("id"));
		String pMatricula = request.getParameter("plate");
		String pNome = request.getParameter("name");
		String pCpf = request.getParameter("cpf");
		String pRg = request.getParameter("rg");
		String pEndereco = request.getParameter("address");
		String pTel = request.getParameter("phone");
		String pEmail = request.getParameter("email");
		String pFuncao = request.getParameter("function");
		String pConj = request.getParameter("group");
		
		//instanciar o javabean
		User user = new User();
		user.setId(pId);
		user.setPlate(pMatricula);
		user.setName(pNome);
		user.setCpf(pCpf);
		user.setRg(pRg);
		user.setAddress(pEndereco);
		user.setPhone(pTel);
		user.setEmail(pEmail);
		user.setFunction(pFuncao);
		user.setGroup(pConj);
		
		//instanciar o service
		UserService cs = new UserService();
		cs.criar(user);
		user = cs.carregar(user.getId());
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Cadastro Usuário</title></head><body>");
		out.println(	"id: "+ user.getId()+"<br>");
		out.println(	"Matricula: "+ user.getPlate()+"<br>");
		out.println(	"nome: "+ user.getName()+"<br>");
		out.println(	"CPF: "+ user.getCpf()+"<br>");
		out.println(	"RG: "+ user.getRg()+"<br>");
		out.println(	"Endereço: "+ user.getAddress()+"<br>");
		out.println(	"Telefone: "+ user.getPhone()+"<br>");
		out.println(	"E-mail: "+ user.getEmail()+"<br>");
		out.println(	"Funcao: "+ user.getFunction()+"<br>");
		out.println(	"Conjunto: "+ user.getGroup() +"<br>");
	    out.println("</body></html>");
		
	}

}
