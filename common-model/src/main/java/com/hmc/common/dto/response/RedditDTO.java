package com.hmc.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedditDTO implements Serializable {

    private String id;

    private String nameDisplay;

    private String clientId;

    private String clientSecret;

    private String username;

    private String password;

    private String ownerId;

}
