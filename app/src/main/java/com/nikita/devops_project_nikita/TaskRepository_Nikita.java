package com.nikita.devops_project_nikita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository_Nikita extends JpaRepository<Task_Nikita, Long> {
}