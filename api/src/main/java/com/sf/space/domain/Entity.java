package com.sf.space.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by adityasofat on 31/03/2017.
 */
public class Entity {
    private final EntityType entityType;
    private final Map<EntityType,Entity> entities = new HashMap<>();
    private final Map<EntityItem,Object> entityItems = new HashMap<>();


    public Entity(EntityType entityType) {
        this.entityType = entityType;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void addEntity(Entity entity){
        entities.put(entity.getEntityType(),entity);
    }

    public Entity addEntityItem(EntityItem entityItem, Object value){
        entityItems.put(entityItem,value);
        return this;
    }

    public <T> T getEntityItem(EntityItem entityItem, Class<T> clazz){
        return clazz.cast(entityItems.get(entityItem));
    }

    public BigDecimal  getEntityItemBigDecimal(EntityItem entityItem){
        return BigDecimal.valueOf(Double.class.cast(entityItems.get(entityItem)));
    }

    public String getEntityItem(EntityItem entityItem){
        return String.class.cast(entityItems.get(entityItem));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return entityType == entity.entityType &&
                Objects.equals(entities, entity.entities) &&
                Objects.equals(entityItems, entity.entityItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entityType, entities, entityItems);
    }
}
