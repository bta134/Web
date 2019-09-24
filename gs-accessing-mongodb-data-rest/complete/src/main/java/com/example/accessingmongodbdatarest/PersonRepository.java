
package com.example.accessingmongodbdatarest;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends MongoRepository<Person, String> {

	Optional<Person> findById(@Param("id") String id);
	List<Person> findByLastName(@Param("name") String name);
	List<Person> findByFirstName(String name);
}
