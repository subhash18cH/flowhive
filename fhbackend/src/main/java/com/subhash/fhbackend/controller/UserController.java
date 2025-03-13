//package com.subhash.fhbackend.controller;
//
//import com.subhash.backend.repository.UserRepository;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/auth")
//public class UserController {
//
//    private UserRepository userRepository;
//
//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
////    @PostMapping("/signup")
////    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest){
////
////        if(userRepository.existsByUserName(signUpRequest.getUserName())){
////            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken"));
////        }
////
////        Userr user = new Userr(signUpRequest.getUserName(),
////                signUpRequest.getEmail(),
////                encoder.encode(signUpRequest.getPassword()));
////
////        userRepository.save(user);
////        return ResponseEntity.ok(new MessageResponse("User Registered successfully!!"));
////    }
////
////    @PostMapping("/public/signin")
////    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest){
////        Authentication authentication=authManager.authenticate(
////                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),loginRequest.getPassword()));
////
////        SecurityContextHolder.getContext().setAuthentication(authentication);
////        UserDetails userDetails=(UserDetails) authentication.getPrincipal();
////
////        String jwtToken=jwtUtils.generateToken(userDetails);
////
////        LoginResponse response=new LoginResponse(jwtToken,userDetails.getUsername());
////
////        return ResponseEntity.ok(response);
////    }
//
//
//}
