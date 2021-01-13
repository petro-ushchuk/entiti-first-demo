package pis.lab4.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import pis.lab4.demo.dto.validation.group.OnCreate;

import javax.validation.constraints.NotBlank;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
public class ActorDto {

    @JsonProperty(access = READ_ONLY)
    private long id;

    private String firstName;

    private String lastName;

    private int yearsActive;

    private String born;

}
