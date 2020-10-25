package org.example.controller;

import org.example.dto.BankDto;
import org.example.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/bank")
@RestController
public class BankController {
    private final BankService service;

    @Autowired
    public BankController(BankService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    ResponseEntity<BankDto> getOneBank(@PathVariable Long id) {
        BankDto bankDto = service.get(id);
        return bankDto == null ? ResponseEntity.notFound().build() : new ResponseEntity<>(bankDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BankDto> createBank(@RequestBody BankDto bankDto) {
        BankDto bankSaved = service.save(bankDto);
        return bankSaved == null ? ResponseEntity.badRequest().build() : new ResponseEntity<>(bankSaved, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteBank(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankDto> changeBank(@RequestBody BankDto bankDto, @PathVariable Long id) {
        return service.changeEntity(id, bankDto) ? new ResponseEntity<>(service.get(id), HttpStatus.OK) : ResponseEntity.badRequest().build();
    }

    @GetMapping
    ResponseEntity<List<BankDto>> getBanks(@RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size,
                                               @RequestParam(defaultValue = "desc") String sort
    ) {
        return new ResponseEntity<>(service.getAllSorted(page, size, sort), HttpStatus.OK);
    }
}
