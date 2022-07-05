package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;
import model.Conteiner;
import model.Movimentacao;


@WebServlet(urlPatterns = {"/controller", "/main", "/insertConteiner", "/insertMov", "/selectConteiner", 
		"/selectMov", "/updateConteiner", "/updateMov", "/deleteConteiner", "/deleteMov"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();
	Conteiner objConteiner = new Conteiner();
	Movimentacao objMov = new Movimentacao();
    public Controller() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);
		
		if (action.equals("/main")) {
			home(request, response);
		}
		else if(action.equals("/insertConteiner")) {
			novoConteiner(request, response);
		}
		else if(action.equals("/insertMov")) {
			novoMov(request, response);
		}
		else if(action.equals("/selectConteiner")) {
			listarConteiner(request, response);
		}
		else if(action.equals("/selectMov")) {
			listarMov(request, response);
		}
		else if(action.equals("/updateConteiner")) {
			editarConteiner(request, response);
		}
		else if(action.equals("/updateMov")) {
			editarMov(request, response);
		}
		else if(action.equals("/deleteConteiner")) {
			removerConteiner(request, response);
		}
		else if(action.equals("/deleteMov")) {
			removerMov(request, response);
		}
		else {
			response.sendRedirect("index.html");
		}
		
		//dao.testeConexao();
	}
	
	protected void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("pagina2.jsp");
		ArrayList<Conteiner> listaConteiner = dao.listarConteiners();
		ArrayList<Movimentacao> listaMov = dao.listarMovimentacao();
		
		/*for(int i=0; i<lista.size(); i++) {
			System.out.println(lista.get(i).getId());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getFone());
		}*/
		
		request.setAttribute("conteiners", listaConteiner);
		request.setAttribute("movimentacoes", listaMov);
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}
	
	protected void novoConteiner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*response.sendRedirect("pagina2.jsp");
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("fone"));*/
		objConteiner.setNumero(request.getParameter("numero"));
		objConteiner.setCliente(request.getParameter("cliente"));
		objConteiner.setTipo(request.getParameter("tipo"));
		objConteiner.setEstado(request.getParameter("estado"));
		objConteiner.setCategoria(request.getParameter("categoria"));
		
		dao.inserirConteiner(objConteiner);
		
		response.sendRedirect("main");
		
	}
	
	protected void novoMov(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*response.sendRedirect("pagina2.jsp");
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("fone"));*/
		objMov.setNumero(request.getParameter("numero"));
		objMov.setTipoMov(request.getParameter("tipoMov"));
		objMov.setInicio(request.getParameter("inicio"));
		objMov.setFim(request.getParameter("fim"));
		
		dao.inserirMovimentacao(objMov);
		
		response.sendRedirect("main");
	}
	
	protected void listarConteiner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(id);
		objConteiner.setNumero(request.getParameter("numero"));
		System.out.println(request.getParameter("numero"));
		dao.selecionarConteiner(objConteiner);
		
		/*System.out.println(contato.getId());
		System.out.println(contato.getNome());
		System.out.println(contato.getFone());*/
		
		request.setAttribute("numero", objConteiner.getNumero());
		request.setAttribute("cliente", objConteiner.getCliente());
		request.setAttribute("tipo", objConteiner.getTipo());
		request.setAttribute("estado", objConteiner.getEstado());
		request.setAttribute("categoria", objConteiner.getCategoria());
		
		RequestDispatcher rd = request.getRequestDispatcher("editarConteiner.jsp");
		rd.forward(request, response);
	}
	
	protected void listarMov(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String id = request.getParameter("id");
		//System.out.println(id);
		objMov.setId(request.getParameter("id"));
		
		dao.selecionarMovimentacao(objMov);
		
		/*System.out.println(contato.getId());
		System.out.println(contato.getNome());
		System.out.println(contato.getFone());*/
		
		request.setAttribute("id", objMov.getId());
		request.setAttribute("numero", objMov.getNumero());
		request.setAttribute("tipoMov", objMov.getTipoMov());
		request.setAttribute("inicio", objMov.getInicio());
		request.setAttribute("fim", objMov.getFim());
		
		RequestDispatcher rd = request.getRequestDispatcher("editarMov.jsp");
		rd.forward(request, response);
	}
	
	protected void editarConteiner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("fone"));*/
		
		objConteiner.setNumero(request.getParameter("numero"));
		objConteiner.setCliente(request.getParameter("cliente"));
		objConteiner.setTipo(request.getParameter("tipo"));
		objConteiner.setEstado(request.getParameter("estado"));
		objConteiner.setCategoria(request.getParameter("categoria"));
		
		dao.alterarConteiner(objConteiner);
		
		response.sendRedirect("main");
	}
	
	protected void editarMov(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("fone"));*/
		
		objMov.setId(request.getParameter("id"));
		objMov.setNumero(request.getParameter("numero"));
		objMov.setTipoMov(request.getParameter("tipoMov"));
		objMov.setInicio(request.getParameter("inicio"));
		objMov.setFim(request.getParameter("fim"));
		
		dao.alterarMovimentacao(objMov);
		
		response.sendRedirect("main");
	}
	
	protected void removerConteiner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String id = request.getParameter("id");
		//System.out.println(id);
		
		objConteiner.setNumero(request.getParameter("numero"));
		
		dao.deletarConteiner(objConteiner);
		
		response.sendRedirect("main");
	}
	
	protected void removerMov(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String id = request.getParameter("id");
		//System.out.println(id);
		
		objMov.setId(request.getParameter("id"));
		
		dao.deletarMovimentacao(objMov);
		
		response.sendRedirect("main");
	}
	
	

}
