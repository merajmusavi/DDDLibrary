package com.example.dddlibrary

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional
 interface DbInt : JpaRepository<BookDataModel,Long> {


 }