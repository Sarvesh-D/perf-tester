/**
 * 
 */
package com.ds.sample.perf.tester;

import java.util.Collection;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @PostMapping
    public void user(@RequestBody User user) {
        log.info("Request received for creating User {}", user);
    }

    @PostMapping("/bulk")
    public void users(@RequestBody Collection<User> users) {
        log.info("Total users to be created = {}", users.size());
    }

}
