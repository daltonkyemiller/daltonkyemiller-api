//package com.daltonkyemiller.daltonkyemillerapi.auth;
//
//import com.daltonkyemiller.daltonkyemillerapi.user.model.User;
//import com.daltonkyemiller.daltonkyemillerapi.user.UserRepository;
//import com.google.common.collect.Lists;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//import static com.daltonkyemiller.daltonkyemillerapi.user.model.UserRole.ADMIN;
//
//@Repository("fake")
//public class FakeUserDaoService implements UserRepository {
//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public FakeUserDaoService(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public Optional<User> selectUserByUsername(String username) {
//        return getUsers()
//                .stream()
//                .filter(user -> username.equals(user.getUsername()))
//                .findFirst();
//    }
//
//    private List<User> getUsers(){
//        List<User> users = Lists.newArrayList(
//                new User(
//                        "admin",
//                        passwordEncoder.encode("password"),
//                        ADMIN.getGrantedAuthorities(),
//                        true,
//                        true,
//                        true,
//                        true
//                )
//
//        );
//
//        return users;
//    }
//}
