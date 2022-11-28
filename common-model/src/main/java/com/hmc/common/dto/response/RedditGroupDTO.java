package com.hmc.common.dto.response;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RedditGroupDTO implements Serializable {

    private String id;

    private String name;

    private String nameUrl;

}
