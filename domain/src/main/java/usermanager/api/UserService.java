package usermanager.api;

import usermanager.api.entity.IUser;

public interface UserService {
	public String signin(String username, String password);
	public String signup(IUser user);
}
