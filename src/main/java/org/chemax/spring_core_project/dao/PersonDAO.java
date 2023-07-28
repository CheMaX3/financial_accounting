package org.chemax.spring_core_project.dao;

import org.chemax.spring_core_project.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Person show(Long id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Person.class, id);
    }

    @Transactional
    public Optional<Person> show(String email) {
        Session session = sessionFactory.getCurrentSession();

        return Optional.ofNullable(session.get(Person.class, email));
    }

    @Transactional
    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();

        session.persist(person);
    }

    @Transactional
    public void update(Long id, Person updatedPerson) {
        Session session = sessionFactory.getCurrentSession();
        Person personToBeUpdated = session.get(Person.class, id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
        personToBeUpdated.setAddress(updatedPerson.getAddress());
    }

    @Transactional
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();

        session.remove(session.get(Person.class, id));
    }
}
