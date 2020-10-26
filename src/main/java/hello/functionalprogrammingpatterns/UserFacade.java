package hello.functionalprogrammingpatterns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class UserFacade {

    @Autowired
    UserRepo userRepo;
    @Autowired
    private UserMappper mapper;

    public List<UserDto> getAllUsers() {
        return userRepo.findAll().stream().map(mapper::toDto).collect(toList());
    }
}
