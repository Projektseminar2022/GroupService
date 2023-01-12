package de.GroupService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
public class UserLocationDTO  {
    private String location;
    LocalDateTime time;
}
