package com.example.electionsystem.error

import com.example.electionsystem.dto.ErrorDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.IllegalStateException

@ControllerAdvice
class ElectionsErrorAdviser : ResponseEntityExceptionHandler() {

    @ExceptionHandler(IllegalStateException::class)
    fun handleToManyCandidates(tooMany: IllegalStateException): ResponseEntity<ErrorDto> =
        ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(tooMany.message?.let { ErrorDto(it) })

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNoVoter(notfound: NoSuchElementException): ResponseEntity<ErrorDto> =
        generateErrorCause(HttpStatus.NOT_FOUND, notfound.message)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleGivenVote(givenVote: IllegalArgumentException): ResponseEntity<ErrorDto> =
        generateErrorCause(HttpStatus.FORBIDDEN, givenVote.message)

    private fun generateErrorCause(status: HttpStatus, message: String?): ResponseEntity<ErrorDto> = ResponseEntity
            .status(status)
            .body(message?.let { ErrorDto(it) })

}