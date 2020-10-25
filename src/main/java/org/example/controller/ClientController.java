package org.example.controller;

import org.example.dto.ClientDto;
import org.example.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/client")
@RestController
public class ClientController {
    private final ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    ResponseEntity<ClientDto> getOneClient(@PathVariable Long id) {
        ClientDto clientDto = service.get(id);
        return clientDto == null ? ResponseEntity.notFound().build() : new ResponseEntity<>(clientDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto) {
        ClientDto clientSaved = service.save(clientDto);
        return clientSaved == null ? ResponseEntity.badRequest().build() : new ResponseEntity<>(clientSaved, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> changeClient(@RequestBody ClientDto clientDto, @PathVariable Long id) {
        return service.changeEntity(id, clientDto) ? new ResponseEntity<>(service.get(id), HttpStatus.OK) : ResponseEntity.badRequest().build();
    }

    @GetMapping
    ResponseEntity<List<ClientDto>> getClients(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size,
                                             @RequestParam(defaultValue = "desc") String sort
    ) {
        return new ResponseEntity<>(service.getAllSorted(page, size, sort), HttpStatus.OK);
    }
}
