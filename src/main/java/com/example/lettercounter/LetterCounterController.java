package com.example.lettercounter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Tag(name="LetterCounterController", description="В данном контроллере содержится метод для обработки строки и дальнейшего расчёта количества символов в ней.")
public class LetterCounterController {
    LetterCounterService letterCounterService;

    final String ERROR = "Строка должна состоять только из маленьких латинских букв и кириллицы";

    public LetterCounterController(LetterCounterService letterCounterService) {
        this.letterCounterService = letterCounterService;
    }
    @Operation(
            summary = "Результат расчёта",
            description = "Возвращает результат расчёта символов"
    )
    @GetMapping("/letterCounter/{str}")
    public ResponseEntity<?> getResultMap(@PathVariable @Parameter(description = "Исходная строка в формате строчных букв латиницы и/или кириллицы.") String str) {
        if (!str.matches("[a-zа-я]+")) {
            return new ResponseEntity<>(
                    ERROR,
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(letterCounterService.countLetters(str), HttpStatus.OK);
    }
}
