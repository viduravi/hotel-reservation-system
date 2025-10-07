package model.dto;

public class customer_info_DTO {
    private String id;
    private String name;
    private String phone;
    private String city;
    private String address;
    public customer_info_DTO(String id, String name, String phone, String city, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.city = city;
        this.address = address;
    }

    @Override
    public String toString() {
        return "customer_info_DTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
