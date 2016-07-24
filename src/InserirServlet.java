

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(name = "InserirServlet", urlPatterns = { "/inserir" })
public class InserirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InserirServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Ler o JSON passado por parametro na requisicao
		StringBuffer sb = readJSON(request);
		
		// Se o JSON passado por parametro eh invalido
		if(sb.toString().isEmpty()){ // POST (JSON)
			JsonObject json = new JsonObject();
			json.addProperty("msg", "JSON inválido");
			response.getWriter().append(json.toString());
			return;
		}
		
		// Cria nosso objeto GSON para converter objetos JSON
		Gson gson = new Gson();
		// Recupera nossa lista de itens
		Lista list = Lista.getInstance();
		// Recupera o JSON como um elemento
		JsonElement elem = gson.fromJson(sb.toString(), JsonElement.class);
		// Converte o elemento para um objeto JSON
		JsonObject json = elem.getAsJsonObject();
		// Recupera novo item na lista
		String item = json.get("item").getAsString();
		// Adiciona o novo item na lista
		list.add(item);
		// Converte a lista JSON para string
		String jsonString = gson.toJson(list);
		// Retorna o JSONString para o front end
		response.getWriter().append(jsonString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private static StringBuffer readJSON(HttpServletRequest request){
		StringBuffer sb = new StringBuffer();
		 
	    try 
	    {
	      BufferedReader reader = request.getReader();
	      String line = null;
	      while ((line = reader.readLine()) != null)
	      {
	        sb.append(line);
	      }
	      reader.close();
	    } catch (Exception e) { e.printStackTrace(); }
	    
	    return sb;
	}


}
