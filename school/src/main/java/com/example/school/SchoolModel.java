package com.example.school;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
public class SchoolModel {
    public Integer Id;
    public String Name;
    public String Description;
    public LocalDateTime PublicationDate;
    public List<StudentModel> students;

    public SchoolModel(School school) {
        this.Id = school.Id;
        this.Name = school.Name;
        this.Description = school.Description;
        this.PublicationDate = school.PublicationDate;
    }
}
