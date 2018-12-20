package by.itsm.patients.web.controller;

import by.itsm.patients.common.entity.IEntity;
import by.itsm.patients.web.model.IDto;
import by.itsm.patients.web.service.ICrudService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AbstractCrudController<E extends IEntity, D extends IDto> {

    private final ICrudService<E, D> service;

    public AbstractCrudController(ICrudService<E, D> service) {
        this.service = service;
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody D dto) {
        service.save(dto);
    }

    @GetMapping("/{id}")
    public D find(@PathVariable("id") Integer id) {
        return service.find(id);
    }

    @GetMapping("/list")
    public List<D> findAll() {
        return service.findAll();
    }
}
