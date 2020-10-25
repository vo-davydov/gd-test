package org.example.controller;

import org.example.dto.OkopfDto;
import org.example.service.OkopfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/okopf")
@RestController
public class OkopfController {
    private final OkopfService service;

    @Autowired
    public OkopfController(OkopfService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    ResponseEntity<OkopfDto> getOneOkopf(@PathVariable Long id) {
        OkopfDto okopfDto = service.get(id);
        return okopfDto == null ? ResponseEntity.notFound().build() : new ResponseEntity<>(okopfDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OkopfDto> createOkopf(@RequestBody OkopfDto okopfDto) {
        OkopfDto okopfSaved = service.save(okopfDto);
        return okopfSaved == null ? ResponseEntity.badRequest().build() : new ResponseEntity<>(okopfSaved, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteOkopf(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OkopfDto> changeOkopf(@RequestBody OkopfDto okopfDto, @PathVariable Long id) {
        return service.changeEntity(id, okopfDto) ? new ResponseEntity<>(service.get(id), HttpStatus.OK) : ResponseEntity.badRequest().build();
    }

    @GetMapping
    ResponseEntity<List<OkopfDto>> getOkopfs(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size,
                                             @RequestParam(defaultValue = "desc") String sort
    ) {
        return new ResponseEntity<>(service.getAllSorted(page, size, sort), HttpStatus.OK);
    }
}
