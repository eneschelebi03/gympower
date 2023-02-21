package com.example.gympower.model.dto.display;

import java.time.LocalDateTime;
import java.util.List;

public class DisplayRecentOrderDTO {

    private long orderId;

    private long userId;

    private LocalDateTime orderedAt;

    private List<DisplayAdminOrderedProductDTO> orderItems;

    public long getOrderId() {
        return orderId;
    }

    public DisplayRecentOrderDTO setOrderId(long orderId) {
        this.orderId = orderId;
        return this;
    }

    public long getUserId() {
        return userId;
    }

    public DisplayRecentOrderDTO setUserId(long userId) {
        this.userId = userId;
        return this;
    }

    public LocalDateTime getOrderedAt() {
        return orderedAt;
    }

    public DisplayRecentOrderDTO setOrderedAt(LocalDateTime orderedAt) {
        this.orderedAt = orderedAt;
        return this;
    }

    public List<DisplayAdminOrderedProductDTO> getOrderItems() {
        return orderItems;
    }

    public DisplayRecentOrderDTO setOrderItems(List<DisplayAdminOrderedProductDTO> orderItems) {
        this.orderItems = orderItems;
        return this;
    }
}
