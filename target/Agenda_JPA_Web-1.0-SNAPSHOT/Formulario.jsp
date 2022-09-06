<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dados do Funcionario</title>
        <link rel="stylesheet" href="style.css">
    </head>
     <%
        String acao = request.getParameter("acao");
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String salario = request.getParameter("salario");
    
        if (id == null) {
                nome = "";
                email = "";
                telefone = "";
                salario = "";
            }
     %>
    
 <body>
     <main>
        <div>
            <h1>Dados do Funcionario</h1>
            <form action="FuncionarioSrv" method="POST">
                <table border="0">
                    <tbody>
                        <tr>
                            <td><input type="hidden" name="acao" value="<%=acao%>" /></td>
                        </tr>
                        <tr>
                            <td><input type="hidden" name="id" value="<%=id%>" /></td>
                        </tr>
                        <tr>
                            <td>Nome: </td>
                            <td><input type="text" name="nome" value="<%=nome%>" /></td>
                        </tr>
                        <tr>
                            <td>Email: </td>
                            <td><input type="text" name="email" value="<%=email%>" /></td>
                        </tr>
                        <tr>
                            <td>Telefone: </td>
                            <td><input type="text" name="telefone" value="<%=telefone%>" /></td>
                        </tr>
                        <tr>
                            <td>Salario: </td>
                            <td><input type="text" name="salario" value="<%=salario%>" /></td>
                        </tr>
                    </tbody>
                </table>
                        <input type="submit" class="botao1" value="Gravar" />
                        <input type="reset" class="botao1" value="Limpar" />
            </form>
        </div>
     </main>
       <br>
       <a href="index.html" class="botao1">Voltar</a>
    </body>
</html>
