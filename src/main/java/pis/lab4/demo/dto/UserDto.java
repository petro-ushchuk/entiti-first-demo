package pis.lab4.demo.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import pis.lab4.demo.dto.validation.FieldMatch;
import pis.lab4.demo.dto.validation.UniqueEmail;
import pis.lab4.demo.dto.validation.group.OnRegister;
import pis.lab4.demo.dto.validation.group.OnSignIn;
import pis.lab4.demo.dto.validation.group.OnUpdate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;
import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Data
@FieldMatch(first = "password", second = "repeatPassword",
    groups = OnRegister.class, message = "{password.field.not.match}")
public class UserDto {

  @JsonProperty(access = READ_ONLY)
  private long id;

  @NotBlank(groups = OnRegister.class, message = "{name.blank}")
  @Null(groups = OnSignIn.class, message = "{name.not.null}")
  private String firstName;

  @NotBlank(groups = OnRegister.class, message = "{surname.blank}")
  @Null(groups = OnSignIn.class, message = "{surname.not.null}")
  private String secondName;

  @Null(groups = OnUpdate.class, message = "{password.not.null}")
  @NotBlank(groups = {OnRegister.class, OnSignIn.class}, message = "{password.blank}")
  private String password;

  @JsonProperty(access = WRITE_ONLY)
  @Null(groups = {OnUpdate.class, OnSignIn.class}, message = "{repeatPassword.not.null}")
  @NotBlank(groups = OnRegister.class, message = "{repeatPassword.blank}")
  private String repeatPassword;

  @ApiModelProperty(notes = "Unique user's email")
  @NotBlank(groups = {OnRegister.class, OnSignIn.class}, message = "{email.blank}")
  @Email(message = "{email.wrong.format}")
  @UniqueEmail(groups = {OnRegister.class, OnUpdate.class})
  private String email;

}
