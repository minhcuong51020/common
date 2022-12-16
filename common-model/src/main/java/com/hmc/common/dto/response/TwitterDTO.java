package com.hmc.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TwitterDTO implements Serializable {

    private String id;

    private String name;

    private String consumerKey;

    private String consumerSecret;

    private String oauthToken;

    private String oauthTokenSecret;

}
