package com.example.jsondemo.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity(name = "ItemAreaStockZone")
public class Item {
    @Id
    @GenericGenerator(name = "item_id_seq" , strategy = "increment")
    @GeneratedValue(generator="item_id_seq",strategy = GenerationType.AUTO)
    private Long id;

    private String itemCode;

    private String areaCode;

    private String zoneCode;

    private Long demand;

    private Long inventory;

    private Double doi;

    private Long qtyToReachDoi;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemCode='" + itemCode + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", zoneCode='" + zoneCode + '\'' +
                ", demand=" + demand +
                ", inventory=" + inventory +
                ", doi=" + doi +
                ", qtyToReachDoi=" + qtyToReachDoi +
                '}';
    }
}
