package ru.skillbench.tasks.basics.entity;

public class LocationImpl implements Location {

    private String name;
    private Type type;
    private Location parent;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public void setParent(Location parent) {
        this.parent = parent;
    }

    @Override
    public String getParentName() {
        if (parent == null) {
            return "--";
        }
        return parent.getName();
    }

    @Override
    public Location getTopLocation() {
        if (parent != null) {
            return parent.getTopLocation();
        }
        else {
            return this;
        }
    }

    @Override
    public boolean isCorrect() {
        if (parent == null) {
            return true;
        }
        if (parent.getType().compareTo(type) < 0) {
            return parent.isCorrect();
        }
        else {
            return false;
        }
    }

    @Override
    public String getAddress() {
        if (name.endsWith(".") || name.indexOf('.') < name.indexOf(' ')) {
            return (parent != null) ? name + ", " + parent.getAddress() : name;
        }
        else {
            return (parent != null) ? type.getNameForAddress() + name + ", " + parent.getAddress() : type.getNameForAddress() + name;
        }
    }

    @Override
    public String toString() {
        return name + " (" + type + ")";
    }
}