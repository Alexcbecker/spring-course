package com.course.springcourse.resource;

import com.course.springcourse.domain.RequestStage;
import com.course.springcourse.service.RequestStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "requestStages")
public class RequestStageResource {

    @Autowired
    private RequestStageService requestStageService;

    @PostMapping
    public ResponseEntity<RequestStage> save(@RequestBody RequestStage requestStage) {
        RequestStage createdRequestStage = requestStageService.save(requestStage);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequestStage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestStage> getById(@PathVariable(name = "id") Long id) {
        RequestStage stage = requestStageService.getById(id);
        return ResponseEntity.ok(stage);
    }
}
