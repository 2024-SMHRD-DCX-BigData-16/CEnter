package com.center.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Question {
   private int qes_idx;
   private Timestamp created_at;

   @NonNull
   private String qes_content;
   
   @NonNull
   private String qes_category;
   
   @NonNull
   private String qes_item;
   
   private int qes_point;
}
