package my.task.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@ApiModel(description = "input model client")
public class ClientDto {
    @NotEmpty
    @ApiModelProperty(name = "fullName", value = "full name client")
    private String fullName;

    @NotEmpty
    @ApiModelProperty(name = "telephone", value = "telephone client")
    private String telephone;

    @NotEmpty
    @Email
    @ApiModelProperty(name = "email", value = "email client")
    private String email;
}
