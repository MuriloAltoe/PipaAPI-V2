package com.example.pipa_api.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.pipa_api.domain.entity.ClassRecords;
import com.example.pipa_api.domain.entity.Employee;
import com.example.pipa_api.domain.entity.Students;
import com.example.pipa_api.rest.dto.ClassRecordsDTO;
import com.example.pipa_api.service.ClassRecordsService;
import com.example.pipa_api.service.EmployeeService;
import com.example.pipa_api.service.StudentsService;

@RestController
@RequestMapping("/api/class_records")
public class ClassRecordsController {

    private final ClassRecordsService classRecordsService;
    private final StudentsService studentsService;
    private final EmployeeService employeeService;

    @Autowired
    public ClassRecordsController(ClassRecordsService classRecordsService, StudentsService studentsService, EmployeeService employeeService) {
        this.classRecordsService = classRecordsService;
        this.studentsService = studentsService;
        this.employeeService = employeeService;
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
    public ResponseEntity<ClassRecords> createRecord(@RequestBody ClassRecordsDTO classRecordsDTO) {

        ClassRecords classRecords = classRecordsDTO.toOBJ(classRecordsDTO);

        Optional<Students> student = studentsService.findById(classRecordsDTO.getStudent());
        if(student.isPresent()){
            classRecords.setStudent(student.get());
        }

        Optional<Employee> employee = employeeService.findById(classRecordsDTO.getEmployee());
        if(employee.isPresent()){
            classRecords.setEmployee(employee.get());
        }

        ClassRecords savedRecord = classRecordsService.insert(classRecords);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRecord);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassRecords> updateRecord(@PathVariable Long id, @RequestBody ClassRecords classRecords) {
        if (!classRecordsService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        classRecords.setId(id);
        ClassRecords updatedRecord = classRecordsService.insert(classRecords);
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