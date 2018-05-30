package com.forcelate.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private long id;
    private String username;
    private int age;
}
