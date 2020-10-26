package org.example.controller;

import org.example.dto.ContributionDto;
import org.example.service.ContributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RequestMapping("/api/contribution")
@RestController
public class ContributionController {
    private final ContributionService service;

    @Autowired
    public ContributionController(ContributionService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    ResponseEntity<ContributionDto> getOneContribution(@PathVariable Long id) {
        ContributionDto contributionDto = service.get(id);
        return contributionDto == null ? ResponseEntity.notFound().build() : new ResponseEntity<>(contributionDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ContributionDto> createContribution(@RequestBody ContributionDto contributionDto) {
        ContributionDto contributionSaved = service.save(contributionDto);
        return contributionSaved == null ? ResponseEntity.badRequest().build() : new ResponseEntity<>(contributionSaved, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteContribution(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContributionDto> changeContribution(@RequestBody ContributionDto contributionDto, @PathVariable Long id) {
        return service.changeEntity(id, contributionDto) ? new ResponseEntity<>(service.get(id), HttpStatus.OK) : ResponseEntity.badRequest().build();
    }

    @GetMapping
    ResponseEntity<List<ContributionDto>> getContributions(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "10") int size,
                                                           @RequestParam(defaultValue = "desc") String sort
    ) {
        return new ResponseEntity<>(service.getAllSorted(page, size, sort), HttpStatus.OK);
    }

    @GetMapping("/search")
    ResponseEntity<List<ContributionDto>> getContributionsBy(@RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "10") int size,
                                                             @RequestParam(defaultValue = "desc") String sort,
                                                             @RequestParam(required = false) Date openDate,
                                                             @RequestParam(required = false) Double percent,
                                                             @RequestParam(required = false) Integer periodInMonth,
                                                             @RequestParam(required = false) int clientId,
                                                             @RequestParam(required = false) int bankId

    ) {
        return new ResponseEntity<>(service.getAllSortedByParam(page, size, sort, openDate, percent, periodInMonth, clientId, bankId), HttpStatus.OK);
    }

}
