<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="style.css">
    </head>

    <%
        String listaHTML = request.getParameter("lista");
        String acao = request.getParameter("acao");
    %>

    <body>
        <form action="FuncionarioSrv?acao=pesquisarPorNome" method="POST">
                    <input type="text" name="nome" value="" />
                    <input type="submit" value="buscar" class="botao1" />
                </form>
<center>

    <table border="1">
        <thead>
            <tr>
                <td>
                    Nome
                </td>
                <td>
                    Email
                </td>
                <td>
                    Telefone
                </td>
                <td>
                    Salario
                </td>
                <td>
                    Editar
                </td>
                <td>
                    Excluir
                </td>
            </tr>
        </thead>
        <tbody>
            <%=listaHTML%>
        </tbody>
    </table>
</center>
        <a href="index.html" class="botao1">Voltar</a>
</body>
</html>
