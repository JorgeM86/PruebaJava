package com.cidenet.hulkStore.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cidenet.hulkStore.daos.UsersDAO;
import com.cidenet.hulkStore.entities.UsersDTO;

@Service
public class UserPrincipleService implements UserDetailsService {

    @Autowired
    UsersDAO userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UsersDTO user = userRepository.findByEmail(s);
        return UserPrincipleDTO.build(user);
    }
}