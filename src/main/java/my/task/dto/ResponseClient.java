package my.task.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@ApiModel(description = "output model client")
public class ResponseClient {
    @ApiModelProperty(name = "clientId", value = "client id")
    private Long clientId;
}
