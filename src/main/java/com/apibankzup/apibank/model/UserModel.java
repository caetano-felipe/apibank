package com.apibankzup.apibank.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tb_users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotEmpty(message = "O campo Nome, não pode ser vazio!")
    private String name;

    @Column(unique = true)
    @NotNull
    @NotEmpty(message = "O campo E-mail, não pode ser vazio!")
    @Email
    private String email;

    @NotNull
    @NotEmpty(message = "O campo Senha, não pode ser vazio!")
    private String password;

    @Column(unique = true)
    @NotNull
    @NotEmpty(message = "O campo CPF, não pode ser vazio!")
    private String cpf;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new java.sql.Date(System.currentTimeMillis());

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
