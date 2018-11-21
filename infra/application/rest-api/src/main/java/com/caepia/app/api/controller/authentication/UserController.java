package com.caepia.app.api.controller.authentication;

import com.caepia.app.api.dto.*;
import com.caepia.app.api.model.domain.UserInfo;
import com.caepia.app.api.security.JwtAuthenticationResponse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "Users", description = "List of user resources")
public interface UserController {
    @ApiOperation("${UserController.signin}")
    @ApiResponses(value = {
            @ApiResponse(code = 200,
                    message = "User signed in successfully",
                    response = JwtAuthenticationResponse.class),
            @ApiResponse(code = 401,
                    message = "Unauthorized",
                    response = ApiError.class)})
    ResponseEntity<JwtAuthenticationResponse> signin(@ApiParam("Signin information") LoginDataDTO login);

    @ApiOperation(value = "${UserController.signup}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 422, message = "Username is already in use"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    ResponseEntity<UserInfo> signup(@ApiParam("Signup UserAccount") UserDataDTO user);

    @ApiOperation(value = "${UserController.delete}")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "The user doesn't exist"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    String delete(@ApiParam("Username") String username);

    @ApiOperation(value = "${UserController.search}", response = UserResponseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 404, message = "The user doesn't exist"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    UserResponseDTO search(@ApiParam("Username") String username);

    @ApiOperation(value = "${UserController.changePassword}", httpMethod = "PATCH", response = UserResponseDTO.class)
    ResponseEntity<UserResponseDTO> changePassword(@ApiParam("Username") String username,
                                                   @ApiParam("New password") PasswordDTO newPassword);

    @ApiOperation(value = "${UserController.me}", response = UserResponseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access denied"),
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    UserResponseDTO whoami(HttpServletRequest req);
}
