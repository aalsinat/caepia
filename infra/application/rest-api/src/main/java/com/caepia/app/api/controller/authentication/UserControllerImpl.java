package com.caepia.app.api.controller.authentication;

import com.caepia.app.api.dto.Values;
import com.caepia.app.api.dto.LoginDataDTO;
import com.caepia.app.api.dto.PasswordDTO;
import com.caepia.app.api.dto.UserDataDTO;
import com.caepia.app.api.dto.UserResponseDTO;
import com.caepia.app.api.model.authentication.UserAccount;
import com.caepia.app.api.model.domain.UserInfo;
import com.caepia.app.api.security.JwtAuthenticationResponse;
import com.caepia.app.api.security.JwtTokenProvider;
import com.caepia.app.api.service.authentication.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserControllerImpl implements UserController {

    private final UserService userService;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final ModelMapper modelMapper;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @PostMapping(value = "/signin", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody LoginDataDTO login) {

        final Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(login.getUsername());
        final String token = jwtTokenProvider.createToken(login.getUsername());

        return ResponseEntity.ok(new JwtAuthenticationResponse(userDetails, token));
    }

    @Override
    @PostMapping("/signup")
    public ResponseEntity<UserInfo> signup(@RequestBody UserDataDTO user) {
        UserAccount userAccount = modelMapper.map(user, UserAccount.class);
        UserInfo userInfo = modelMapper.map(user, UserInfo.class);
        return ResponseEntity.ok(userService.signup(userAccount, userInfo));
    }

    @Override
    @DeleteMapping(value = "/{username}")
    public String delete(@PathVariable String username) {
        userService.delete(username);
        return username;
    }

    @Override
    @GetMapping(value = "/{username}")
    public UserResponseDTO search(@PathVariable String username) {
        return modelMapper.map(userService.search(username), UserResponseDTO.class);
    }

    @Override
    @PatchMapping(value = "/{username}")
    public ResponseEntity<UserResponseDTO> changePassword(@PathVariable String username,
                                                          @RequestBody PasswordDTO newPassword) {
        return ResponseEntity.ok(modelMapper
                .map(userService.changePassword(username, newPassword.getPassword()), UserResponseDTO.class));
    }

    @Override
    @GetMapping(value = "/me")
    public UserResponseDTO whoami(HttpServletRequest req) {
        return modelMapper.map(userService.whoami(req), UserResponseDTO.class);
    }

    @Override
    @GetMapping(value = "/dummy")
    public UserResponseDTO dummy(Values values) {
        return new UserResponseDTO();
    }

}