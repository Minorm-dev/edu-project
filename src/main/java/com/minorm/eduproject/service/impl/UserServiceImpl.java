package com.minorm.eduproject.service.impl;

import com.minorm.eduproject.database.entity.User;
import com.minorm.eduproject.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public String addUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth instanceof OAuth2AuthenticationToken oAuth2AuthenticationToken) {
            OAuth2User oAuth2User = oAuth2AuthenticationToken.getPrincipal();
            if (oAuth2User != null) {
                Map<String, Object> attributes = oAuth2User.getAttributes();
                Optional<User> optionalUser = userRepository.findById((Long) attributes.get("sub"));
                if (optionalUser.isEmpty()) {
                    User user = new User();
                    user.setId((Long) attributes.get("sub"));
                    user.setFirstName(attributes.get("given_name").toString());
                    user.setLastName(attributes.get("family_name").toString());
                    user.setEmail(attributes.get("email").toString());
                    user.setAvatarPath(attributes.get("picture").toString());
                    userRepository.save(user);
                }
                return "Hello, " + attributes.get("given_name").toString();
            }
        }
        return "No OAuth2AuthenticationToken found";
    }
}
