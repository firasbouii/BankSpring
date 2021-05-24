package com.example.Bank.Domain;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String password;
    private String adress;
    private String phone;


    public Client(){}
    public Client(String name,String email,String jobTitle,String password,String adress,String phone)
    {
        this.name=name;
        this.email=email;
        this.jobTitle=jobTitle;
        this.password=password;
        this.adress=adress;
        this.phone=phone;
    }
    public Long getId()
    {return  id;}
    public void setId(Long id)
    {this.id=id;}

    public String getName()
    {return  name;}
    public void setName(String name)
    {this.name=name;}

    public String getEmail()
    {return  email;}
    public void setEmail(String email)
    {this.email=email;}

    public String getJobTitle()
    {return  jobTitle;}
    public void setJobTitle(String jobTitle)
    {this.jobTitle=jobTitle;}

    public String getPassword()
    {return  password;}
    public void setPassword(String password)
    {this.password=password;}

    public String getPhone()
    {return  phone;}
    public void setPhone(String phone)
    {this.phone=phone;}

    public String toString()
    {
        return "client{"+
                "id=" + id +
                ",name'=" + name + '\''+
        ", email '=" + email + '\'' +
        "jobTitle=" + jobTitle +
                ",password'=" + password + '\'' +
        ", adress '=" + adress + '\'' +
        ", phone '=" + phone + '\'' +
        '}';


    }
}

