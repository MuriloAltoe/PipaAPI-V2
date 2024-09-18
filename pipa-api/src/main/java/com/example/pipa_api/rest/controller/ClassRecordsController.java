package com.example.pipa_api.rest.controller;

import com.example.pipa_api.domain.entity.ClassRecords;
import com.example.pipa_api.service.ClassRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/class_records")
public class ClassRecordsController {

    private final ClassRecordsService classRecordsService;

    @Autowired
    public ClassRecordsController(ClassRecordsService classRecordsService) {
        this.classRecordsService = classRecordsService;
    }

    @GetMapping
    public ResponseEntity<List<ClassRecords>> getAllRecords() {
        List<ClassRecords> records = classRecordsService.findAll();
        return ResponseEntity.ok(records);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassRecords> getRecordById(@PathVariable Long id) {
        Optional<ClassRecords> record = classRecordsService.findById(id);
        return record.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ClassRecords> createRecord(@RequestBody ClassRecords classRecords) {
        ClassRecords savedRecord = classRecordsService.save(classRecords);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRecord);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassRecords> updateRecord(@PathVariable Long id, @RequestBody ClassRecords classRecords) {
        if (!classRecordsService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        classRecords.setId(id);
        ClassRecords updatedRecord = classRecordsService.save(classRecords);
        return ResponseEntity.ok(updatedRecord);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
        if (!classRecordsService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        classRecordsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}