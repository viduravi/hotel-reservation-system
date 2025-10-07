package model.dto;

import lombok.*;



public class room_info_DTO {
    private String roomId;
    private String type;
    private String description;
    private String price;

    public String getRoomId() {
        return roomId;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public room_info_DTO(String roomId, String type, String description, String price) {
        this.roomId = roomId;
        this.type = type;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "room_info_DTO{" +
                "roomId='" + roomId + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
