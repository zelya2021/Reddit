package com.example.redditapp.models;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Information {
    private String author;//taxt
    private String date;
    private String picture;
    private String comment;
}
