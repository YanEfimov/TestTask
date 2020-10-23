package my.task.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@ApiModel(description = "input model card")
public class CardDto {
    @ApiModelProperty(name = "clientId", value = "client id")
    @Min(value = 1)
    private Long clientId;

    @NotEmpty
    @ApiModelProperty(name = "number", value = "number card")
    private String number;

    @NotEmpty
    @Pattern(regexp = "BYN|USD|EUR")
    @ApiModelProperty(name = "currency", value = "currency card")
    private String currency;

    @NotEmpty
    @Pattern(regexp = "Classic|Gold|Platinum")
    @ApiModelProperty(name = "type", value = "type card")
    private String type;
}
