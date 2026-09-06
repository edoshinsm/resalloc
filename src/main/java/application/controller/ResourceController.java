package application.controller;

import application.dto.CreateResourceRequest;
import application.dto.ResourceDto;
import application.model.EntityResource;
import application.repositories.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/resources")
@RequiredArgsConstructor
public class ResourceController {
    private final ResourceRepository resourceRepository;

    @GetMapping
    public List<ResourceDto> getAll() {
        return resourceRepository.findAll().stream().map(r -> new ResourceDto(r.getId(), r.getName()))
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResourceDto create(@RequestBody CreateResourceRequest request) {
        EntityResource resource = new EntityResource();
        resource.setName(request.name());
        EntityResource saved = resourceRepository.save(resource);
        return new ResourceDto(saved.getId(), saved.getName());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        resourceRepository.deleteById(id);
    }
}