package com.ceva.service.impl;

import com.ceva.repository.UserRepository;
import com.ceva.service.SecurityService;
import com.ceva.entity.User;
import com.ceva.entity.common.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class SecurityServiceImpl  implements SecurityService {


    private final UserRepository userRepository;

    public SecurityServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(username);

        if(user==null){
            throw  new UsernameNotFoundException("This user does not exists");
        }

        return new UserPrincipal(user);
    }
}
