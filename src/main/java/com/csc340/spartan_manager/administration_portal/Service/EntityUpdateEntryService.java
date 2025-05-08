package com.csc340.spartan_manager.administration_portal.Service;

import com.csc340.spartan_manager.administration_portal.Repository.EntityUpdateEntryRepository;
import com.csc340.spartan_manager.administration_portal.Entity.EntityUpdateEntry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityUpdateEntryService {
    @Autowired
    private EntityUpdateEntryRepository updateRepo;


    public List<EntityUpdateEntry> getAllUpdates() {
        return updateRepo.findAll();
    }

    public EntityUpdateEntry addUpdate(EntityUpdateEntry entry) {
        return updateRepo.save(entry);
    }

    public List<EntityUpdateEntry> getUpdatesByTable(String tableName) {
        return updateRepo.findAll().stream()
                .filter(entry -> entry.getTableName().equalsIgnoreCase(tableName))
                .toList();
    }

    public List<EntityUpdateEntry> getUpdatesByEntityId(int entityId) {
        return updateRepo.findAll().stream()
                .filter(entry -> entry.getEntityId() == entityId)
                .toList();
    }
    public void logUpdate(int entityId, String updateType, String tableName, String fieldChanged,
                          String oldValue, String newValue, String detail) {
        EntityUpdateEntry entry = new EntityUpdateEntry();
        entry.setEntityId(entityId);
        entry.setUpdateType(updateType);
        entry.setTableName(tableName);
        entry.setFieldChanged(fieldChanged);
        entry.setOldValue(oldValue);
        entry.setNewValue(newValue);
        entry.setUpdateDetail(detail);
        updateRepo.save(entry);
    }

}
