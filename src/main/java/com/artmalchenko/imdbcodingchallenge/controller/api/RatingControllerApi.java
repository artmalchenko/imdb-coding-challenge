package com.artmalchenko.imdbcodingchallenge.controller.api;

import com.artmalchenko.imdbcodingchallenge.dto.RatingDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface RatingControllerApi {

    @Operation(summary = "Submit film rating.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created the rating.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = RatingDto.class))})})
    ResponseEntity<RatingDto> submitRating(@RequestBody RatingDto ratingDto);

}
