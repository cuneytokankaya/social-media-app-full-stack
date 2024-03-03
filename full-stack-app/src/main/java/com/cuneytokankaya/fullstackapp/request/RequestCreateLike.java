package com.cuneytokankaya.fullstackapp.request;

import lombok.Data;

@Data
public class RequestCreateLike {
    private Long userId;
    private Long postId;
}
