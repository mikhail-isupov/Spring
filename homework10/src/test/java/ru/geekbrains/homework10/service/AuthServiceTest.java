package ru.geekbrains.homework10.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.geekbrains.homework10.model.SessionEntity;
import ru.geekbrains.homework10.model.User;
import ru.geekbrains.homework10.model.UserEntity;
import ru.geekbrains.homework10.repo.iSessionRepo;
import ru.geekbrains.homework10.repo.iUserRepo;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private iUserRepo userRepo;

    @Mock
    private iSessionRepo sessionRepo;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Mock
    private UserEntityService userEntityService;

    @Mock
    private SessionEntityService sessionEntityService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegister() {
        User mockedUser = new User("noname", "pass");
        UserEntity mockedUserEntity = new UserEntity();
        when(userEntityService.createUserEntity(mockedUser)).thenReturn(mockedUserEntity);
        when(userRepo.save(mockedUserEntity)).thenReturn(mockedUserEntity);

        authService.register(mockedUser);
        Mockito.verify(userRepo,Mockito.times(1)).save(mockedUserEntity);
    }

    @Test
    public void login(){
        User mockedUser = new User("noname", "pass");
        UserEntity mockedUserEntity = new UserEntity("noname", "encodedPass");
        SessionEntity mockedSessionEntity = new SessionEntity(mockedUserEntity, "token");
        when(userRepo.findByUsername("noname")).thenReturn(Optional.of(mockedUserEntity));
        when(bCryptPasswordEncoder.matches("pass", "encodedPass")).thenReturn(true);
        when(sessionEntityService.createSessionEntity(mockedUserEntity)).thenReturn(mockedSessionEntity);
        when(sessionRepo.save(mockedSessionEntity)).thenReturn(mockedSessionEntity);

        assertEquals("token", authService.login(mockedUser));
    }

    @Test
    public void logout(){
        User mockedUser = new User("noname", "pass");
        UserEntity mockedUserEntity = new UserEntity("noname", "encodedPass");
        SessionEntity mockedSessionEntity = new SessionEntity(mockedUserEntity, "token");
        when(userRepo.findByUsername("noname")).thenReturn(Optional.of(mockedUserEntity));
        when(bCryptPasswordEncoder.matches("pass", "encodedPass")).thenReturn(true);
        when(sessionRepo.findByUser(mockedUserEntity)).thenReturn(Optional.of(mockedSessionEntity));

        authService.logout(mockedUser);
        Mockito.verify(sessionRepo,Mockito.times(1)).delete(mockedSessionEntity);
    }
}
