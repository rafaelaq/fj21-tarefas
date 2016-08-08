package br.com.caelum.tarefas.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.tarefas.modelo.Tarefa;

@Repository
public class JpaTarefaDao implements TarefaDao {
	
	@PersistenceContext
	EntityManager manager;
	
	public void adiciona(Tarefa tarefa) {
		manager.persist(tarefa);
	}

	public Tarefa buscaPorId(Long id) {
		return manager.find(Tarefa.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Tarefa> lista() {
		return manager.createQuery("Select t from Tarefa t").getResultList();
	}

	public void altera(Tarefa tarefa) {
		manager.merge(tarefa);
	}

	public void remove(Tarefa tarefa) {
		Tarefa tarefaARemover = buscaPorId(tarefa.getId());
		manager.remove(tarefaARemover);
	}

	public void finaliza(Long id) {
		Tarefa tarefa = buscaPorId(id);
		tarefa.setFinalizado(true);
		tarefa.setDataFinalizacao(Calendar.getInstance());
	}

	@Override
	public Tarefa buscaPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}