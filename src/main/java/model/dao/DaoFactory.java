package model.dao;

public class DaoFactory {
    
    public static FuncionarioDaoJpa novoFuncionarioDAO() throws Exception {
        return new FuncionarioDaoJpa();
    }
    
}
