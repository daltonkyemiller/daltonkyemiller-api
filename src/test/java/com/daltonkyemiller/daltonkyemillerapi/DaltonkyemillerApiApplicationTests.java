package com.daltonkyemiller.daltonkyemillerapi;

import com.daltonkyemiller.daltonkyemillerapi.user.UserController;
import com.daltonkyemiller.daltonkyemillerapi.user.UserRepository;
import com.daltonkyemiller.daltonkyemillerapi.user.model.User;
import com.mongodb.MongoWriteException;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DaltonkyemillerApiApplicationTests {

	@Test
	void contextLoads() {
	}

}
