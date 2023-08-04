package hibernate_onetoone_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_onetoone_uni.dto.Person;

public class PersonDao {

	private EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ashish");
		return emf.createEntityManager();
	}

	// save person
	public void savePerson(Person person) {
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		// first save non-owning side then save owning side
		et.begin();
		em.persist(person.getAdharcard());
		em.persist(person);
		et.commit();
	}

	// get person by id
	public Person getPersonById(int id) {
		EntityManager em = getEntityManager();
		Person dbPerson = em.find(Person.class, id);
		if (dbPerson != null) {
			return dbPerson;
		}
		return null;
	}

	// get all person from table
	public List<Person> getAllPersons() {
		EntityManager em = getEntityManager();
		// creating jpql query to get all persons
		Query query = em.createQuery("SELECT p FROM Person p");
		List<Person> persons = query.getResultList();
		return persons;

	}
	 // update person 
	public void updatePerson(Person person)
	{
		EntityManager em =getEntityManager();
		EntityTransaction et =em.getTransaction();
         // fist merge adharcard
		et.begin();
		      em.merge(person.getAdharcard());
		      em.merge(person);
		et.commit();
	}
	
	// delete person
	public Person deletePerson(int id)
	{
		EntityManager em =getEntityManager();
		EntityTransaction et = em.getTransaction();
		Person dbperson = em.find(Person.class, id);
		// if exists first remove adharcard then person
		// person has adharcard
		if(dbperson !=null)
		{
			et.begin();
			   em.remove(dbperson.getAdharcard());
			   em.remove(dbperson);
			et.commit();	
			return dbperson;
		}
		return null;
	}
}
