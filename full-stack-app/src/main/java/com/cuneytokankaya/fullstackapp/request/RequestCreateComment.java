package com.cuneytokankaya.fullstackapp.request;

import lombok.Data;

@Data
public class RequestCreateComment {
    private Long userId;
    private Long postId;
    private String text;
}
