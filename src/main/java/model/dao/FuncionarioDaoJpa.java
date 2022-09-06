package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Funcionario;

public class FuncionarioDaoJpa implements InterfaceDao<Funcionario> {

    @Override
    public void incluir(Funcionario entidade) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entidade);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void editar(Funcionario entidade) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entidade);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void excluir(Funcionario entidade) throws Exception {
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();

            Funcionario f1 = em.find(Funcionario.class, entidade.getId());
            em.remove(f1);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Funcionario pesquisarPorId(int id) throws Exception {
        Funcionario f = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();

            f = em.find(Funcionario.class, id);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return f;
    }

    @Override
    public List<Funcionario> listar() throws Exception {
        List<Funcionario> lista = null;
        EntityManager em = ConnFactory.getEntityManager();
        try {
            em.getTransaction().begin();
            lista = em.createQuery("FROM Funcionario f").getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return lista;
    }

    @Override
    public List<Funcionario> pesquisarPorNome(String nome) throws Exception {
        List<Funcionario> lista = null;
        EntityManager em = ConnFactory.getEntityManager();
                try {
            em.getTransaction().begin();
            Query query = em.createNamedQuery("Funcionario.pesquisarPorNome");
            query.setParameter("nome", nome);
            lista = query.getResultList();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return lista;
    }
    }


