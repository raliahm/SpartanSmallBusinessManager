package com.csc340.spartan_manager.administration_portal.Controller;

import com.csc340.spartan_manager.administration_portal.Entity.EntityUpdateEntry;
import com.csc340.spartan_manager.administration_portal.Service.EntityUpdateEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/updates")
public class EntityUpdateEntryController {

    @Autowired
    private EntityUpdateEntryService updateService;

    @GetMapping("/all")
    public List<EntityUpdateEntry> getAllUpdates() {
        return updateService.getAllUpdates();
    }

    @PostMapping("/add")
    public EntityUpdateEntry addUpdate(@RequestBody EntityUpdateEntry entry) {
        return updateService.addUpdate(entry);
    }

    @GetMapping("/table/{tableName}")
    public List<EntityUpdateEntry> getByTable(@PathVariable String tableName) {
        return updateService.getUpdatesByTable(tableName);
    }

    @GetMapping("/entity/{entityId}")
    public List<EntityUpdateEntry> getByEntity(@PathVariable int entityId) {
        return updateService.getUpdatesByEntityId(entityId);
    }
}
