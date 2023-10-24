package com.example.contact;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Data
@Document
@Entity
public class Contact {

    @Id
    private String id;
    @NotNull
    @Size(min = 1,message = "名字必须至少1个字符")
    private String firstName;
    @NotNull
    @Size(min=1,message = "名字必须至少1个字符")
    private String lastName;
    @Pattern(regexp = "^1([34578])\\d{9}$",message = "无效的手机号码")
    private String phoneNumber;
    @NotBlank(message = "不能为空")
    @Email
    private String emailAddress;
/**
    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(firstName, contact.firstName) && Objects.equals(lastName, contact.lastName) && Objects.equals(phoneNumber, contact.phoneNumber) && Objects.equals(emailAddress, contact.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber, emailAddress);
    }*/
}