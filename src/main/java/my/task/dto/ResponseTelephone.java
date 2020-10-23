package my.task.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ApiModel(description = "output model telephones")
public class ResponseTelephone {
    @ApiModelProperty(name = "numbers", value = "list of numbers")
    private List<String> numbers;
}
