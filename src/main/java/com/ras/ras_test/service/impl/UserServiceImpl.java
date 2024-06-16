package com.ras.ras_test.service.impl;

import com.ras.ras_test.dto.UserDTO;
import com.ras.ras_test.exception.BadRequestException;
import com.ras.ras_test.exception.NotFoundException;
import com.ras.ras_test.mapper.UserMapper;
import com.ras.ras_test.model.User;
import com.ras.ras_test.model.UserType;
import com.ras.ras_test.repository.UserRepository;
import com.ras.ras_test.repository.UserTypeRepository;
import com.ras.ras_test.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserTypeRepository userTypeRepository;

    UserServiceImpl(UserRepository repository, UserTypeRepository userTypeRepository) {
        this.repository = repository;
        this.userTypeRepository = userTypeRepository;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(Long id) {
        return this.getSubscriptionType(id);
    }

    @Override
    public User create(UserDTO dto) {
        if (Objects.nonNull(dto.getId())) {
            throw new BadRequestException("ID to be null");
        }

        var userTypeOpt = userTypeRepository.findById(dto.getIdUserType());
        if (userTypeOpt.isEmpty()) {
            throw new NotFoundException("userType not found");
        }
        UserType ut = userTypeOpt.get();

        return repository.save(UserMapper.fromDtoToEntity(dto, ut, null));
    }

    @Override
    public User update(Long id, UserDTO dto) {
        this.getSubscriptionType(id);
        return repository.save(UserMapper.fromDtoToEntity(dto, null, null));
    }

    @Override
    public void delete(Long id) {
        this.getSubscriptionType(id);
        repository.deleteById(id);
    }

    private User getSubscriptionType(Long id) {
        Optional<User> optionalUser = repository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException("User not find!");
        }
        return optionalUser.get();
    }
}
