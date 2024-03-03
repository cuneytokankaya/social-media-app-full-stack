package com.cuneytokankaya.fullstackapp.request;

import lombok.Data;

@Data
public class RequestCreatePost {
    private Long id;
    private String title;
    private String text;
    private Long userId;
}
