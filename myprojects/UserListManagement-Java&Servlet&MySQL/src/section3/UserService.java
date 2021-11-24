package section3;

import java.util.List;

import model.User;

public interface UserService {

	void insert(User user);

	void update(User user);

	void delete(int id);

	User get(int id);

	List<User> search(String name);

	List<User> getAll();
}
