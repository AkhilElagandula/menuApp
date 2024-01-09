package com.springboot.menuapp.menuapp.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
@Document("api/v1/admin")//Marks the class as a MongoDB document and specifies the collection name.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id//Marks the primary key field.
    private String id;
    private String name;
    @Indexed(unique = true)//Specifies indexing for the field.
    private String email;
    @Indexed
    private String phone;
    private String password;
    @Transient//Indicates that a field should not be persisted to the database.
    private String photo;
    @CreatedDate//Automatically populate the creation and last modification timestamps.
    private Date createdAt;
    @LastModifiedDate//Automatically populate the creation and last modification timestamps.
    private Date passwordChangedAt;

    private String passwordResetToken;

    private Date passwordResetExpires;

    private boolean active = true;
    @Field("role")//Allows specifying the field name in MongoDB.
    private String  roles;
//    public enum AdminRole {
//        SUPER,
//        SUB
//    }
}
