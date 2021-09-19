package com.example.batchprocessing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;

@StepScope
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

	private String notAcceptedFirstName = "";

	private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

	public PersonItemProcessor(String notAcceptedFirstName) {
		this.notAcceptedFirstName = notAcceptedFirstName;
	}

	@Override
	public Person process(final Person person) throws Exception {
		final String firstName = person.getFirstName().toUpperCase();
		final String lastName = person.getLastName().toUpperCase();

		final Person transformedPerson = new Person(firstName, lastName);

		log.info("Converting (" + person + ") into (" + transformedPerson + ")");

		if (person.getFirstName().equals(notAcceptedFirstName)) {
			throw new RuntimeException(notAcceptedFirstName + " never dies");
		}

		return transformedPerson;
	}

}
