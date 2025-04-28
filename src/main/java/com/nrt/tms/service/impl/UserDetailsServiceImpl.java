package com.nrt.tms.service.impl;

import com.nrt.tms.config.CustomUserDetail;
import com.nrt.tms.entity.ApplicationUser;
import com.nrt.tms.repository.ApplicationUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ApplicationUserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        //User user = userRepo.findByUsernameOrEmail(email,email).orElseThrow(()-> new UsernameNotFoundException("Username not found"));
        ApplicationUser user = userRepo.findByUsername(email).orElse(null);
        if (user != null) {

            user.setRoles(user.getRoles());

            return new CustomUserDetail(user);
        }
        return null;
    }

}
