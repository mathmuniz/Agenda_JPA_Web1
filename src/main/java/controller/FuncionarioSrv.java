
package controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;
import model.dao.FuncionarioDaoJpa;
import model.dao.InterfaceDao;

public class FuncionarioSrv extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String acao = request.getParameter("acao");
            response.setContentType("text/html;charset=UTF-8");
            
            InterfaceDao dao = new FuncionarioDaoJpa();
            RequestDispatcher rd;
            Funcionario f = null;
            
            
            String id = request.getParameter("id");
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");
            String salario = request.getParameter("salario");
            
            switch (acao) {
                case "inclusao":
                    f = new Funcionario(nome, email, telefone, salario);
                    try {
                        dao.incluir(f);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    rd = request.getRequestDispatcher("index.html");
                    rd.forward(request, response);
                    
                    break;
                    
                case "pre-edicao":
                    f = (Funcionario) dao.pesquisarPorId(Integer.parseInt(id));
                    rd = request.getRequestDispatcher("Formulario.jsp?acao=edicao"
                            + "&id=" + f.getId()
                            + "&nome=" + f.getNome()
                            + "&email=" + f.getEmail()
                            + "&telefone=" + f.getTelefone()
                            + "&salario=" + f.getSalario());
                    rd.forward(request, response);
                    break;
                    
                case "edicao":
                    f = new Funcionario(nome, email, telefone, salario);
                    f.setId(Integer.parseInt(id));
                    try {
                        dao.editar(f);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    rd = request.getRequestDispatcher("Listagem.jsp?lista=" + listagem());
                    rd.forward(request, response);
                    break;
                    
                case "exclusao":
                    try {
                        f = new Funcionario();
                        f.setId(Integer.parseInt(id));
                        dao.excluir(f);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    rd = request.getRequestDispatcher("Listagem.jsp?lista=" + listagem());
                    rd.forward(request, response);
                    break;
                    
                case "listagem":
                    rd = request.getRequestDispatcher("Listagem.jsp?lista=" + listagem());
                    rd.forward(request, response);
                    break;
                   
                case "pesquisarPorNome":
                    rd = request.getRequestDispatcher("Listagem.jsp?lista=" + pesquisarPorNome(nome));
                    rd.forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioSrv.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private String listagem() {
        InterfaceDao dao = new FuncionarioDaoJpa();
        List<Funcionario> lista = null;
        try {
            lista = dao.listar();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        String listaHTML = "";
        for (Funcionario funcionario : lista) {
            listaHTML = listaHTML
                    + "<tr>"
                    + "<td>" + funcionario.getNome() + "</td>"
                    + "<td>" + funcionario.getEmail() + "</td>"
                    + "<td>" + funcionario.getTelefone() + "</td>"
                    + "<td>" + funcionario.getSalario() + "</td>"
                    + "<td><form action=FuncionarioSrv?acao=pre-edicao method='POST'>"
                    + "<input type='hidden' name='id' value="
                    + funcionario.getId() + "><input type='submit' value=editar>"
                    + "</form></td>"
                    + "<form action=FuncionarioSrv?acao=exclusao method='POST'>"
                    + "<td><input type='hidden' name='id' value="
                    + funcionario.getId() + "><input type='submit' value=excluir></td>"
                    + "</form>"
                    + "</tr>";

        }
        return listaHTML;
    }
    
        private String pesquisarPorNome(String nome) {
        InterfaceDao dao = new FuncionarioDaoJpa();
        List<Funcionario> lista = null;
        try {
            lista = dao.pesquisarPorNome(nome);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        String listaHTML = "";
        for (Funcionario funcionario : lista) {
            listaHTML = listaHTML
                    + "<tr>"
                    + "<td>" + funcionario.getNome() + "</td>"
                    + "<td>" + funcionario.getEmail() + "</td>"
                    + "<td>" + funcionario.getTelefone() + "</td>"
                    + "<td>" + funcionario.getSalario() + "</td>"
                    + "<td><form action=FuncionarioSrv?acao=pre-edicao method='POST'>"
                    + "<input type='hidden' name='id' value="
                    + funcionario.getId() + "><input type='submit' value=editar>"
                    + "</form></td>"
                    + "<form action=FuncionarioSrv?acao=exclusao method='POST'>"
                    + "<td><input type='hidden' name='id' value="
                    + funcionario.getId() + "><input type='submit' value=excluir class='botaoTable'></td>"
                    + "</form>"
                    + "</tr>";

        }
        return listaHTML;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
