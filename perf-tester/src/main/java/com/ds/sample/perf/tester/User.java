/**
 * 
 */
package com.ds.sample.perf.tester;

import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author <a href="https://github.com/Sarvesh-D/">Sarvesh Dubey</a>
 * @since 3 Oct 2018
 * @version 1.0
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private String firstName;

    private String lastName;

    private String email;

    private static final Faker faker = new Faker();

    public static User random() {
        return User.builder()
                   .firstName(faker.name()
                                   .firstName())
                   .lastName(faker.name()
                                  .lastName())
                   .email(faker.internet()
                               .emailAddress())
                   .build();
    }

}
