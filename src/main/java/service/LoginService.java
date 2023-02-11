package service;

import payload.UsersResponse;
import repository.UsersRepository;

public class LoginService {
    public UsersResponse login(String email, String pass) {
        UsersRepository usersRepository = new UsersRepository();
        return usersRepository.login(email, pass);
    }
}
