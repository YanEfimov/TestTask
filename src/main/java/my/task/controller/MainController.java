package my.task.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.Setter;
import my.task.dto.CardDto;
import my.task.dto.ClientDto;
import my.task.dto.ResponseCard;
import my.task.dto.ResponseClient;
import my.task.dto.ResponseTelephone;
import my.task.service.MainService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;


@RestController
@Validated
@RequestMapping(value = "/api")
@AllArgsConstructor
@Api(value = "api", description = "api for bank")
public class MainController {
    private final MainService service;

    @ApiOperation(value = "create client", notes = "method for create client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "response.ok", response = ResponseClient.class)
    })
    @PostMapping(value = "/client")
    ResponseEntity createClient(@RequestBody @Valid ClientDto clientDto) {
        return service.createClient(clientDto);
    }

    @ApiOperation(value = "create card", notes = "method for create card")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "response.ok", response = ResponseCard.class)
    })
    @PostMapping(value = "/card")
    ResponseEntity createCard(@RequestBody @Valid CardDto cardDto) {
        return service.createCard(cardDto);
    }

    @ApiOperation(value = "get telephones", notes = "method for get telephones")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "response.ok", response = ResponseTelephone.class)
    })
    @GetMapping(value = "/telephone")
    ResponseEntity getTelephones(
            @ApiParam(name = "pageRowCount", value = "page row count")
            @RequestParam(name = "pageRowCount",required = true, defaultValue = "50")
            @Min(value = 1) int pageRowCount,

            @ApiParam(name = "pageNo", value = "page number")
            @RequestParam(name = "pageNo", required = true, defaultValue = "1")
            @Min(value = 1) int pageNo,

            @ApiParam(name = "typeCard", value = "type card")
            @RequestParam(name = "typeCard", required = true)
            @Pattern(regexp = "Classic|Gold|Platinum") String typeCard,

            @ApiParam(name = "currency", value = "currency")
            @RequestParam(name = "currency", required = true)
            @Pattern(regexp = "BYN|USD|EUR") String currency) {
        return service.getTelephones(pageNo, pageRowCount, typeCard, currency);
    }
}
