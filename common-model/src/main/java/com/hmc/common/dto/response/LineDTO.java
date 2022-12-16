package com.hmc.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LineDTO implements Serializable {

    private String id;

    private String channelToken;

    private String channelName;

    private LocalDate createdAt;

    private LocalDate modifiedAt;

}
