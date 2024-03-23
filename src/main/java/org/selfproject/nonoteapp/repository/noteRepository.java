package org.selfproject.nonoteapp.repository;

import org.selfproject.nonoteapp.model.noteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface noteRepository extends JpaRepository<noteEntity,String> {
}
