package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Márcia");
		conta.setNumero(123456);
		conta.setAgencia(4332211);
		
		em.getTransaction().begin();
		
		em.persist(conta);
		
		conta.setSaldo(1000.0);
		
		em.getTransaction().commit();
		em.close();

		EntityManager em2 = emf.createEntityManager();
		System.out.println("ID da conta da Márcia: " + conta.getId());
		conta.setSaldo(10.000);
		
		em2.getTransaction().begin();
		
		em2.merge(conta);
		
		em2.getTransaction().commit();
	}
}
