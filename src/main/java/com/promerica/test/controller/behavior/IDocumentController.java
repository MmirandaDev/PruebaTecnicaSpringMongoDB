package com.promerica.test.controller.behavior;

import com.promerica.test.data.document.Documents;
import com.promerica.test.data.model.DocumentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@Component
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public interface IDocumentController {

    @GetMapping(path = "/all", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    ResponseEntity<?> getAll();

    @GetMapping(path = "/find/{id}", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    Documents find(@PathVariable Long id);

    @PostMapping(value = "/save", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    ResponseEntity<?> save(@RequestBody DocumentRequest request);

    @PutMapping(value = "/update", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    ResponseEntity<?> update(@RequestBody DocumentRequest request);


    @DeleteMapping(value = "/delete/{id}", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    ResponseEntity<?> delete(@PathVariable Long id);
}
