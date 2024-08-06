package dev.bhuwanupadhyay.demo.inventory.application.queries;

import dev.bhuwanupadhyay.demo.inventory.application.queries.ProductQuery.AppError;
import dev.bhuwanupadhyay.demo.inventory.application.queries.ProductQuery.QueryListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(
    value = {
        @ApiResponse(responseCode = "200", description = "Ok", content = {
            @Content(schema = @Schema(implementation = QueryListResponse.class))}),
        @ApiResponse(responseCode = "400", description = "Bad Request", content = {
            @Content(schema = @Schema(implementation = AppError.class))}),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
            @Content(schema = @Schema(implementation = AppError.class))}),
        @ApiResponse(responseCode = "403", description = "User not authorized to perform the action.", content = {
            @Content(schema = @Schema(implementation = AppError.class))}),
        @ApiResponse(responseCode = "404", description = "Not Found", content = {
            @Content(schema = @Schema(implementation = AppError.class))}),
        @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
            @Content(schema = @Schema(implementation = AppError.class))}),
        @ApiResponse(responseCode = "502", description = "Bad Gateway", content = {
            @Content(schema = @Schema(implementation = AppError.class))}),
        @ApiResponse(responseCode = "503", description = "Service Unavailable", content = {
            @Content(schema = @Schema(implementation = AppError.class))})
    }
)
public @interface QueryApiResponse {

}