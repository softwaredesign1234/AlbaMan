package model;



public class Account {

    protected String id;
    protected String password;
    protected String name;
    protected Boolean valid;
    protected Boolean isActivated;
    protected String type;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Boolean getValid() {
        return valid;
    }
    public void setValid(Boolean valid) {
        this.valid = valid;
    }
    public Boolean getIsActive() {
        return isActivated;
    }
    public void setIsActive(Boolean isActive) {
        this.isActivated = isActive;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }



}