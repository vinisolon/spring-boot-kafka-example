package com.vinisolon.app.dtos;

import lombok.Data;

@Data
public class Request {

    private Long id;
    private String message;
    private InnerRequest innerRequest;

}
