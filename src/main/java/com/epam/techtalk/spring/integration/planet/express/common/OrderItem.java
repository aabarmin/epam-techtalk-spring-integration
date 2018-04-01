package com.epam.techtalk.spring.integration.planet.express.common;

/**
 * Part of order.
 */
public class OrderItem {
    private boolean isProcessed;
    private String description;
    private ItemActionType actionType;

    public OrderItem() {
    }

    public OrderItem(String description) {
        this.description = description;
    }

    public OrderItem(String description, ItemActionType actionType) {
        this.description = description;
        this.actionType = actionType;
    }

    /**
     * Getter for description.
     *
     * @return java.lang.String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for description.
     *
     * @param description value
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for actionType.
     *
     * @return com.epam.techtalk.spring.integration.planet.express.common.ItemActionType
     */
    public ItemActionType getActionType() {
        return actionType;
    }

    /**
     * Setter for actionType.
     *
     * @param actionType value
     */
    public void setActionType(ItemActionType actionType) {
        this.actionType = actionType;
    }

    /**
     * Getter for isProcessed.
     *
     * @return boolean
     */
    public boolean isProcessed() {
        return isProcessed;
    }

    /**
     * Setter for isProcessed.
     *
     * @param processed value
     */
    public void setProcessed(boolean processed) {
        isProcessed = processed;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "isProcessed=" + isProcessed +
                ", description='" + description + '\'' +
                ", actionType=" + actionType +
                '}';
    }
}
