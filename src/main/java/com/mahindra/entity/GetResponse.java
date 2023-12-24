package com.mahindra.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetResponse {

    private String message;
    private List<User> data;


}
