/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo.servlets;

import br.cesjf.lppo.Contato;
import br.cesjf.lppo.dao.ContatoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alunoces
 */
@WebServlet(name = "DetalhesServlet", urlPatterns = {"/detalhes.html/exclui.html"})
public class DetalhesServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            
            ContatoDAO dao = new ContatoDAO();
            Contato contato = dao.getById(id);
            // achou o onjeto, agor desenha ele
            request.setAttribute("contato", contato);
            request.getRequestDispatcher("WEB-INF/detalhes-contatos.jsp").forward(request, response);
            
        } catch (NumberFormatException e){
            response.sendRedirect("contatos.html");
        } catch (Exception ex) {
            Logger.getLogger(DetalhesServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("contatos.html");
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            
            ContatoDAO dao = new ContatoDAO();
            Contato contato = dao.getById(id);
            
            contato.setNome(request.getParameter("nome"));
            contato.setSobrenome(request.getParameter("sobrenome"));
            contato.setTelefone(request.getParameter("telefone"));
            
            dao.atualiza(contato);
            response.sendRedirect("contatos.html");
            
        } catch (NumberFormatException e){
            response.sendRedirect("contatos.html");
        } catch (Exception ex) {
            Logger.getLogger(DetalhesServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("contatos.html");
        }
        
    }

    

}
