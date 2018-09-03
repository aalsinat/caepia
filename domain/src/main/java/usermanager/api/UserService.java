package usermanager.api;

import usermanager.api.entity.User;

public interface UserService {
	public String signin(String username, String password);
	public String signup(User user);
}
