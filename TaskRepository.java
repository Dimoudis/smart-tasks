package com.myapp.smarttasks;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository δίνει έτοιμες CRUD μεθόδους
// save(task) → δημιουργεί ή ενημερώνει task
// findAll() → παίρνει όλα τα tasks
// findById(id) → παίρνει ένα task με συγκεκριμένο id
// deleteById(id) → διαγράφει task με συγκεκριμένο id
 public interface TaskRepository extends JpaRepository<Task, Integer> {
}
