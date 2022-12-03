package model;

public class Account {
    private String id;
    private String password;
    private String name;
    private Boolean valid;
    private Boolean isActive = true;
    private String type;

    public Account(String id, String password, String name, String type) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.type = type;
    }

    public Account(String id) {
        this.id = id;
    }

    //private boolean illegal;



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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
