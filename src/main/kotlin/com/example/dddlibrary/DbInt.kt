package com.example.dddlibrary

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional
 interface DbInt : JpaRepository<BookDataModel,Long> {



  @Query("SELECT b FROM bookDbb b WHERE name= ?1")
  fun findByName(name:String) : BookDataModel?;
 }