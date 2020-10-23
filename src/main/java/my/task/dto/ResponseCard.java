package my.task.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@ApiModel(description = "output model Card")
public class ResponseCard {
    @ApiModelProperty(name = "cardId", value = "card id")
    private Long cardId;
}
