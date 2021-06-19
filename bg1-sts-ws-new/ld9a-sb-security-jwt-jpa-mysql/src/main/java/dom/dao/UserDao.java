package dom.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dom.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {
	User findByUsername(String username);
}