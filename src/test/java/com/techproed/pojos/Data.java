package com.techproed.pojos;

public class Data {

    private Integer id;
    private String employee_name;
    private Integer employee_salary;
    private Integer employee_age;
    private String profile_image;

    /**
     * No args constructor for use in serialization
     *
     */
    public Data() {
    }

    /**
     *
     * @param employee_name
     * @param employee_age
     * @param id
     * @param profile_image
     * @param employee_salary
     */
    public Data(Integer id, String employee_name, Integer employee_salary, Integer employee_age, String profile_image) {
        super();
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getemployee_name() {
        return employee_name;
    }

    public void setemployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Integer getemployee_salary() {
        return employee_salary;
    }

    public void setemployee_salary(Integer employee_salary) {
        this.employee_salary = employee_salary;
    }

    public Integer getemployee_age() {
        return employee_age;
    }

    public void setemployee_age(Integer employee_age) {
        this.employee_age = employee_age;
    }

    public String getprofile_image() {
        return profile_image;
    }

    public void setprofile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Data.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("employee_name");
        sb.append('=');
        sb.append(((this.employee_name == null)?"<null>":this.employee_name));
        sb.append(',');
        sb.append("employee_salary");
        sb.append('=');
        sb.append(((this.employee_salary == null)?"<null>":this.employee_salary));
        sb.append(',');
        sb.append("employee_age");
        sb.append('=');
        sb.append(((this.employee_age == null)?"<null>":this.employee_age));
        sb.append(',');
        sb.append("profile_image");
        sb.append('=');
        sb.append(((this.profile_image == null)?"<null>":this.profile_image));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}
