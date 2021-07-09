package com.example.Aplication.model.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
@Data
@ToString
@Entity(name = "backup_notify_entity")
public class BackupNotify {
    @Column(name = "backup_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int backupId;

    @Column
    private String name;

    @Column
    private int number;

    @Column
    private int price;

    @Column
    private String status;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "item_id")
    private int itemId;

    @Column
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private String image;

    @Column
    @JsonFormat(timezone = "Asia/Bangkok",pattern = "HH.mm.ss dd-MMM-yyyy")
    private Date date = new Date();
}
