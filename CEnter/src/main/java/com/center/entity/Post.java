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
public class Post {
   private int post_idx;
   @NonNull
   private String post_title;
   @NonNull
   private String post_content;
   private String post_file;
   private int post_views;
   private int post_likes;
   private Timestamp created_at;
   private String mb_id;
   
  
   
}
