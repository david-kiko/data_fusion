package com.example.api.controller;

import com.example.api.entity.Input;
import com.example.api.model.ApiResponse;
import com.example.api.repository.InputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {

    @Autowired
    private InputRepository inputRepository;

    @GetMapping(value = "/get_data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<Page<Input>>> getData(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Input> data = inputRepository.findAll(PageRequest.of(page, size));
        return ResponseEntity.ok(ApiResponse.success(data));
    }

    @PostMapping(value = "/post_data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<Input>>> postData() {
        List<Input> data = inputRepository.findAll();
        return ResponseEntity.ok(ApiResponse.success(data));
    }
} 