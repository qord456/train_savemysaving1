package com.savemysaving.model;

import java.util.Date;

public class CashFLow {
    Integer id, customer_id;
    Integer save;
    String category, detail;
    Date date, created_at, updated_at;

    public CashFLow(Integer id, Integer customer_id, Integer save, String category, String detail, Date date, Date created_at, Date updated_at){
        this.id = id;
        this.customer_id = customer_id;
        this.save = save;
        this.category = category;
        this.detail = detail;
        this.date = date;
        this.created_at=created_at;
        this.updated_at=updated_at;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", save=" + save +
                ", category='" + category + '\'' +
                ", detail='" + detail + '\'' +
                ", date=" + date +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
