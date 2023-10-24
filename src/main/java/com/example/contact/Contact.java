package com.example.contact;

import java.util.Objects;
import lombok.Data;

import javax.validation.constraints.*;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PUBLIC, force=true)
public class Contact{
    private String id;

    @NotNull
    @Size(min = 1, message = "名字必须至少1个字符")
    private String firstName;

    @NotNull
    @Size(min = 1, message = "名字必须至少1个字符")
    private String lastName;

    @Pattern(regexp = "^1([345678])\\d{9}$", message = "无效的手机号码")
    private String phoneNumber;

    @NotBlank(message="不能为空")
    @Email
    private String emailAddress;

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " : " + this.phoneNumber + ", " + this.emailAddress;
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
    }
}