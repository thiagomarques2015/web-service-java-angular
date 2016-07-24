

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(name = "Index", urlPatterns = { "/listar" })
public class ListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ListarServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Cria nosso objeto GSON para converter objetos
		Gson gson = new Gson();
		/**
		 *  Carrega uma lista de itens
		 *  obs: essa lista pode ser carregada 
		 *  	de uma base de dados Mysql
		 */
		
		// Recupera a lista de itens
		Lista lista = Lista.getInstance();
		
		/**
		 * Essa lista de itens foi implementada no
		 * padrao Singleton, mas pode ser substituida por um
		 * script Mysql para trazer dados de uma base
		 */
		
		// Converte a lista para JSON
		String json = gson.toJson(lista);
		// Retorna o JSON para o front end
		response.getWriter().append(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
