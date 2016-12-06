package introsde.assignment.soap;

import introsde.assignment.dao.LifeCoachDao;
import introsde.assignment.model.Measure;
import introsde.assignment.model.Person;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

//Service Implementation

@WebService(endpointInterface = "introsde.assignment.soap.People",
	serviceName="PeopleService")
public class PeopleImpl implements People {

	@Override
	public Person readPerson(Long id) {
		System.out.println("---> Reading Person by id = "+id);
		Person p = Person.getPersonById(id);
		if (p!=null) {
			System.out.println("---> Found Person by id = "+id+" => "+p.getFirstname());
			System.out.println("current");
		} else {
			System.out.println("---> Didn't find any Person with  id = "+id);
		}
		return p;
	}

	@Override
	public List<Person> getPeople() {
		List<Person> personList = Person.getAll();
//		Person[] list = new Person[personList.size()];
//		personList.toArray(list);
		return personList;
	}

	@Override
	public Person addPerson(Person person) {
		Person.savePerson(person);
		return person;
	}

	@Override
	public Person updatePerson(Person person) {
		person.setHealthHistory(Measure.getAll());
		Person updatedPerson = Person.updatePerson(person);
		return updatedPerson;
	}

	@Override
	public int deletePerson(Long id) {
		Person p = Person.getPersonById(id);
		if (p!=null) {
			Person.removePerson(p);
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public List<Measure> readPersonHistory(Long id, String measureType) {
		return Measure.getMeasureByIdAndType(id, measureType);
	}

	@Override
	public List<Measure> readMeasureTypes() {
		return Measure.getAll();
	}

	@Override
	public Measure readPersonMeasure(Long id, String measureType, Long mid) {
		return Measure.getMeasureByIdTypeAndMid(id, measureType, mid);
	}

	@Override
	public Measure savePersonMeasure(Long id, Measure measure) {
		measure.setPerson(Person.getPersonById(id));
		return Measure.saveMeasure(measure);
	}

	@Override
	public Measure updatePersonMeasure(Long id, Measure measure) {
		Measure dbMeasure = Measure.getMeasureById(measure.getIdMeasure());
		if (dbMeasure.getPerson().getIdPerson() == id) {
			measure.setPerson(Person.getPersonById(id));
			return Measure.updateMeasure(measure);
		} else {
			return null;
		}
	}

}
