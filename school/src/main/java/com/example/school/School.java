package com.example.school;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class School {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer Id;
    public String Name;
    public String Description;
    public LocalDateTime PublicationDate;
}
